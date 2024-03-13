package com.example.androidtest

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale


class MainActivity : AppCompatActivity() {
    private lateinit var text : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.myToolbar))
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        Toast.makeText(applicationContext, "onCreateOptionsMenu", Toast.LENGTH_SHORT).show()
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun setOnClickListener1(view: View){
        Log.i("button","tipkica")
        text.text = (text.text.toString().toInt() + 1).toString()
        if(text.text.toString().toInt() == 10){
            val myIntent = Intent(this, SuccessActivity::class.java).apply{
                putExtra("name",findViewById<TextView>(R.id.plainTextName).text.toString())
            }
            text.text = "0"
            startActivity(myIntent)
        }
    }

    fun setOnClickListener2(view: View){
        Log.i("button","tipkica")
        if(text.text.toString().toInt() > 0)
            text.text = (text.text.toString().toInt() - 1).toString()
    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
        super.onSaveInstanceState(outState)
        Log.i("MyTag", "onSaveInstanceState")

        text  = findViewById(R.id.textView)
        outState.putInt("COUNT_KEY", text.text.toString().toInt())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // Here You have to restore count value
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("MyTag", "onRestoreInstanceState")

        text.text = savedInstanceState.getInt("COUNT_KEY").toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.restore_counter -> {
                text.text = "0"
                true
            }

            R.id.croatian -> {
                changeLanguage(this,"hr")
                recreate()
                true
            }

            R.id.english-> {
                changeLanguage(this,"en")
                recreate()
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @Suppress("DEPRECATION")
    fun changeLanguage(context: Context, language: String) {
        Toast.makeText(applicationContext, "changeLanguage", Toast.LENGTH_SHORT).show()
        val locale = Locale(language)
        Locale.setDefault(locale)
        val res = context.resources
        val config = Configuration(res.configuration)
        config.setLocale(locale)
        context.createConfigurationContext(config)
        res.updateConfiguration(config, res.displayMetrics)
    }
}