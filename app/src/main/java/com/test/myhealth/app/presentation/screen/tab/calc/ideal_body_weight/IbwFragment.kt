package com.test.myhealth.app.presentation.screen.tab.calc.ideal_body_weight

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
import com.test.myhealth.databinding.FragmentIbwBinding
import javax.inject.Inject

class IbwFragment : Fragment() {

    @Inject
    lateinit var ibwViewModelFactory: IbwViewModelFactory

    private lateinit var binding: FragmentIbwBinding
    private lateinit var ibwViewModel: IbwViewModel

    private var genderId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectIbwFragment(
            ibwFragment = this
        )
        ibwViewModel = ViewModelProvider(
            owner = this,
            factory = ibwViewModelFactory
        )[IbwViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIbwBinding.inflate(layoutInflater)
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
            ibwViewModel.apply {
                val userParameter = observerUserParameter(getUserId())
                if (userParameter.genderId != null) {
                    genderId = userParameter.genderId.toInt()
                    tbGender.getTabAt(genderId - 1)?.select()
                } else {
                    tbGender.getTabAt(0)?.select()
                }
                userParameter.height?.let { rpHeight.selectValue(it) }
            }
        }
    }

    private fun onCalculateButtonClick(view: View) {
        binding.apply {
            calculate.setOnClickListener {
                genderId = tbGender.selectedTabPosition
                val dialog = MaterialDialog(view.context)
                    .title(R.string.ibw)
                    .message(
                        text = String.format(
                            "%.2f",
                            calculate(genderId, rpHeight.currentValue)
                        ) + resources.getString(R.string.kgs)
                    )
                dialog.show()
            }
        }
    }

    private fun calculate(gender: Int, height: Int): Double {
        val result = when (gender) {
            1 -> height.toDouble() - 100 - ((height.toDouble() - 150) / 2)
            else -> height.toDouble() - 100 - ((height.toDouble() - 150) / 4)
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