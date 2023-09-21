package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var percentual = savedInstanceState?.getDouble("percentual", 0.7) ?: 0.7
        Log.d("PDM23","No onCreate, $percentual")

        val btCalc: Button = findViewById(R.id.btCalcular)
        btCalc.setOnClickListener {
            val gasolina = findViewById<EditText>(R.id.edGasolina).text.toString().toInt()
            val alcool = findViewById<EditText>(R.id.edAlcool).text.toString().toInt()
            if (alcool <= gasolina * percentual) {
                val toast = Toast.makeText(this, "O alcool vale mais a pena", Toast.LENGTH_SHORT)
                toast.show()
            } else {
                val toast = Toast.makeText(this, "A gasolina vale mais a pena", Toast.LENGTH_SHORT)
                toast.show()
            }
            Log.d("PDM23", "No btCalcular, $percentual")
        }

        findViewById<Switch>(R.id.swPercentual).setOnClickListener {
            percentual = if (percentual == 0.7) 0.75 else 0.7
            savedInstanceState?.putDouble("percentual", percentual)
        }
    }
}