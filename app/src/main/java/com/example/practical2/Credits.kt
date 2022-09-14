package com.example.practical2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

// Challenge 1
class Credits : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credits)
    }

    fun buttonPressed(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    // Challenge 4
    fun openPortfolio(view:View){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.york.ac.uk/arts-creative-technologies/people/sanjit-samaddar/")
        startActivity(intent)
    }
}