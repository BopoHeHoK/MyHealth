package com.test.myhealth.app.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.myhealth.databinding.ItemMedicineBinding
import com.test.myhealth.domain.model.MedicineInfo

class MedicineInfoAdapter : RecyclerView.Adapter<MedicineInfoAdapter.MedicineInfoViewHolder>() {

    class MedicineInfoViewHolder(val binding: ItemMedicineBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var medicineInfoList = ArrayList<MedicineInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineInfoViewHolder {
        return MedicineInfoViewHolder(
            ItemMedicineBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MedicineInfoViewHolder, position: Int) {
        holder.binding.apply {
            medicineName.text = medicineInfoList[position].medicine_name
        }
    }

    override fun getItemCount(): Int {
        return medicineInfoList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMedicineInfoList(medicineInfoList: List<MedicineInfo>) {
        this.medicineInfoList = medicineInfoList as ArrayList<MedicineInfo>
        notifyDataSetChanged()
    }
}