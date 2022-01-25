package com.firstaap.siapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPrincipal: EditText = findViewById(R.id.etPrincipal)
        val etRate: EditText = findViewById(R.id.etRate)
        val etTime: EditText = findViewById(R.id.etTime)

        val tvSi: TextView = findViewById(R.id.tvSi)

        val btnCalculate: Button = this.findViewById(R.id.btnCalculate)
        btnCalculate.setOnClickListener{

            if (etPrincipal.text.toString().length==0)
            {
                etPrincipal.error="Enter Principal"
                etPrincipal.setSelection(0)
                return@setOnClickListener
            }
            var principal: Float = etPrincipal.text.toString().toFloat()


            if (etRate.text.toString().length==0)
            {
                etRate.error="Enter Rate"
                etRate.setSelection(0)
                return@setOnClickListener
            }
            var rate: Float = etRate.text.toString().toFloat()


            if (etTime.text.toString().length==0)
            {
                etTime.error="Enter Time"
                etTime.setSelection(0)
                return@setOnClickListener
            }
            var time: Float = etTime.text.toString().toFloat()

            var SI: Float = (principal*rate*time)/100f

            tvSi.text = "SI: "+SI
        }
        val btnReset: Button = this.findViewById(R.id.btnReset)
        btnReset.setOnClickListener{
            etPrincipal.setText("")
            etRate.setText("")
            etTime.setText("")

            tvSi.setText("SI: ")
        }
    }
}