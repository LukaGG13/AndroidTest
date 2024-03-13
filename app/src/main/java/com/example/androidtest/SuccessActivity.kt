package com.example.androidtest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.RadioGroup
class SuccessActivity : AppCompatActivity() {
    private lateinit var text : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        text  = findViewById(R.id.SucText2)
        val textStr = intent.getStringExtra("name")
        text.text = "Bravo $textStr napravio si 10 koraka"
    }

    fun sendClick(view: View) {
        val numbersList = findViewById<RadioGroup>(R.id.numbersList)
        val rbId = numbersList.getCheckedRadioButtonId()
        val number = when (rbId) {
            R.id.radioButton1 -> "2988408"
            R.id.radioButton2 -> "9748129"
            R.id.radioButton3 -> "4978944"
            else -> "999999999"
        }
        val uri: Uri = Uri.parse("smsto:00385" + number)
        val intent = Intent(Intent.ACTION_SENDTO,uri)
        intent.putExtra("sms_body",text.text)
        startActivity(intent)
    }
}