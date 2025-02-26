package com.aspire.mykotlicour.fragment

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.aspire.mykotlicour.databinding.FragmentAddDeviceBinding
import com.aspire.mykotlicour.interfaces.DeviceOpertions
import com.aspire.mykotlicour.model.Data
import com.aspire.mykotlicour.model.Device
import com.aspire.mykotlicour.viewmodel.AddDeviceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddDeviceFragment : Fragment() {

    private lateinit var binding: FragmentAddDeviceBinding

    companion object {
        fun newInstance() = AddDeviceFragment()
    }

    private val viewModel: AddDeviceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddDeviceBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSave.setOnClickListener {
            var dataVa =  Data("","",  binding.editTextYear.text.toString(),binding.editTextPrice.text.toString(),binding.editTextModel.text.toString(),"")
            var data = Device("",binding.editTextName.text.toString(), dataVa, "")
            viewModel.saveDevice(data)

        }

        viewModel.deviceResp.observe(viewLifecycleOwner, Observer { value ->
            if(value.isSuccessful){
                Toast.makeText(context, "Saved", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context, "Sorry!! Not able to save", Toast.LENGTH_SHORT).show()
            }
        })
    }


}