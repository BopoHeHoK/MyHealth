package com.test.myhealth.app.presentation.screen.tab.calc.body_mass_index

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
import com.test.myhealth.databinding.FragmentBmiBinding
import javax.inject.Inject
import kotlin.math.pow

class BmiFragment : Fragment() {

    @Inject
    lateinit var bmiViewModelFactory: BmiViewModelFactory

    private lateinit var binding: FragmentBmiBinding
    private lateinit var bmiViewModel: BmiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectBmiFragment(
            bmiFragment = this
        )
        bmiViewModel = ViewModelProvider(
            owner = this,
            factory = bmiViewModelFactory
        )[BmiViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBmiBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUserParameter()
        onArrowBackClick(view)
        onCalculateButtonClick(view)
    }

    private fun observeUserParameter() {
        binding.apply {
            bmiViewModel.apply {
                val userParameter = observerUserParameter(getUserId())
                userParameter.height?.let { rpHeight.selectValue(it) }
                userParameter.weight?.let { rpWeight.selectValue(it) }
            }
        }
    }

    private fun onCalculateButtonClick(view: View) {
        binding.apply {
            calculate.setOnClickListener {
                val dialog = MaterialDialog(view.context)
                    .title(R.string.bmi)
                    .message(
                        text = String.format(
                            "%.2f",
                            calculate(rpHeight.currentValue, rpWeight.currentValue)
                        )
                    )
                dialog.show()
            }
        }
    }

    private fun calculate(height: Int, weight: Int): Double {
        return weight.toDouble() / (height.toDouble() / 100).pow(2.0)
    }

    private fun onArrowBackClick(view: View) {
        binding.apply {
            arrowBack.setOnClickListener {
                Navigation.findNavController(view).popBackStack()
            }
        }
    }
}