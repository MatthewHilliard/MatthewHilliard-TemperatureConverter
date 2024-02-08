package com.example.matthewhilliard_temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val celsiusSeekbar = findViewById<SeekBar>(R.id.celsiusSeekBar)
        val fahrenheitSeekbar = findViewById<SeekBar>(R.id.fahrenheitSeekBar)

    }
}