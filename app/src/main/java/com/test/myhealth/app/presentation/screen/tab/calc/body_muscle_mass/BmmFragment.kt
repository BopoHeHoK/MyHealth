package com.test.myhealth.app.presentation.screen.tab.calc.body_muscle_mass

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
import com.test.myhealth.databinding.FragmentBmmBinding
import javax.inject.Inject
import kotlin.math.pow

class BmmFragment : Fragment() {

    @Inject
    lateinit var bmmViewModelFactory: BmmViewModelFactory

    private lateinit var binding: FragmentBmmBinding
    private lateinit var bmmViewModel: BmmViewModel

    private var genderId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectBmmFragment(
            bmmFragment = this
        )
        bmmViewModel = ViewModelProvider(
            owner = this,
            factory = bmmViewModelFactory
        )[BmmViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBmmBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onArrowBackClick(view)
        observeUserParameter()
        onCalculateButtonClick(view)
    }

    private fun observeUserParameter() {
        binding.apply {
            bmmViewModel.apply {
                val userParameter = observerUserParameter(getUserId())
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
                    .title(R.string.bmm)
                    .message(
                        text = String.format(
                            "%.2f",
                            calculate(genderId, rpHeight.currentValue, rpWeight.currentValue)
                        ) + resources.getString(R.string.kgs)
                    )
                dialog.show()
            }
        }
    }

    private fun calculate(gender: Int, height: Int, weight: Int): Double {
        val result = when (gender) {
            1 -> 1.07 * weight.toDouble() - 148 * (weight.toDouble() / height.toDouble()).pow(2.0)
            else -> 1.1 * weight.toDouble() - 128 * (weight.toDouble() / height.toDouble()).pow(2.0)
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