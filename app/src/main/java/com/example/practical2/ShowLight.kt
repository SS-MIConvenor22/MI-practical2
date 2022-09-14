package com.example.practical2

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ShowLight : AppCompatActivity() , SensorEventListener  {
    private lateinit var light: Sensor
    private lateinit var sensor_mgr: SensorManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_light)
        sensor_mgr = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        light= sensor_mgr.getDefaultSensor(Sensor.TYPE_LIGHT)
        sensor_mgr.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL)

    }

    fun buttonPressed(view: View) {
        val textView = findViewById<TextView>(R.id.lightValue)
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("LUX",textView.text)
        setResult(RESULT_OK,intent)
        finish()
        //startActivity(intent)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        val textView = findViewById<TextView>(R.id.lightValue)
        textView.text = p0!!.values[0].toString()
        // Challenge 3
        var darkness = 255 - p0.values[0].toInt()
        if (darkness <0){ darkness = 0}
        textView.setTextColor(Color.argb(255,darkness,darkness,darkness))

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    // Challenge 2
    override fun onPause() {
        //we no longer need the sensor data since we are not in focus.
        super.onPause()
        sensor_mgr.unregisterListener(this)
    }

    override fun onResume() {
        //the user has come back! start listening again.
        super.onResume()
        sensor_mgr.registerListener(this,light,SensorManager.SENSOR_DELAY_NORMAL)
    }
}


