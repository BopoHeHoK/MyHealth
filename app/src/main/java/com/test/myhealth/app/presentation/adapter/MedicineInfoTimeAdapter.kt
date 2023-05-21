package com.test.myhealth.app.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.myhealth.databinding.ItemMedicineTimeBinding
import com.test.myhealth.domain.model.MedicineInfoTime

class MedicineInfoTimeAdapter :
    RecyclerView.Adapter<MedicineInfoTimeAdapter.MedicineTimeViewHolder>() {

    class MedicineTimeViewHolder(val binding: ItemMedicineTimeBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var medicineInfoTimeList = ArrayList<MedicineInfoTime>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineTimeViewHolder {
        return MedicineTimeViewHolder(
            ItemMedicineTimeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MedicineTimeViewHolder, position: Int) {
        holder.binding.apply {
            time.text = medicineInfoTimeList[position].time.toString().dropLast(3)
        }
    }

    override fun getItemCount(): Int {
        return medicineInfoTimeList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMedicineInfoTimeList(medicineInfoTimeList: List<MedicineInfoTime>) {
        this.medicineInfoTimeList = medicineInfoTimeList as ArrayList<MedicineInfoTime>
        notifyDataSetChanged()
    }
}