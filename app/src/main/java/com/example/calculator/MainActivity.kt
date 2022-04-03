package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView : TextView
    private lateinit var operation : String
    private var firstValue : Double=0.0
    private var res : Double=0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }
    fun operationClick(View: View){
        firstValue = resultTextView.text.toString().toDouble()
        if(View is Button) {
            operation = View.text.toString()
            resultTextView.text =""
        }


    }

    fun numberClick(View:View){
        if(View is Button){
            if(resultTextView.text=="0" && View.text=="0")
                resultTextView.text = ""

            val textView = resultTextView.text.toString()
            val num = View.text.toString()
            resultTextView.text = textView+num
        }
    }

    fun equal(View: View){
        if(View is Button) {
            val secendValue = resultTextView.text.toString().toDouble()
            when (operation){
                "-" -> res = firstValue-secendValue
                "+" -> res = firstValue+secendValue
                "*" -> res = firstValue * secendValue
                "/" -> res = firstValue / secendValue
                "√" -> res = sqrt(resultTextView.text.toString().toDouble())
                "%" -> res = (firstValue * secendValue) / 100
            }
            resultTextView.text = res.toString()
        }
    }

    fun clear(View : View){
        if(View is Button){
            resultTextView.text = ""
        }
    }


}