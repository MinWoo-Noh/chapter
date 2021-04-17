package com.example.aop.part2.chapter01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // height_EditText 초기화를 해 주지 않으면 null point exception 이 일어날 수 있다.
        val height_EditText : EditText = findViewById(R.id.height_EditText)
        val weight_EditText = findViewById<EditText>(R.id.weight_EditText)
        val result_Button = findViewById<Button>(R.id.result_Button)

        result_Button.setOnClickListener {
            Log.d("MainActivity","ResultButton 이 클릭되었습니다.")

            if (height_EditText.text.isEmpty() || weight_EditText.text.isEmpty()){
                Toast.makeText(this,"빈 값이 잇습니다.", Toast.LENGTH_LONG).show()

                // 함수가 중첩되어 있기때문에 어떤 함수로 return 을 할지 kotiln이 모르기 때문에 @setOnClickListener 붙여줘야한다.
                return@setOnClickListener
            }

            // 이 아래로는 빈 값이 올 수 없

            // .text 는 EdiTable 타입 이라 문자열로 변환해준 후 int형으로 변환해줘야함
            val height : Int = height_EditText.text.toString().toInt()
            val weight : Int = weight_EditText.text.toString().toInt()
            Log.d("MainActivity","height : $height, weight : $weight")

            val intent = Intent(this, ResultActivity::class.java)

            // intent에 값을 담는 방법 putExtra()
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)

            startActivity(intent)
        }
    }
}