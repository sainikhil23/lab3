package com.example.lab2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var output: TextView
    private lateinit var mid: EditText
    private lateinit var device_number: EditText
    private lateinit var macOS: RadioButton
    private lateinit var windows: RadioButton
    private lateinit var priority: Spinner
    private lateinit var resultbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize your views
        output = findViewById(R.id.output)
        mid = findViewById(R.id.mid)
        device_number = findViewById(R.id.devNum)
        macOS = findViewById(R.id.macOS)
        windows = findViewById(R.id.windows)
        priority = findViewById(R.id.priority)
        resultbtn = findViewById(R.id.checkbtn)

        // Set an OnClickListener for your submit button
        resultbtn.setOnClickListener {
            displayResults()
        }
    }

    private fun displayResults() {
        // Get the selected and entered values
        val selectedOption = priority.selectedItem.toString()
        val enteredText = mid.text.toString()
        val enteredInteger = device_number.text.toString()
        val selectedRadio = if (macOS.isChecked) "MacOS" else "Windows"

        // Construct the result text
        val resultText = """
            Priority: $selectedOption
            School Id: $enteredText
            $selectedRadio
            Device Number: $enteredInteger
        """.trimIndent()

        // Display the result in the TextView
        output.text = resultText
    }
}
