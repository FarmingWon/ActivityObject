package com.example.activityobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val class1 = intent.getParcelableExtra<TestClass>("class1")
        textView2.text = "${class1?.data1}\n"
        textView2.append("${class1?.data2}")
        button2.setOnClickListener{
            val class2 = TestClass()
            class2.data1 = 200
            class2.data2 = "String 2"
            val intent = Intent()
            intent.putExtra("class2", class2)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}