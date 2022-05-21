package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BMICalculate : AppCompatActivity() {
    lateinit var btnCalculateBmi: Button
    lateinit var etWeight2: EditText
    lateinit var etHeight: EditText
    lateinit var tvBmi: TextView
    lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculate)
        btnCalculateBmi = findViewById(R.id.btnCalculateBmi)
        etWeight2= findViewById(R.id.etWeight2)
        etHeight = findViewById(R.id.etHeight)
        tvBmi = findViewById(R.id.tvBmi)
        tvStatus = findViewById(R.id.tvStatus)

        btnCalculateBmi.setOnClickListener {
            tvBmi.text = ""
            var weight = etWeight2.text.toString()
            var height = etHeight.text.toString()
            if (weight.isBlank()){
                etWeight2.setError("Weight is required")
                return@setOnClickListener
            }
            if (height.isBlank()){
                etHeight.error = "Height is required"
                return@setOnClickListener
            }
            calculateBMI(weight.toDouble(),height.toInt())
        }
    }
    fun calculateBMI(weight:Double, height:Int){
        val heightMetres=height/100.0
        val bmi = weight/(heightMetres*heightMetres)
        tvBmi.text = bmi.toString()

        if(bmi<18.5){
            tvStatus.text = "underweight"
        }
        else if (bmi in 18.6..25.0){
            tvStatus.text = "normal"
        }
        else if (bmi in 25.1..30.0){
            tvStatus.text = "overweight"
        }
        else{
            tvStatus.text = "obese"
        }
    }
}