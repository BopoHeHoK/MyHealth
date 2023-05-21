package com.test.myhealth.app.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.myhealth.databinding.ItemMentalInfoNoteBinding
import com.test.myhealth.domain.model.MentalInfo

class MentalInfoAdapter : RecyclerView.Adapter<MentalInfoAdapter.MentalInfoViewHolder>() {

    class MentalInfoViewHolder(val binding: ItemMentalInfoNoteBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var mentalInfoList = ArrayList<MentalInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MentalInfoViewHolder {
        return MentalInfoViewHolder(
            ItemMentalInfoNoteBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MentalInfoViewHolder, position: Int) {
        holder.binding.apply {
            note.text = mentalInfoList[position].note
        }
    }

    override fun getItemCount(): Int {
        return mentalInfoList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMentalInfoList(mentalInfoList: List<MentalInfo>) {
        this.mentalInfoList = mentalInfoList as ArrayList<MentalInfo>
        notifyDataSetChanged()
    }
}