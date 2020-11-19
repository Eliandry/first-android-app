package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
lateinit var myObserver: MyObserver
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myObserver = MyObserver()
        lifecycle.addObserver(myObserver)
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
    fun randomMe(view: View){
        val randomIntent=Intent(this, activity_second::class.java)
        val countString = textView.text.toString()
        val count:Int =countString.toInt()
        randomIntent.putExtra(activity_second.TOTAL_COUNT,count)
        startActivity(randomIntent)
    }
    private fun toastMeState(message: String){
        Toast.makeText(this, "${lifecycle.currentState}, $message", Toast.LENGTH_LONG).show()
    }
    override fun onStart() {
        super.onStart()
        toastMeState("ON_START")
    }
    override fun onResume() {
        super.onResume()
        toastMeState("ON_RESUME")
    }
    override fun onPostResume() {
        super.onPostResume()
        toastMeState("onPostResume")
    }
    override fun onPause() {
        super.onPause()
        toastMeState("ON_PAUSE")
    }

    override fun onStop() {
        super.onStop()
        toastMeState("ON_STOP")
    }
}
