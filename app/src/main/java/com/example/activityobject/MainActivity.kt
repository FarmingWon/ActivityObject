package com.example.activityobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val SECOND_ACTIVITY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            val test1 = TestClass()
            test1.data1 = 100
            test1.data2 = "String 1"
            intent.putExtra("class1", test1)
            startActivityForResult(intent, SECOND_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == SECOND_ACTIVITY){
            if(resultCode == RESULT_OK){
                val obj2 = data?.getParcelableExtra<TestClass>("class2")
                textView.text = "${obj2?.data1}\n"
                textView.append("${obj2?.data2}")
            }
        }
    }
}