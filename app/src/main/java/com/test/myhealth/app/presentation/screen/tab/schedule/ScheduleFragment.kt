package com.test.myhealth.app.presentation.screen.tab.schedule

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.timePicker
import com.test.myhealth.R
import com.test.myhealth.app.app.App
import com.test.myhealth.app.presentation.adapter.MedicineInfoAdapter
import com.test.myhealth.databinding.FragmentScheduleBinding
import com.test.myhealth.domain.model.*
import java.util.*
import javax.inject.Inject

class ScheduleFragment : Fragment() {

    @Inject
    lateinit var scheduleViewModelFactory: ScheduleViewModelFactory

    private lateinit var binding: FragmentScheduleBinding
    private lateinit var scheduleViewModel: ScheduleViewModel
    private lateinit var medicineInfoAdapter: MedicineInfoAdapter

    private var waterId = 0L
    private var periodicity = 0
    private var foodId = 0L
    private var medicineId = 0L
    private var weightId = 0L
    private var pressureId = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectScheduleFragment(
            scheduleFragment = this
        )
        scheduleViewModel = ViewModelProvider(
            owner = this,
            factory = scheduleViewModelFactory
        )[ScheduleViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScheduleBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeWater()
        observeFood()
        observeMedicine()
        observeWeight()
        observePressure()

        toEditMedicine(view)

        onWaterSwitchClick()
        onFoodSwitchClick()
        onMedicineSwitchClick()
        onWeightSwitchClick()
        onPressureSwitchClick()

        onWaterHourClick()
        onFoodTimeClick(view)
        onWeightTimeClick(view)
        onPressureTimeClick(view)
    }

    private fun observeWater() {
        binding.apply {
            scheduleViewModel.apply {
                val water = observerWater(userId = getUserId())
                waterId = water.id
                if (water.mode) {
                    swtWater.isChecked = true
                    waterTimeLayout.visibility = View.VISIBLE
                }
                periodicity = water.periodicity
                when (water.periodicity) {
                    1 -> {
                        radio1.isChecked = true
                    }
                    2 -> {
                        radio2.isChecked = true
                    }
                    3 -> {
                        radio3.isChecked = true
                    }
                    4 -> {
                        radio4.isChecked = true
                    }
                }
            }
        }
    }

    private fun observeFood() {
        binding.apply {
            scheduleViewModel.apply {
                val food = observerFood(userId = getUserId())
                foodId = food.id
                if (food.mode) {
                    swtFood.isChecked = true
                    foodTimeLayout.visibility = View.VISIBLE
                }
                tvFoodTime1.text = food.time1.substring(0, 5)
                cbFoodTime1.isChecked = food.time1_mode
                tvFoodTime2.text = food.time2.substring(0, 5)
                cbFoodTime2.isChecked = food.time2_mode
                tvFoodTime3.text = food.time3.substring(0, 5)
                cbFoodTime3.isChecked = food.time3_mode
                tvFoodTime4.text = food.time4.substring(0, 5)
                cbFoodTime4.isChecked = food.time4_mode
                tvFoodTime5.text = food.time5.substring(0, 5)
                cbFoodTime5.isChecked = food.time5_mode
            }
        }
    }

    private fun addMedicineAdapter() {
        medicineInfoAdapter = MedicineInfoAdapter()
        binding.rvMedicine.apply {
            layoutManager = LinearLayoutManager(context, GridLayoutManager.VERTICAL, false)
            adapter = medicineInfoAdapter
        }
    }


    private fun observeMedicine() {
        addMedicineAdapter()
        binding.apply {
            scheduleViewModel.apply {
                val medicine = observerMedicine(userId = getUserId())
                medicineId = medicine.id
                if (medicine.mode) {
                    swtMedicine.isChecked = true
                }
                medicineInfoAdapter.setMedicineInfoList(observerMedicineInfo(medicineId = medicine.id))
            }
        }
    }

    private fun observeWeight() {
        binding.apply {
            scheduleViewModel.apply {
                val weight = observerWeight(userId = getUserId())
                weightId = weight.id
                if (weight.mode) {
                    swtWeight.isChecked = true
                    weightTimeLayout.visibility = View.VISIBLE
                }
                monday.isChecked = weight.monday
                tuesday.isChecked = weight.tuesday
                wednesday.isChecked = weight.wednesday
                thursday.isChecked = weight.thursday
                friday.isChecked = weight.friday
                saturday.isChecked = weight.saturday
                sunday.isChecked = weight.sunday
                tvWeightTime.text = weight.time.substring(0, 5)
            }
        }
    }

