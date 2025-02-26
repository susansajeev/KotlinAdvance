package com.aspire.mykotlicour.fragment

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aspire.mykotlicour.viewmodel.ListViewModel
import com.aspire.mykotlicour.R
import com.aspire.mykotlicour.adapter.DeviceAdapter
import com.aspire.mykotlicour.databinding.ActivityHomePageBinding
import com.aspire.mykotlicour.databinding.FragmentListBinding
import com.aspire.mykotlicour.interfaces.DeviceOpertions
import com.aspire.mykotlicour.model.Device
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(), DeviceOpertions {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = ListFragment()
    }

    private val listViewModel: ListViewModel by viewModels()
    private lateinit var deviceAdapter: DeviceAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressBar.visibility = View.VISIBLE

        listViewModel.deviceResp.observe(viewLifecycleOwner, Observer { value ->
            Log.e("Susan","22")
            binding.progressBar.visibility = View.GONE
            value.body()?.let {
                Log.e("Susan","333"+ value.body()!!.size)
                setUI(value.body())
            }
        })

    }

    private fun setUI(value: List<Device>?) {

        deviceAdapter = DeviceAdapter(this)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = deviceAdapter
        }
        deviceAdapter.submitList(value!!)

    }

    override fun onDeleteClick(item: Device) {
        listViewModel.deleteItem(item)
        listViewModel.deviceDeleteResp.observe(viewLifecycleOwner, Observer { value ->
            if(value.isSuccessful)
            Toast.makeText(context, "Deleted : "+value.body()!!.message, Toast.LENGTH_SHORT).show()
            else{
                Toast.makeText(context, "Delete operation not possible ", Toast.LENGTH_SHORT).show()
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root


    }
}