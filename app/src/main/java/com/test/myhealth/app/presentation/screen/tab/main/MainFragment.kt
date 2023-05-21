package com.test.myhealth.app.presentation.screen.tab.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.myhealth.R
import com.test.myhealth.app.app.App
import com.test.myhealth.databinding.FragmentMainBinding
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private lateinit var binding: FragmentMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectMainFragment(
            mainFragment = this
        )
        mainViewModel = ViewModelProvider(
            owner = this,
            factory = mainViewModelFactory
        )[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toEditDream(view)
        toEditPhysicalCondition(view)
        toEditMentalCondition(view)
    }

    private fun toEditDream(view: View) {
        binding.btnDream.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_editDreamFragment)
        }
    }

    private fun toEditPhysicalCondition(view: View) {
        binding.btnPhysical.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_editPhysicalFragment)
        }
    }

    private fun toEditMentalCondition(view: View) {
        binding.btnMental.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_editMentalFragment)
        }
    }
}