    private fun observePressure() {
        binding.apply {
            scheduleViewModel.apply {
                val pressure = observerPressure(userId = getUserId())
                pressureId = pressure.id
                if (pressure.mode) {
                    swtPressure.isChecked = true
                    pressureTimeLayout.visibility = View.VISIBLE
                }
                tvPressureTime1.text = pressure.time1.substring(0, 5)
                cbPressureTime1.isChecked = pressure.time1_mode
                tvPressureTime2.text = pressure.time2.substring(0, 5)
                cbPressureTime2.isChecked = pressure.time2_mode
                tvPressureTime3.text = pressure.time3.substring(0, 5)
                cbPressureTime3.isChecked = pressure.time3_mode
            }
        }
    }

    private fun toEditMedicine(view: View) {
        binding.btnMedicine.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_editMedicineFragment)
        }
    }

    private fun onWaterSwitchClick() {
        binding.apply {
            swtWater.setOnClickListener {
                if (swtWater.isChecked) {
                    waterTimeLayout.visibility = View.VISIBLE
                } else {
                    waterTimeLayout.visibility = View.GONE
                }
            }
        }
    }

    private fun onFoodSwitchClick() {
        binding.apply {
            swtFood.setOnClickListener {
                if (swtFood.isChecked) {
                    foodTimeLayout.visibility = View.VISIBLE
                } else {
                    foodTimeLayout.visibility = View.GONE
                }
            }
        }
    }

    private fun onMedicineSwitchClick() {
        binding.apply {
            swtMedicine.setOnClickListener {
                if (swtMedicine.isChecked) {
                    rvMedicine.visibility = View.VISIBLE
                    btnMedicine.visibility = View.VISIBLE
                } else {
                    rvMedicine.visibility = View.GONE
                    btnMedicine.visibility = View.GONE
                }
            }
        }
    }

    private fun onWeightSwitchClick() {
        binding.apply {
            swtWeight.setOnClickListener {
                if (swtWeight.isChecked) {
                    weightTimeLayout.visibility = View.VISIBLE
                } else {
                    weightTimeLayout.visibility = View.GONE
                }
            }
        }
    }

    private fun onPressureSwitchClick() {
        binding.apply {
            swtPressure.setOnClickListener {
                if (swtPressure.isChecked) {
                    pressureTimeLayout.visibility = View.VISIBLE
                } else {
                    pressureTimeLayout.visibility = View.GONE
                }
            }
        }
    }

    private fun onWaterHourClick() {
        binding.apply {
            radio1.setOnClickListener {
                if (radio1.isChecked) {
                    periodicity = 1
                }
            }
            radio2.setOnClickListener {
                if (radio2.isChecked) {
                    periodicity = 2
                }
            }
            radio3.setOnClickListener {
                if (radio3.isChecked) {
                    periodicity = 3
                }
            }
            radio4.setOnClickListener {
                if (radio4.isChecked) {
                    periodicity = 4
                }
            }
        }
    }

    private fun onFoodTimeClick(view: View) {
        binding.apply {
            tvFoodTime1.setOnClickListener {
                MaterialDialog(view.context).show {
                    timePicker { _, time ->
                        if (time.get(Calendar.MINUTE) < 10)
                            tvFoodTime1.text = resources.getString(
                                R.string.h0m,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                        else
                            tvFoodTime1.text = resources.getString(
                                R.string.hm,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                    }
                }
            }
            tvFoodTime2.setOnClickListener {
                MaterialDialog(view.context).show {
                    timePicker { _, time ->
                        if (time.get(Calendar.MINUTE) < 10)
                            tvFoodTime2.text = resources.getString(
                                R.string.h0m,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                        else
                            tvFoodTime2.text = resources.getString(
                                R.string.hm,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                    }
                }
            }
            tvFoodTime3.setOnClickListener {
                MaterialDialog(view.context).show {
                    timePicker { _, time ->
                        if (time.get(Calendar.MINUTE) < 10)
                            tvFoodTime3.text = resources.getString(
                                R.string.h0m,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                        else
                            tvFoodTime3.text = resources.getString(
                                R.string.hm,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                    }
                }
            }
            tvFoodTime4.setOnClickListener {
                MaterialDialog(view.context).show {
                    timePicker { _, time ->
                        if (time.get(Calendar.MINUTE) < 10)
                            tvFoodTime4.text = resources.getString(
                                R.string.h0m,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                        else
                            tvFoodTime4.text = resources.getString(
                                R.string.hm,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                    }
                }
            }
            tvFoodTime5.setOnClickListener {
                MaterialDialog(view.context).show {
                    timePicker { _, time ->
                        if (time.get(Calendar.MINUTE) < 10)
                            tvFoodTime5.text = resources.getString(
                                R.string.h0m,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                        else
                            tvFoodTime5.text = resources.getString(
                                R.string.hm,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                    }
                }
            }
        }
    }

    private fun onWeightTimeClick(view: View) {
        binding.apply {
            tvWeightTime.setOnClickListener {
                MaterialDialog(view.context).show {
                    timePicker { _, time ->
                        if (time.get(Calendar.MINUTE) < 10)
                            tvWeightTime.text = resources.getString(
                                R.string.h0m,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                        else
                            tvWeightTime.text = resources.getString(
                                R.string.hm,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                    }
                }
            }
        }
    }

    private fun onPressureTimeClick(view: View) {
        binding.apply {
            tvPressureTime1.setOnClickListener {
                MaterialDialog(view.context).show {
                    timePicker { _, time ->
                        if (time.get(Calendar.MINUTE) < 10)
                            tvPressureTime1.text = resources.getString(
                                R.string.h0m,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                        else
                            tvPressureTime1.text = resources.getString(
                                R.string.hm,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                    }
                }
            }
            tvPressureTime2.setOnClickListener {
                MaterialDialog(view.context).show {
                    timePicker { _, time ->
                        if (time.get(Calendar.MINUTE) < 10)
                            tvPressureTime2.text = resources.getString(
                                R.string.h0m,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                        else
                            tvPressureTime2.text = resources.getString(
                                R.string.hm,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                    }
                }
            }
            tvPressureTime3.setOnClickListener {
                MaterialDialog(view.context).show {
                    timePicker { _, time ->
                        if (time.get(Calendar.MINUTE) < 10)
                            tvPressureTime3.text = resources.getString(
                                R.string.h0m,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                        else
                            tvPressureTime3.text = resources.getString(
                                R.string.hm,
                                time.get(Calendar.HOUR_OF_DAY),
                                time.get(Calendar.MINUTE)
                            )
                    }
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        saveDataToDb()
    }

    private fun saveDataToDb() {
        saveWaterToDb()
        saveFoodToDb()
        saveMedicineToDb()
        saveWeightToDb()
        savePressureToDb()
    }

    private fun saveWaterToDb() {
        binding.apply {
            scheduleViewModel.apply {
                val water = Water(
                    id = waterId,
                    mode = swtWater.isChecked,
                    periodicity = periodicity,
                    userId = getUserId(),
                )
                upsertWater(water = water)
            }
        }
    }

    private fun saveFoodToDb() {
        binding.apply {
            scheduleViewModel.apply {
                val food = Food(
                    id = foodId,
                    mode = swtFood.isChecked,
                    time1 = tvFoodTime1.text.toString(),
                    time1_mode = cbFoodTime1.isChecked,
                    time2 = tvFoodTime2.text.toString(),
                    time2_mode = cbFoodTime2.isChecked,
                    time3 = tvFoodTime3.text.toString(),
                    time3_mode = cbFoodTime3.isChecked,
                    time4 = tvFoodTime4.text.toString(),
                    time4_mode = cbFoodTime4.isChecked,
                    time5 = tvFoodTime5.text.toString(),
                    time5_mode = cbFoodTime5.isChecked,
                    userId = getUserId(),
                )
                upsertFood(food = food)
            }
        }
    }

    private fun saveMedicineToDb() {
        binding.apply {
            scheduleViewModel.apply {
                val medicine = Medicine(
                    id = medicineId,
                    mode = swtMedicine.isChecked,
                    userId = getUserId(),
                )
                upsertMedicine(medicine = medicine)
            }
        }
    }

    private fun saveWeightToDb() {
        binding.apply {
            scheduleViewModel.apply {
                val weight = Weight(
                    id = weightId,
                    mode = swtWeight.isChecked,
                    monday = monday.isChecked,
                    tuesday = tuesday.isChecked,
                    wednesday = wednesday.isChecked,
                    thursday = thursday.isChecked,
                    friday = friday.isChecked,
                    saturday = saturday.isChecked,
                    sunday = sunday.isChecked,
                    time = tvWeightTime.text.toString(),
                    userId = getUserId(),
                )
                upsertWeight(weight = weight)
            }
        }
    }

    private fun savePressureToDb() {
        binding.apply {
            scheduleViewModel.apply {
                val pressure = Pressure(
                    id = pressureId,
                    mode = swtPressure.isChecked,
                    time1 = tvPressureTime1.text.toString(),
                    time1_mode = cbPressureTime1.isChecked,
                    time2 = tvPressureTime1.text.toString(),
                    time2_mode = cbPressureTime2.isChecked,
                    time3 = tvPressureTime1.text.toString(),
                    time3_mode = cbPressureTime3.isChecked,
                    userId = getUserId(),
                )
                upsertPressure(pressure = pressure)
            }
        }
    }
}