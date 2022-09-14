package com.example.practical2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonPressed(view: View) {
        val intent = Intent(this,ShowLight::class.java)
        getActivityResult.launch(intent)
        //startActivity(intent)
    }

    fun showCredits(view: View) {
        val intent = Intent(this,Credits::class.java)
        startActivity(intent)
    }

    //Challenge 5
    private val getActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == Activity.RESULT_OK){
            val textView = findViewById<TextView>(R.id.prev_light_value)
            textView.text = it.data!!.getStringExtra("LUX")
        }

    }
}