package com.aspire.mykotlicour.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aspire.mykotlicour.R
import com.aspire.mykotlicour.interfaces.DeviceOpertions
import com.aspire.mykotlicour.model.Device
import javax.inject.Inject

class DeviceAdapter @Inject constructor(private val deviceOpertions: DeviceOpertions)  : RecyclerView.Adapter<DeviceAdapter.ViewHolder>() {

    private var deviceList: List<Device> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_device, parent, false)
        Log.e("Susan","created == ")
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeviceAdapter.ViewHolder, position: Int) {
        val item = deviceList[position]
        Log.e("Susan","4 == "+item.name)
        holder.textDeviceName.text = item.name
        holder.textDeleteName.setOnClickListener {
            deviceOpertions.onDeleteClick(item)
        }
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemCount() = deviceList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textDeviceName: TextView = itemView.findViewById(R.id.textDeviceName)
        val textDeleteName: Button = itemView.findViewById(R.id.textDeleteName)
    }



    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: List<Device>) {
        Log.e("Susan","33"+newList.size)
        deviceList = newList
        notifyDataSetChanged()

    }
}