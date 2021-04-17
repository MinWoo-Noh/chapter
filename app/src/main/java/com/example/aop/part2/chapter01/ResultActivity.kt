package com.example.aop.part2.chapter01

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "height : $height, weight : $weight®")

        // java 에서 쓰는 방식 Math.pow(height / 100.0, 2.0)
        val bmi = weight / (height / 100.0).pow(2.0)
        val resulText = when{
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        val tv_bmi = findViewById<TextView>(R.id.tv_bmi)
        val tv_result = findViewById<TextView>(R.id.tv_result)

//        tv_bmi.text = bmi.toString()
//        tv_result.text = resulText
        tv_bmi.setText(bmi.toString())
        tv_result.setText(resulText)
    }
}