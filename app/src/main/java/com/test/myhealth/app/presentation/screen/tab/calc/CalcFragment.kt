package com.test.myhealth.app.presentation.screen.tab.calc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.myhealth.R
import com.test.myhealth.app.app.App
import com.test.myhealth.databinding.FragmentCalcBinding
import javax.inject.Inject

class CalcFragment : Fragment() {

    @Inject
    lateinit var calcViewModelFactory: CalcViewModelFactory

    private lateinit var binding: FragmentCalcBinding
    private lateinit var calcViewModel: CalcViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectCalcFragment(
            calcFragment = this
        )
        calcViewModel = ViewModelProvider(
            owner = this,
            factory = calcViewModelFactory
        )[CalcViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalcBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toBmi(view)
        toBmm(view)
        toIbw(view)
        toTbb(view)
        toTbw(view)
        toWth(view)
    }

    private fun toBmi(view: View) {
        binding.toBmi.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_bmiFragment)
        }
    }

    private fun toBmm(view: View) {
        binding.toBmm.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_bmmFragment)
        }
    }

    private fun toIbw(view: View) {
        binding.toIbw.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_ibwFragment)
        }
    }

    private fun toTbb(view: View) {
        binding.toTbb.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_tbbFragment)
        }
    }

    private fun toTbw(view: View) {
        binding.toTbw.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_tbwFragment)
        }
    }

    private fun toWth(view: View) {
        binding.toWth.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_wthFragment)
        }
    }
}