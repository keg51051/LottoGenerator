package com.lotto.lottogenerator

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var btnGenerate: Button
    private lateinit var btnSave: Button
    private lateinit var tvFirstNumber: TextView
    private lateinit var tvSecondNumber: TextView
    private lateinit var tvThirdNumber: TextView
    private lateinit var tvFourthNumber: TextView
    private lateinit var tvFifthNumber: TextView
    private lateinit var tvSixthNumber: TextView
    private lateinit var mAdView : AdView
    private lateinit var bottom_nav : BottomNavigationView


    private var numbers = (1..45).toList()
    private var numSet = mutableSetOf<Int>()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_LottoGenerator)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGenerate = findViewById(R.id.btnGenerate)
        btnSave = findViewById(R.id.btnSave)
        tvFirstNumber = findViewById(R.id.tvFirstNumber)
        tvSecondNumber = findViewById(R.id.tvSecondNumber)
        tvThirdNumber = findViewById(R.id.tvThirdNumber)
        tvFourthNumber = findViewById(R.id.tvFourthNumber)
        tvFifthNumber = findViewById(R.id.tvFifthNumber)
        tvSixthNumber = findViewById(R.id.tvSixthNumber)
        bottom_nav = findViewById(R.id.bottom_nav_bar)


        btnGenerate.setOnClickListener {
            generate()
        }

        // Ads init
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        btnSave.setOnClickListener {
            // Convert numSet to List for saving in the DB
            Log.d("list", numSet.toList().toString())
        }

    }

    // Function that generates the random numbers
    private fun generate() {
        numSet.clear()
        while (numSet.size < 6) {
            numSet.add(numbers.random())
        }
        numSet = numSet.toSortedSet()

        tvFirstNumber.text = numSet.elementAt(0).toString()
        tvSecondNumber.text = numSet.elementAt(1).toString()
        tvThirdNumber.text = numSet.elementAt(2).toString()
        tvFourthNumber.text = numSet.elementAt(3).toString()
        tvFifthNumber.text = numSet.elementAt(4).toString()
        tvSixthNumber.text = numSet.elementAt(5).toString()

        setRoundedBackground(tvFirstNumber)
        setRoundedBackground(tvSecondNumber)
        setRoundedBackground(tvThirdNumber)
        setRoundedBackground(tvFourthNumber)
        setRoundedBackground(tvFifthNumber)
        setRoundedBackground(tvSixthNumber)
    }

    // Function for setting the numbers textview with rounded background colors like balls
    private fun setRoundedBackground(tv: TextView) {
        when (tv.text.toString().toInt()) {
            in 1..10 -> tv.setBackgroundResource(R.drawable.rounded_tv_yellow)
            in 11..20 -> tv.setBackgroundResource(R.drawable.rounded_tv_blue)
            in 21..30 -> tv.setBackgroundResource(R.drawable.rounded_tv_red)
            in 31..40 -> tv.setBackgroundResource(R.drawable.rounded_tv_gray)
            else -> tv.setBackgroundResource(R.drawable.rounded_tv_lightgreen)
        }
    }
}