package com.example.calcapp20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1EditText: EditText = findViewById(R.id.num1EditText)
        val num2EditText: EditText = findViewById(R.id.num2EditText)
        var resultTextView: TextView = findViewById(R.id.resultTextView)
        var addButton: Button = findViewById(R.id.addButton)
        var subtractButton: Button = findViewById(R.id.subtractButton)
        var multiplyButton: Button = findViewById(R.id.multiplyButton)
        var divisionButton: Button = findViewById(R.id.divisionButton)
        var sqrtButton: Button = findViewById(R.id.sqrtButton)
        var powerButton: Button = findViewById(R.id.powerButton)
        var stats_button: Button = findViewById(R.id.stats_button)

        addButton.setOnClickListener {
            val num1 = num1EditText.text.toString().toDouble()
            val num2 = num2EditText.text.toString().toDouble()
            val sum = num1 + num2
            resultTextView.text =
                "" + num1 + "+" + num2 + "=" + sum // this will display the sum in this way for e.g (5.0 + 5.0 = 10.0)
        }
        subtractButton.setOnClickListener {
            val num1 = num1EditText.text.toString().toDouble() // this button will provide the math function (subtraction)
            val num2 = num2EditText.text.toString().toDouble()
            val sum = num1 - num2
            resultTextView.text = "" + num1 + "-" + num2 + "=" + sum // the result view will display the answer in the correct format
        }
        multiplyButton.setOnClickListener {
            val num1 = num1EditText.text.toString().toDouble()// this button will provide the math function (multiplication)
            val num2 = num2EditText.text.toString().toDouble()
            val sum = num1 * num2
            resultTextView.text = "" + num1 + "*" + num2 + "=" + sum // the result view will display the answer in the correct format
        }
        divisionButton.setOnClickListener {
            val num1 = num1EditText.text.toString().toDouble() // this button will provide the math function (division)
            val num2 = num2EditText.text.toString().toDouble()
            if (num2 == 0.0) { //if zero is entered in num2, an error message will be displayed in the textview. (coded below)
                resultTextView.text = "Error:  Division by 0 is not allowed!"
            } else {
                val sum = num1 / num2
                resultTextView.text = "" + num1 + "/" + num2 + "=" + sum // the result view will display the answer in the correct format
            }
        }
        powerButton.setOnClickListener {
            val num1 = num1EditText.text.toString().toDouble() // this button will provide the math function (power of _ _)
            val num2 = num2EditText.text.toString().toDouble()
            val sum = Math.pow(num1, num2)
            resultTextView.text = "" + num1 + "^" + num2 + "=" + sum

        }
        sqrtButton.setOnClickListener {
            val num1 = num1EditText.text.toString().toDouble() // this button will provide the math function (square root of _)
            val sum = Math.sqrt(num1)
            if (num1 < 0) {
                val sum = Math.sqrt(Math.abs(num1))
                resultTextView.text = " sqrt($num1) =${sum}i" //this code will display the imaginary "i" for negative values entered
            } else {
                val sum = Math.sqrt(num1)
                resultTextView.text = "" + "sqrt($num1) = $sum"
            }
            stats_button.setOnClickListener {
                val intent = Intent(this, StatisticalFragments::class.java)
                    startActivity(intent)
            }
            //https://youtu.be/v24Bhk7wqI8
            //https://youtu.be/Zi1XgFTUH9k
        }
    }
}


