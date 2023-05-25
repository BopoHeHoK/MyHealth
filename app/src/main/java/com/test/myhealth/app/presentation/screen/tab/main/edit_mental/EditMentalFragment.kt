package com.test.myhealth.app.presentation.screen.tab.main.edit_mental

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
import com.test.myhealth.R
import com.test.myhealth.app.app.App
import com.test.myhealth.app.presentation.adapter.MentalInfoAdapter
import com.test.myhealth.databinding.FragmentEditMentalBinding
import javax.inject.Inject

class EditMentalFragment : Fragment() {

    @Inject
    lateinit var editMentalViewModelFactory: EditMentalViewModelFactory

    private lateinit var binding: FragmentEditMentalBinding
    private lateinit var editMentalViewModel: EditMentalViewModel
    private lateinit var mentalInfoAdapter: MentalInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectEditMentalFragment(
            editMentalFragment = this
        )
        editMentalViewModel = ViewModelProvider(
            owner = this,
            factory = editMentalViewModelFactory
        )[EditMentalViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditMentalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeMental()
        onChangeDateButtonClick(view)
        onArrowBackClick(view)
    }

    private fun addMentalInfoAdapter() {
        mentalInfoAdapter = MentalInfoAdapter()
        binding.rcNote.apply {
            layoutManager = LinearLayoutManager(context, GridLayoutManager.VERTICAL, false)
            adapter = mentalInfoAdapter
        }
    }

    private fun observeMental() {
        editMentalViewModel.apply {
            addMentalInfoAdapter()
            observerMental(userId = getUserId())
            mentalInfoAdapter.setMentalInfoList(observerMentalInfo(mentalConditionId = 5))
        }
    }

    private fun onChangeDateButtonClick(view: View) {
        binding.apply {
            btnMentalConditionDate.setOnClickListener {
                MaterialDialog(view.context).show {
                    datePicker { dialog, date ->
                        if (date.month < 10 && date.dayOfMonth < 10)
                            btnMentalConditionDate.text = resources.getString(
                                R.string.yyyy_0m_0d,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else if (date.month < 10)
                            btnMentalConditionDate.text = resources.getString(
                                R.string.yyyy_0m_dd,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else if (date.dayOfMonth < 10)
                            btnMentalConditionDate.text = resources.getString(
                                R.string.yyyy_mm_0d,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else
                            btnMentalConditionDate.text = resources.getString(
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

    private fun onArrowBackClick(view: View) {
        binding.apply {
            arrowBack.setOnClickListener {
                Navigation.findNavController(view).popBackStack()
            }
        }
    }
}