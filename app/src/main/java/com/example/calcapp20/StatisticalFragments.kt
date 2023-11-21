package com.example.calcapp20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class StatisticalFragments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistical_fragments)


        val NumberText : EditText = findViewById(R.id.NumberText)
        var addButton : Button = findViewById(R.id.addButton)
        var displayTextView : TextView = findViewById(R.id.displayTextView)
        var clearButton : Button = findViewById(R.id.clearButton)
        var calcAverageButton : Button = findViewById(R.id.calcAverageButton)
        var MinMaxbutton : Button = findViewById(R.id.MinMaxbutton)
        var answerTextView : TextView = findViewById(R.id.answerTextView)

        val numberHistory = mutableListOf<Int>()
        //this is all the number that have been entered in the edit text (NumberText)
        // it will be stored as the 'numberHistory' in the TextView (displayTextView).

        addButton.setOnClickListener {
            val number = NumberText.text.toString().toIntOrNull()


            if(number != null && numberHistory.size <10){
                numberHistory.add(number) //this will allow users to enter up to 10 numbers
                displayTextView.text = numberHistory.joinToString(" , ")
            }
            if(numberHistory.size == 10) {
                addButton.isEnabled = false
            //the button will NOT enter any more numbers after entering 10 numbers!
            }
            NumberText.text.clear()
        }




        clearButton.setOnClickListener {
            numberHistory.clear()
            displayTextView.text = ""
            addButton.isEnabled = true // this line of code is crucial as it will now re-enable the add button
                                       // because we have previously disabled it after 10 numbers have been entered in the editText!
        }

        calcAverageButton.setOnClickListener {
            val displayTextView = displayTextView.text.toString()
            val numberStrings = displayTextView.split(" ")
            val numbers = numberStrings.mapNotNull { it.toDoubleOrNull() }
        //calculating the average  on button press.
            if (numbers.isNotEmpty()) {
                val average = numbers.average()
                answerTextView.text = "Average: $average"
            } else {
                answerTextView.text = "No valid numbers to calculate the average."
                //error check, if no numbers are entered
            }
        }
            MinMaxbutton.setOnClickListener {
                val valuesText = displayTextView.text.toString()
                if(valuesText.isBlank()){
                    answerTextView.text = "Error: NO numeric values have been entered! "
                }
                val values = valuesText.split(",").map { it.trim().toInt() }
                val minValue = values.minOrNull()
                val maxValue = values.maxOrNull()

                answerTextView.text = "Min Value: $minValue, " +
                        "Max Value: $maxValue"

                //on this button press, max and min will be calculated.
                //an error check has also been entered to tell the users that there are no values to calculate in the textview.
        }
    }
}