package com.test.myhealth

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.core.widget.NestedScrollView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.test.myhealth.databinding.ActivityMainBinding
import com.test.myhealth.ui.*
import com.test.myhealth.ui.articles.ArticleFragment
import com.test.myhealth.ui.calculations.CalcFragment
import com.test.myhealth.ui.diary.DiaryFragment
import com.test.myhealth.ui.home.HomeFragment
import com.test.myhealth.ui.schedule.ScheduleFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivity: ActivityMainBinding
    private lateinit var toolbar: Toolbar
    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivity.root)



        toolbar = findViewById(R.id.mainToolBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val scrollView: NestedScrollView = findViewById (R.id.nestedScrollView);
        scrollView.isFillViewport = true;


        addFragmentAdapter()

        mainActivity.apply {
            ImageMenu.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
            }
        }

        var navView = findViewById<NavigationView>(R.id.nav_view)
        navView.itemIconTintList = null

    }

    private fun addFragmentAdapter() {

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(HomeFragment(), "Главная")
        fragmentAdapter.addFragment(CalcFragment(), "Расчёт")
        fragmentAdapter.addFragment(DiaryFragment(), "Дневник")
        fragmentAdapter.addFragment(ArticleFragment(), "Статьи")
        fragmentAdapter.addFragment(ScheduleFragment(), "Режим")

        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)

        //icons
        tabLayout.getTabAt(0)?.setIcon(R.drawable.selector_home)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.selector_calc)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.selector_diary)
        tabLayout.getTabAt(3)?.setIcon(R.drawable.selector_article)
        tabLayout.getTabAt(4)?.setIcon(R.drawable.selector_schedule)

        tabLayout.tabIconTint = null

    }
}
