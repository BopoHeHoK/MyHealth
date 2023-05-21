package com.test.myhealth.app.presentation.screen.tab.calc.waist_to_height_ratio

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
import com.test.myhealth.databinding.FragmentWthBinding
import javax.inject.Inject

class WthFragment : Fragment() {

    @Inject
    lateinit var wthViewModelFactory: WthViewModelFactory

    private lateinit var binding: FragmentWthBinding
    private lateinit var wthViewModel: WthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectWthFragment(
            wthFragment = this
        )
        wthViewModel = ViewModelProvider(
            owner = this,
            factory = wthViewModelFactory
        )[WthViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWthBinding.inflate(layoutInflater)
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
            wthViewModel.apply {
                val userParameter = observerUserParameter(getUserId())
                userParameter.height?.let { rpHeight.selectValue(it) }
                userParameter.waist?.let { rpWaist.selectValue(it) }
            }
        }
    }

    private fun onCalculateButtonClick(view: View) {
        binding.apply {
            calculate.setOnClickListener {
                val dialog = MaterialDialog(view.context)
                    .title(R.string.wth)
                    .message(
                        text = String.format(
                            "%.2f",
                            calculate(rpWaist.currentValue, rpHeight.currentValue)
                        )
                    )
                dialog.show()
            }
        }
    }

    private fun calculate(waist: Int, height: Int): Double {
        return waist.toDouble() / height.toDouble()
    }

    private fun onArrowBackClick(view: View) {
        binding.apply {
            arrowBack.setOnClickListener {
                Navigation.findNavController(view).popBackStack()
            }
        }
    }
}