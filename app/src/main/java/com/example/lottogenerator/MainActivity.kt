package com.example.lottogenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

private const val TAG = "Main"
class MainActivity : AppCompatActivity() {
    private lateinit var btnGenerator: Button
    private lateinit var tvFirstNumber: TextView
    private lateinit var tvSecondNumber: TextView
    private lateinit var tvThirdNumber: TextView
    private lateinit var tvFourthNumber: TextView
    private lateinit var tvFifthNumber: TextView
    private lateinit var tvSixthNumber: TextView

    private var numbers = (1..45).toList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGenerator = findViewById(R.id.btnGenerator)
        tvFirstNumber = findViewById(R.id.tvFirstNumber)
        tvSecondNumber = findViewById(R.id.tvSecondNumber)
        tvThirdNumber = findViewById(R.id.tvThirdNumber)
        tvFourthNumber = findViewById(R.id.tvFourthNumber)
        tvFifthNumber = findViewById(R.id.tvFifthNumber)
        tvSixthNumber = findViewById(R.id.tvSixthNumber)

        Log.i(TAG, numbers.toString())

        btnGenerator.setOnClickListener {
            generate()
        }
    }

    // Function that generates the random numbers
    private fun generate() {
        tvFirstNumber.text = numbers.random().toString()
    }
}