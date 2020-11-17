package com.example.firstapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun toastMe(view: View) {
        val myToast = Toast.makeText(applicationContext,"Hello, Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }
    fun countMe(view: View){
        val countString=textView.text.toString()
        val count:Int =1+countString.toInt()
        textView.text=count.toString()
    }
}
