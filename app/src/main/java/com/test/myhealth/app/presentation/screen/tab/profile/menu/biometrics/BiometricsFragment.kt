package com.test.myhealth.app.presentation.screen.tab.profile.menu.biometrics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.myhealth.app.app.App
import com.test.myhealth.databinding.FragmentBiometricsBinding
import com.test.myhealth.domain.model.UserParameter
import javax.inject.Inject

class BiometricsFragment : Fragment() {

    @Inject
    lateinit var biometricsViewModelFactory: BiometricsViewModelFactory

    private lateinit var binding: FragmentBiometricsBinding
    private lateinit var biometricsViewModel: BiometricsViewModel

    private var userParameterId = 0L
    private var genderId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectBiometricsFragment(
            biometricsFragment = this
        )
        biometricsViewModel = ViewModelProvider(
            owner = this,
            factory = biometricsViewModelFactory
        )[BiometricsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBiometricsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUserParameter()
        saveChanges(view)
        onArrowBackClick(view)
    }

    private fun observeUserParameter() {
        binding.apply {
            biometricsViewModel.apply {
                val userParameter = observerUserParameter(getUserId())
                userParameterId = userParameter.id
                userParameter.age?.let { rpAge.selectValue(it) }
                if (userParameter.genderId != null) {
                    genderId = userParameter.genderId.toInt()
                    tbGender.getTabAt(genderId - 1)?.select()
                } else {
                    tbGender.getTabAt(0)?.select()
                }
                userParameter.height?.let { rpHeight.selectValue(it) }
                userParameter.weight?.let { rpWeight.selectValue(it) }
                userParameter.waist?.let { rpWaist.selectValue(it) }
            }
        }
    }

    private fun saveChanges(view: View) {
        binding.apply {
            save.setOnClickListener {
                biometricsViewModel.apply {
                    genderId = tbGender.selectedTabPosition
                    val userParameter = UserParameter(
                        id = userParameterId,
                        age = rpAge.currentValue,
                        height = rpHeight.currentValue,
                        weight = rpWeight.currentValue,
                        waist = rpWaist.currentValue,
                        userId = getUserId(),
                        genderId = genderId.toLong(),
                    )
                    upsertUserParameter(userParameter = userParameter)
                    Navigation.findNavController(view).popBackStack()
                }
            }
        }
    }

    private fun onArrowBackClick(view: View) {
        binding.arrowBack.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
    }
}