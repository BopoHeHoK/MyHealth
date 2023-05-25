package com.test.myhealth.app.presentation.screen.tab.article.statistics

import android.icu.number.Precision.currency
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ViewPortHandler
import com.test.myhealth.R
import com.test.myhealth.app.app.App
import com.test.myhealth.databinding.FragmentStatisticsBinding
import javax.inject.Inject


class StatisticsFragment : Fragment() {

    companion object Consts {
        val days = arrayOf(
            "",
            "",
            "",
            "",
        )
    }

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
        observeDream(view)
        observePhysicalCondition(view)
        observeMentalCondition(view)
    }

    private fun observeDream(view: View) {
        binding.chartDream.apply {
            val entriesDream = ArrayList<Entry>()
            entriesDream.add(Entry(1f, 2f))
            entriesDream.add(Entry(2f, 5f))
            entriesDream.add(Entry(3f, 3f))
            val datasetDreamQuality = LineDataSet(entriesDream,  resources.getString(R.string.dream_quality))
            datasetDreamQuality.setDrawFilled(true)
            datasetDreamQuality.color = ContextCompat.getColor(view.context, R.color.main_green)
            datasetDreamQuality.setCircleColor(ContextCompat.getColor(view.context, R.color.main_green))
            datasetDreamQuality.circleHoleColor = ContextCompat.getColor(view.context, R.color.main_green)
            datasetDreamQuality.fillColor = ContextCompat.getColor(view.context, R.color.transparent)
            datasetDreamQuality.valueTextSize = 12f
            datasetDreamQuality.circleRadius = 5f
            datasetDreamQuality.lineWidth = 3f
            datasetDreamQuality.mode = LineDataSet.Mode.CUBIC_BEZIER;
            val xAxis = xAxis
            xAxis.position = XAxis.XAxisPosition.BOTTOM_INSIDE
            xAxis.setDrawLabels(true)
            xAxis.granularity = 1f
            xAxis.valueFormatter = IndexAxisValueFormatter(days)
            description.text = ""
            axisLeft.xOffset = 14f
            axisRight.xOffset = 14f
            val dataDream = LineData(datasetDreamQuality)
            data = dataDream
            invalidate()
        }
    }

    private fun observePhysicalCondition(view: View) {
        binding.chartPhysical.apply {
            val entriesPhysical = ArrayList<Entry>()
            entriesPhysical.add(Entry(1f, 1f))
            entriesPhysical.add(Entry(2f, 3f))
            entriesPhysical.add(Entry(3f, 4f))
            val datasetPhysicalQuality = LineDataSet(entriesPhysical,  resources.getString(R.string.physical_condition_quality))
            datasetPhysicalQuality.setDrawFilled(true)
            datasetPhysicalQuality.color = ContextCompat.getColor(view.context, R.color.main_green)
            datasetPhysicalQuality.setCircleColor(ContextCompat.getColor(view.context, R.color.main_green))
            datasetPhysicalQuality.circleHoleColor = ContextCompat.getColor(view.context, R.color.main_green)
            datasetPhysicalQuality.fillColor = ContextCompat.getColor(view.context, R.color.transparent)
            datasetPhysicalQuality.valueTextSize = 12f
            datasetPhysicalQuality.circleRadius = 5f
            datasetPhysicalQuality.lineWidth = 3f
            datasetPhysicalQuality.mode = LineDataSet.Mode.CUBIC_BEZIER;
            val xAxis = xAxis
            xAxis.position = XAxis.XAxisPosition.BOTTOM_INSIDE
            xAxis.setDrawLabels(true)
            xAxis.granularity = 1f
            xAxis.valueFormatter = IndexAxisValueFormatter(days)
            description.text = ""
            axisLeft.xOffset = 14f
            axisRight.xOffset = 14f
            val dataPhysical = LineData(datasetPhysicalQuality)
            data = dataPhysical
            invalidate()
        }
    }

    private fun observeMentalCondition(view: View) {
        binding.chartMental.apply {
            val entriesMental = ArrayList<Entry>()
            entriesMental.add(Entry(1f, 4f))
            entriesMental.add(Entry(2f, 5f))
            entriesMental.add(Entry(3f, 3f))
            val datasetMentalQuality = LineDataSet(entriesMental, resources.getString(R.string.mental_condition_quality))
            datasetMentalQuality.setDrawFilled(true)
            datasetMentalQuality.color = ContextCompat.getColor(view.context, R.color.main_green)
            datasetMentalQuality.setCircleColor(ContextCompat.getColor(view.context, R.color.main_green))
            datasetMentalQuality.circleHoleColor = ContextCompat.getColor(view.context, R.color.main_green)
            datasetMentalQuality.fillColor = ContextCompat.getColor(view.context, R.color.transparent)
            datasetMentalQuality.valueTextSize = 12f
            datasetMentalQuality.circleRadius = 5f
            datasetMentalQuality.lineWidth = 3f
            datasetMentalQuality.mode = LineDataSet.Mode.CUBIC_BEZIER;
            val xAxis = xAxis
            xAxis.position = XAxis.XAxisPosition.BOTTOM_INSIDE
            xAxis.setDrawLabels(true)
            xAxis.granularity = 1f
            xAxis.valueFormatter = IndexAxisValueFormatter(days)
            description.text = ""
            axisLeft.xOffset = 14f
            axisRight.xOffset = 14f
            val dataMental = LineData(datasetMentalQuality)
            data = dataMental
            invalidate()
        }
    }
}