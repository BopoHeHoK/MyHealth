package com.test.myhealth.app.presentation.screen.tab.article.statistics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.test.myhealth.app.app.App
import com.test.myhealth.databinding.FragmentStatisticsBinding
import javax.inject.Inject

class StatisticsFragment : Fragment() {

    @Inject
    lateinit var statisticsViewModelFactory: StatisticsViewModelFactory

    private lateinit var binding: FragmentStatisticsBinding
    private lateinit var statisticsViewModel: StatisticsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectStatisticsFragment(
            statisticsFragment = this
        )
        statisticsViewModel = ViewModelProvider(
            owner = this,
            factory = statisticsViewModelFactory
        )[StatisticsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatisticsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}