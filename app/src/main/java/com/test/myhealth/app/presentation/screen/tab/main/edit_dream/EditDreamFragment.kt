package com.test.myhealth.app.presentation.screen.tab.main.edit_dream

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
import com.test.myhealth.app.presentation.adapter.DreamInfoAdapter
import com.test.myhealth.databinding.FragmentEditDreamBinding
import javax.inject.Inject

class EditDreamFragment : Fragment() {

    @Inject
    lateinit var editDreamViewModelFactory: EditDreamViewModelFactory

    private lateinit var binding: FragmentEditDreamBinding
    private lateinit var editDreamViewModel: EditDreamViewModel
    private lateinit var dreamInfoAdapter: DreamInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectEditDreamFragment(
            editDreamFragment = this
        )
        editDreamViewModel = ViewModelProvider(
            owner = this,
            factory = editDreamViewModelFactory
        )[EditDreamViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditDreamBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onArrowBackClick(view)
        onChangeDateButtonClick(view)
        observeDream()
    }

    private fun addDreamInfoAdapter() {
        dreamInfoAdapter = DreamInfoAdapter()
        binding.rcNote.apply {
            layoutManager = LinearLayoutManager(context, GridLayoutManager.VERTICAL, false)
            adapter = dreamInfoAdapter
        }
    }

    private fun observeDream() {
        editDreamViewModel.apply {
            addDreamInfoAdapter()
            observerDream(userId = getUserId())
            dreamInfoAdapter.setDreamInfoList(observerDreamInfo(dreamId = 1))
        }
    }

    private fun onChangeDateButtonClick(view: View) {
        binding.apply {
            btnDreamDate.setOnClickListener {
                MaterialDialog(view.context).show {
                    datePicker { dialog, date ->
                        if (date.month < 10 && date.dayOfMonth < 10)
                            btnDreamDate.text = resources.getString(
                                R.string.yyyy_0m_0d,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else if (date.month < 10)
                            btnDreamDate.text = resources.getString(
                                R.string.yyyy_0m_dd,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else if (date.dayOfMonth < 10)
                            btnDreamDate.text = resources.getString(
                                R.string.yyyy_mm_0d,
                                date.year,
                                date.month + 1,
                                date.dayOfMonth
                            )
                        else
                            btnDreamDate.text = resources.getString(
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