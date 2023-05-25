package com.test.myhealth.app.presentation.screen.tab.calc.total_body_blood

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
import com.test.myhealth.databinding.FragmentTbbBinding
import javax.inject.Inject
import kotlin.math.pow

class TbbFragment : Fragment() {

    @Inject
    lateinit var tbbViewModelFactory: TbbViewModelFactory

    private lateinit var binding: FragmentTbbBinding
    private lateinit var tbbViewModel: TbbViewModel

    private var genderId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectTbbFragment(
            tbbFragment = this
        )
        tbbViewModel = ViewModelProvider(
            owner = this,
            factory = tbbViewModelFactory
        )[TbbViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTbbBinding.inflate(layoutInflater)
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
            tbbViewModel.apply {
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
                    .title(R.string.tbb)
                    .message(
                        text = String.format(
                            "%.2f",
                            calculate(genderId, rpHeight.currentValue, rpWeight.currentValue)
                        ) + resources.getString(R.string.ls)
                    )
                dialog.show()
            }
        }
    }

    private fun calculate(gender: Int, height: Int, weight: Int): Double {
        val result = when (gender) {
            1 -> 0.3561 * (height.toDouble() / 100).pow(3.0) + 0.03308 * weight.toDouble() + 0.1833
            else -> 0.3669 * (height.toDouble() / 100).pow(3.0) + 0.03219 * weight.toDouble() + 0.6041
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