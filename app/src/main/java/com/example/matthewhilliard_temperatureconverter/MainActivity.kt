package com.example.matthewhilliard_temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var updatingCelsius = true
        var updatingFahrenheit = true

        val celsiusSeekbar = findViewById<SeekBar>(R.id.celsiusSeekBar)
        val fahrenheitSeekbar = findViewById<SeekBar>(R.id.fahrenheitSeekBar)

        val celsiusReading = findViewById<TextView>(R.id.celsiusReading)
        val fahrenheitReading = findViewById<TextView>(R.id.fahrenheitReading)
        val secretMessage = findViewById<TextView>(R.id.secretMessage)

        celsiusSeekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (updatingCelsius) {
                    updatingFahrenheit = false
                    celsiusReading.text = progress.toString()
                    if(progress <= 20){
                        secretMessage.text = getString(R.string.warmer_text)
                    } else {
                        secretMessage.text = getString(R.string.colder_text)
                    }
                    fahrenheitSeekbar.progress = ((progress * (9.0 / 5.0)) + 32).toInt()
                    fahrenheitReading.text = fahrenheitSeekbar.progress.toString()
                    updatingFahrenheit = true
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        fahrenheitSeekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (updatingFahrenheit) {
                    updatingCelsius = false
                    fahrenheitReading.text = progress.toString()
                    if(progress <= 68){
                        secretMessage.text = getString(R.string.warmer_text)
                    } else {
                        secretMessage.text = getString(R.string.colder_text)
                    }
                    celsiusSeekbar.progress = ((progress - 32) * 5.0 / 9.0).toInt()
                    celsiusReading.text = celsiusSeekbar.progress.toString()
                    updatingCelsius = true
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if(fahrenheitSeekbar.progress < 32){
                    fahrenheitReading.text = "32"
                    fahrenheitSeekbar.progress = 32
                }
            }
        })
    }
}