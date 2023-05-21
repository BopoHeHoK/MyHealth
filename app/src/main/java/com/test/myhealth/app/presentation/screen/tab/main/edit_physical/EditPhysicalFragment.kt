package com.test.myhealth.app.presentation.screen.tab.main.edit_physical

import android.os.Bundle
import android.util.Log
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
import com.test.myhealth.R
import com.test.myhealth.app.app.App
import com.test.myhealth.app.presentation.adapter.PhysicalInfoAdapter
import com.test.myhealth.databinding.FragmentEditPhysicalBinding
import javax.inject.Inject

class EditPhysicalFragment : Fragment() {

    @Inject
    lateinit var editPhysicalViewModelFactory: EditPhysicalViewModelFactory

    private lateinit var binding: FragmentEditPhysicalBinding
    private lateinit var editPhysicalViewModel: EditPhysicalViewModel
    private lateinit var physicalInfoAdapter: PhysicalInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectEditPhysicalFragment(
            editPhysicalFragment = this
        )
        editPhysicalViewModel = ViewModelProvider(
            owner = this,
            factory = editPhysicalViewModelFactory
        )[EditPhysicalViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditPhysicalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observePhysical()
        onChangeDateButtonClick(view)
        onArrowBackClick(view)
    }

    private fun onChangeDateButtonClick(view: View) {
        binding.apply {
            btnPhysicalConditionDate.setOnClickListener {
                MaterialDialog(view.context).show {
                    datePicker { dialog, date ->
                        if (date.month < 10 && date.dayOfMonth < 10)
                            btnPhysicalConditionDate.text = resources.getString(
                                R.string.yyyy_0m_0d,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else if (date.month < 10)
                            btnPhysicalConditionDate.text = resources.getString(
                                R.string.yyyy_0m_dd,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else if (date.dayOfMonth < 10)
                            btnPhysicalConditionDate.text = resources.getString(
                                R.string.yyyy_mm_0d,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else
                            btnPhysicalConditionDate.text = resources.getString(
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

    private fun addMentalInfoAdapter() {
        physicalInfoAdapter = PhysicalInfoAdapter()
        binding.rcNote.apply {
            layoutManager = LinearLayoutManager(context, GridLayoutManager.VERTICAL, false)
            adapter = physicalInfoAdapter
        }
    }

    private fun observePhysical() {
        editPhysicalViewModel.apply {
            addMentalInfoAdapter()
            observerPhysical(userId = getUserId())
            physicalInfoAdapter.setPhysicalInfoListList(observerPhysicalInfo(physicalConditionId = 2))
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