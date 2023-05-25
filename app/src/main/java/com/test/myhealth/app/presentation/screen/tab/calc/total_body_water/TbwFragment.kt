package com.test.myhealth.app.presentation.screen.tab.calc.total_body_water

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.afollestad.materialdialogs.MaterialDialog
import com.test.myhealth.R
import com.test.myhealth.app.app.App
import com.test.myhealth.databinding.FragmentTbwBinding
import javax.inject.Inject

class TbwFragment : Fragment() {

    @Inject
    lateinit var tbwViewModelFactory: TbwViewModelFactory

    private lateinit var binding: FragmentTbwBinding
    private lateinit var tbwViewModel: TbwViewModel

    private var genderId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectTbwFragment(
            tbwFragment = this
        )
        tbwViewModel = ViewModelProvider(
            owner = this,
            factory = tbwViewModelFactory
        )[TbwViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTbwBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUserParameter()
        onCalculateButtonClick(view)
        onArrowBackClick(view)
    }

    private fun observeUserParameter() {
        binding.apply {
            tbwViewModel.apply {
                val userParameter = observerUserParameter(getUserId())
                userParameter.age?.let { rpAge.selectValue(it) }
                if (userParameter.genderId != null) {
                    genderId = userParameter.genderId.toInt()
                    tbGender.getTabAt(genderId - 1)?.select()
                } else {
                    tbGender.getTabAt(0)?.select()
                }
                userParameter.height?.let { rpHeight.selectValue(it) }
                userParameter.weight?.let { rpWeight.selectValue(it) }
            }
        }
    }

    private fun onCalculateButtonClick(view: View) {
        binding.apply {
            calculate.setOnClickListener {
                genderId = tbGender.selectedTabPosition
                val dialog = MaterialDialog(view.context)
                    .title(R.string.tbw)
                    .message(
                        text = String.format(
                            "%.2f",
                            calculate(
                                rpAge.currentValue,
                                genderId,
                                rpHeight.currentValue,
                                rpWeight.currentValue
                            )
                        ) + resources.getString(R.string.ls)
                    )
                dialog.show()
            }
        }
    }

    private fun calculate(age: Int, gender: Int, height: Int, weight: Int): Double {
        val result = when (gender) {
            1 -> -2.097 + (0.1069 * height.toDouble()) + (0.2466 * weight.toDouble())
            else -> 2.447 - (0.09145 * age.toDouble()) + (0.1074 * height.toDouble()) + (0.3362 * weight.toDouble())
        }
        return result
    }

    private fun onArrowBackClick(view: View) {
        binding.apply {
            arrowBack.setOnClickListener {
                Navigation.findNavController(view).popBackStack()
            }
        }
    }
}