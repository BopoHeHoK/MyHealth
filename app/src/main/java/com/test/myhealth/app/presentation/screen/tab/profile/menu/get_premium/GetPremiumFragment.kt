package com.test.myhealth.app.presentation.screen.tab.profile.menu.get_premium

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.myhealth.app.app.App
import com.test.myhealth.databinding.FragmentGetPremiumBinding
import javax.inject.Inject

class GetPremiumFragment : Fragment() {

    @Inject
    lateinit var getPremiumViewModelFactory: GetPremiumViewModelFactory

    private lateinit var binding: FragmentGetPremiumBinding
    private lateinit var getPremiumViewModel: GetPremiumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectGetPremiumFragment(
            getPremiumFragment = this
        )
        getPremiumViewModel = ViewModelProvider(
            owner = this,
            factory = getPremiumViewModelFactory
        )[GetPremiumViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGetPremiumBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onArrowBackClick(view)
    }

    private fun onArrowBackClick(view: View) {
        binding.apply {
            arrowBack.setOnClickListener {
                Navigation.findNavController(view).popBackStack()
            }
        }
    }
}