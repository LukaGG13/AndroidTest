package com.example.androidtest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

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
        val uri: Uri = Uri.parse("smsto:003855194712541")
        val intent = Intent(Intent.ACTION_SENDTO,uri)
        intent.putExtra("sms_body",text.text)
        startActivity(intent)
    }
}