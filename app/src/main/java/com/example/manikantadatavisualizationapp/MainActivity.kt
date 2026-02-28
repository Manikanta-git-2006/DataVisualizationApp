package com.example.manikantadatavisualizationapp

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {

    private lateinit var barChart: BarChart
    private lateinit var lineChart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        barChart = findViewById(R.id.barChart)
        lineChart = findViewById(R.id.lineChart)

        setupBarChart()
        setupLineChart()
    }

    private fun setupBarChart() {
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(1f, 50f))
        entries.add(BarEntry(2f, 70f))
        entries.add(BarEntry(3f, 30f))
        entries.add(BarEntry(4f, 90f))
        entries.add(BarEntry(5f, 60f))

        val dataSet = BarDataSet(entries, "Monthly Sales")
        dataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()
        dataSet.valueTextColor = Color.BLACK
        dataSet.valueTextSize = 14f

        val barData = BarData(dataSet)
        barChart.data = barData

        barChart.description = Description().apply {
            text = "Sales Analysis"
        }

        barChart.animateY(1000)
        barChart.invalidate()
    }

    private fun setupLineChart() {
        val entries = ArrayList<Entry>()
        entries.add(Entry(1f, 20f))
        entries.add(Entry(2f, 40f))
        entries.add(Entry(3f, 65f))
        entries.add(Entry(4f, 55f))
        entries.add(Entry(5f, 85f))

        val dataSet = LineDataSet(entries, "Performance Trend")
        dataSet.color = Color.BLUE
        dataSet.setCircleColor(Color.RED)
        dataSet.valueTextColor = Color.BLACK
        dataSet.lineWidth = 3f
        dataSet.circleRadius = 5f

        val lineData = LineData(dataSet)
        lineChart.data = lineData

        lineChart.description = Description().apply {
            text = "Trend Analysis"
        }

        lineChart.animateX(1000)
        lineChart.invalidate()
    }
}
