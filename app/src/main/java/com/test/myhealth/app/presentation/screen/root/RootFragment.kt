package com.test.myhealth.app.presentation.screen.root

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.test.myhealth.R
import com.test.myhealth.app.app.App
import com.test.myhealth.databinding.FragmentRootBinding
import com.test.myhealth.app.presentation.adapter.ViewPagerAdapter
import com.test.myhealth.app.presentation.screen.tab.article.ArticleFragment
import com.test.myhealth.app.presentation.screen.tab.calc.CalcFragment
import com.test.myhealth.app.presentation.screen.tab.main.MainFragment
import com.test.myhealth.app.presentation.screen.tab.profile.ProfileFragment
import com.test.myhealth.app.presentation.screen.tab.schedule.ScheduleFragment
import javax.inject.Inject

class RootFragment : Fragment() {

    @Inject
    lateinit var rootViewModelFactory: RootViewModelFactory

    private lateinit var binding: FragmentRootBinding
    private lateinit var rootViewModel: RootViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectRootFragment(
            rootFragment = this
        )
        rootViewModel = ViewModelProvider(
            owner = this,
            factory = rootViewModelFactory
        )[RootViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRootBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createViewPager()
    }

    private fun createViewPager() {
        val fragments: ArrayList<Fragment> = arrayListOf(
            MainFragment(),
            ScheduleFragment(),
            CalcFragment(),
            ArticleFragment(),
            ProfileFragment()
        )

        val adapter = ViewPagerAdapter(fragments, this)
        binding.apply {
            viewPager.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
                when (pos) {
                    4 -> {
                        tab.text = getString(R.string.profile_fragment)
                        tab.setIcon(R.drawable.selector_profile)
                    }
                    3 -> {
                        tab.text = getString(R.string.article_fragment)
                        tab.setIcon(R.drawable.selector_article)
                    }
                    2 -> {
                        tab.text = getString(R.string.calc_fragment)
                        tab.setIcon(R.drawable.selector_calc)
                    }
                    1 -> {
                        tab.text = getString(R.string.schedule_fragment)
                        tab.setIcon(R.drawable.selector_schedule)
                    }
                    else -> {
                        tab.text = getString(R.string.home_fragment)
                        tab.setIcon(R.drawable.selector_home)
                    }
                }
            }.attach()
        }
    }
}