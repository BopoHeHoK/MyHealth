package com.test.myhealth.app.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.myhealth.databinding.ItemDreamNoteBinding
import com.test.myhealth.domain.model.DreamInfo

class DreamInfoAdapter : RecyclerView.Adapter<DreamInfoAdapter.DreamInfoViewHolder>() {

    class DreamInfoViewHolder(val binding: ItemDreamNoteBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var dreamInfoList = ArrayList<DreamInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DreamInfoViewHolder {
        return DreamInfoViewHolder(
            ItemDreamNoteBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DreamInfoViewHolder, position: Int) {
        holder.binding.apply {
            note.text = dreamInfoList[position].note
        }
    }

    override fun getItemCount(): Int {
        return dreamInfoList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDreamInfoList(dreamInfoList: List<DreamInfo>) {
        this.dreamInfoList = dreamInfoList as ArrayList<DreamInfo>
        notifyDataSetChanged()
    }
}