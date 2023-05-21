package com.test.myhealth.app.presentation.screen.tab.schedule.edit_medicine

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
import com.afollestad.date.dayOfMonth
import com.afollestad.date.month
import com.afollestad.date.year
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.datePicker
import com.afollestad.materialdialogs.datetime.timePicker
import com.test.myhealth.R
import com.test.myhealth.app.app.App
import com.test.myhealth.app.presentation.adapter.MedicineInfoTimeAdapter
import com.test.myhealth.databinding.FragmentEditMedicineBinding
import java.util.*
import javax.inject.Inject

class EditMedicineFragment : Fragment() {

    @Inject
    lateinit var editMedicineViewModelFactory: EditMedicineViewModelFactory

    private lateinit var binding: FragmentEditMedicineBinding
    private lateinit var editMedicineViewModel: EditMedicineViewModel
    private lateinit var medicineInfoTimeAdapter: MedicineInfoTimeAdapter

    private var medicineInfoTime = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectEditMedicineFragment(
            editMedicineFragment = this
        )
        editMedicineViewModel = ViewModelProvider(
            owner = this,
            factory = editMedicineViewModelFactory
        )[EditMedicineViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditMedicineBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeMedicineInfoTime()
        onChangeDateButtonClick(view)
        onAddTimeClick(view)
        onArrowBackClick(view)
    }

    private fun addArticleAdapter() {
        medicineInfoTimeAdapter = MedicineInfoTimeAdapter()
        binding.rcTime.apply {
            layoutManager = LinearLayoutManager(context, GridLayoutManager.VERTICAL, false)
            adapter = medicineInfoTimeAdapter
        }
    }

    private fun observeMedicineInfoTime() {
        editMedicineViewModel.apply {
            addArticleAdapter()
            medicineInfoTimeAdapter.setMedicineInfoTimeList(observerMedicineInfoTime(1))
        }
    }

    private fun onChangeDateButtonClick(view: View) {
        binding.apply {
            periodFrom.setOnClickListener {
                MaterialDialog(view.context).show {
                    datePicker { dialog, date ->
                        if (date.month < 10 && date.dayOfMonth < 10)
                            periodFrom.text = resources.getString(
                                R.string.yyyy_0m_0d,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else if (date.month < 10)
                            periodFrom.text = resources.getString(
                                R.string.yyyy_0m_dd,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else if (date.dayOfMonth < 10)
                            periodFrom.text = resources.getString(
                                R.string.yyyy_mm_0d,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else
                            periodFrom.text = resources.getString(
                                R.string.yyyy_mm_dd,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                    }
                }
            }
            periodTo.setOnClickListener {
                MaterialDialog(view.context).show {
                    datePicker { dialog, date ->
                        if (date.month < 10 && date.dayOfMonth < 10)
                            periodTo.text = resources.getString(
                                R.string.yyyy_0m_0d,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else if (date.month < 10)
                            periodTo.text = resources.getString(
                                R.string.yyyy_0m_dd,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else if (date.dayOfMonth < 10)
                            periodTo.text = resources.getString(
                                R.string.yyyy_mm_0d,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else
                            periodTo.text = resources.getString(
                                R.string.yyyy_mm_dd,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                    }
                }
            }
        }
    }

    private fun onAddTimeClick(view: View) {
        binding.apply {
            btnAddTime.setOnClickListener {
                MaterialDialog(view.context).show {
                    timePicker { _, time ->
//                        if (time.get(Calendar.MINUTE) < 10)
//                            tvWeightTime.text = resources.getString(
//                                R.string.h0m,
//                                time.get(Calendar.HOUR_OF_DAY),
//                                time.get(Calendar.MINUTE)
//                            )
//                        else
//                            tvWeightTime.text = resources.getString(
//                                R.string.hm,
//                                time.get(Calendar.HOUR_OF_DAY),
//                                time.get(Calendar.MINUTE)
//                            )
                    }
                }
            }
        }
    }

    private fun onArrowBackClick(view: View) {
        binding.apply {
            arrowBack.setOnClickListener {
                Navigation.findNavController(view).popBackStack()
            }
        }
    }
}