package com.test.myhealth.app.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.myhealth.databinding.ItemPhysicalInfoNoteBinding
import com.test.myhealth.domain.model.PhysicalInfo

class PhysicalInfoAdapter : RecyclerView.Adapter<PhysicalInfoAdapter.PhysicalInfoViewHolder>() {

    class PhysicalInfoViewHolder(val binding: ItemPhysicalInfoNoteBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var physicalInfoList = ArrayList<PhysicalInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhysicalInfoViewHolder {
        return PhysicalInfoViewHolder(
            ItemPhysicalInfoNoteBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PhysicalInfoViewHolder, position: Int) {
        holder.binding.apply {
            note.text = physicalInfoList[position].note
        }
    }

    override fun getItemCount(): Int {
        return physicalInfoList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setPhysicalInfoListList(physicalInfoList: List<PhysicalInfo>) {
        this.physicalInfoList = physicalInfoList as ArrayList<PhysicalInfo>
        notifyDataSetChanged()
    }
}