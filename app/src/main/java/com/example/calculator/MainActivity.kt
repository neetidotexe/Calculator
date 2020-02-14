package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast



class MainActivity : AppCompatActivity() {

    private lateinit var resultText:TextView
    private lateinit var calculation: Calculation

    private var opr:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText= findViewById<TextView>(R.id.text_result)
        //declaring all variables
        val oneButton = findViewById<Button>(R.id.button_1)
        val twoButton = findViewById<Button>(R.id.button_2)
        val threeButton = findViewById<Button>(R.id.button_3)
        val fourButton = findViewById<Button>(R.id.button_4)
        val fiveButton = findViewById<Button>(R.id.button_5)
        val sixButton = findViewById<Button>(R.id.button_6)
        val sevenButton = findViewById<Button>(R.id.button_7)
        val eightButton = findViewById<Button>(R.id.button_8)
        val nineButton = findViewById<Button>(R.id.button_9)
        val zeroButton = findViewById<Button>(R.id.button_0)
        val plusButton = findViewById<Button>(R.id.button_plus)
        val minusButton = findViewById<Button>(R.id.button_minus)
        val multiplyButton = findViewById<Button>(R.id.button_multiply)
        val divideButton = findViewById<Button>(R.id.button_divide)
        val equalButton = findViewById<Button>(R.id.button_equal)
        val clearBuutton = findViewById<Button>(R.id.button_clear)
        val decimalButton=findViewById<Button>(R.id.button_decimal)

        //Clear Operation
        clearBuutton.setOnClickListener {
            clear()
        }

        //Operations
        plusButton.setOnClickListener {
            if (resultText.length() <= 0) {
                val toast = Toast.makeText(this, "can not press + without numbers", Toast.LENGTH_LONG)
                toast.show()
            }else if((resultText.text.contains('+'))||
                (resultText.text.contains('x')) || (resultText.text.contains('/'))) {
                equal()
                opr=1
                resultText.append("+").toString()
            }else if((resultText.text.contains('-'))){
                var frq:Int=minusFrequency(resultText.text.toString())
                if(frq==1){
                    opr=1
                    resultText.append("+").toString()
                }else if(frq==2){
                    equal()
                    opr=1
                    resultText.append("+").toString()
                }
            } else {
                opr=1
                resultText.append("+").toString()
            }
        }

        minusButton.setOnClickListener {
            if((resultText.text.contains('+'))||
                (resultText.text.contains('x')) || (resultText.text.contains('/'))) {
                equal()
                opr=2
                resultText.append("-").toString()
            }else if((resultText.text.contains('-'))){
                var frq:Int=minusFrequency(resultText.text.toString())
                if(frq==1){
                    opr=2
                    resultText.append("-").toString()
                }else if(frq==2){
                    equal()
                    opr=2
                    resultText.append("-").toString()
                }
            }else {
                opr=2
                resultText.append("-").toString()
            }
        }

        multiplyButton.setOnClickListener {
            if (resultText.length() <= 0) {
                val toast = Toast.makeText(this, "can not press * without numbers", Toast.LENGTH_LONG)
                toast.show()
            }else if((resultText.text.contains('+')) ||
                (resultText.text.contains('x')) || (resultText.text.contains('/'))){
                equal()
                opr=3
                resultText.append("x").toString()
            }else if((resultText.text.contains('-'))){
                var frq:Int=minusFrequency(resultText.text.toString())
                if(frq==1){
                    opr=3
                    resultText.append("x").toString()
                }else if(frq==2){
                    equal()
                    opr=3
                    resultText.append("x").toString()
                }
            } else {
                opr=3
                resultText.append("x").toString()
            }
        }

        divideButton.setOnClickListener {
            if (resultText.length() <= 0) {
                val toast = Toast.makeText(this, "can not press / without numbers", Toast.LENGTH_LONG)
                toast.show()
            }else if((resultText.text.contains('+')) ||
                (resultText.text.contains('x')) || (resultText.text.contains('/'))){
                equal()
                opr=4
                resultText.append("/").toString()
            }else if((resultText.text.contains('-'))){
                var frq:Int=minusFrequency(resultText.text.toString())
                if(frq==1){
                    opr=4
                    resultText.append("/").toString()
                }else if(frq==2){
                    equal()
                    opr=4
                    resultText.append("/").toString()
                }
            }else {
                opr=4
                resultText.append("/").toString()
            }
        }

        //calculate result
        equalButton.setOnClickListener {
            if (resultText.length() <= 0) {
                val toast = Toast.makeText(this, "can not press = without numbers", Toast.LENGTH_LONG)
                toast.show()
            } else {
                equal()//calling equal method
            }
        }

        //Numbers
        oneButton.setOnClickListener {
            resultText.append("1").toString()
        }

        twoButton.setOnClickListener {
            resultText.append("2").toString()
        }

        threeButton.setOnClickListener {
            resultText.append("3").toString()
        }

        fourButton.setOnClickListener {
            resultText.append("4").toString()
        }


        fiveButton.setOnClickListener {
            resultText.append("5").toString()
        }

        sixButton.setOnClickListener {
            resultText.append("6").toString()
        }

        sevenButton.setOnClickListener {
            resultText.append("7").toString()
        }

        eightButton.setOnClickListener {
            resultText.append("8").toString()
        }

        nineButton.setOnClickListener {
            resultText.append("9").toString()
        }

        zeroButton.setOnClickListener {
            resultText.append("0").toString()
        }

        decimalButton.setOnClickListener {
            resultText.append(".").toString()
        }
    }

    private fun clear() {
        findViewById<TextView>(R.id.text_result).text = ""
    }

    private fun equal(){
        calculation=Calculation(this)
        var result:Double = calculation.calculate(resultText.text.toString(),opr)
        resultText.setText(result.toString())
        }

    private fun minusFrequency(expression:String):Int{
        var frq:Int=0;
        for(i in 0..expression.length-1){
            if (expression[i].equals('-')){
                    frq=frq+1
                }
        }
        return frq
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("resultTextValue",resultText.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        resultText.setText(savedInstanceState.getString("resultTextValue"))
    }
}




