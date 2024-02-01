package com.example.androidtest

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var text : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text  = findViewById(R.id.textView)
    }
    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext, "onStart", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onStart")
    }
    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext, "onRestart", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "onDestroy", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onDestroy")
    }
    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "onPause", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onPause")
    }
    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext, "onResume", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onResume")
    }
    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext, "onStop", Toast.LENGTH_SHORT).show()
        Log.i("MyLog", "onStop")
    }
    fun setOnClickListener1(view: View){
        Log.i("button","tipkica")
        text.text = (text.text.toString().toInt() + 1).toString()
    }

    fun setOnClickListener2(view: View){
        Log.i("button","tipkica")
        if(text.text.toString().toInt() > 0)
            text.text = (text.text.toString().toInt() - 1).toString()
    }

//    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
//        super.onSaveInstanceState(outState)
//        Log.i("MyTag", "onSaveInstanceState")
//
//        outState.putInt("COUNT_KEY", text.text.toString().toInt())
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // Here You have to restore count value
//        super.onRestoreInstanceState(savedInstanceState)
//        Log.i("MyTag", "onRestoreInstanceState")
//
//        text.text = savedInstanceState.getInt("COUNT_KEY").toString()
//    }
}