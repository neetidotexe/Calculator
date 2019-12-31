package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IntegerRes
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var resultText:TextView
    private var opr:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declaring all variables
        resultText= findViewById<TextView>(R.id.text_result)
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

        //Clear Operation
        clearBuutton.setOnClickListener {
            clear()
        }


        //Operations
        plusButton.setOnClickListener {
            if (resultText.length() <= 0) {
                val toast = Toast.makeText(this, "can not press + without numbers", Toast.LENGTH_LONG)
                toast.show()
            } else {
                opr=1
                resultText.append("+").toString()
            }
        }

        minusButton.setOnClickListener {
            if (resultText.length() <= 0) {
                val toast = Toast.makeText(this, "can not press - without numbers", Toast.LENGTH_LONG)
                toast.show()
            } else {
                opr=2
                resultText.append("-").toString()
            }
        }

        multiplyButton.setOnClickListener {
            if (resultText.length() <= 0) {
                val toast = Toast.makeText(this, "can not press * without numbers", Toast.LENGTH_LONG)
                toast.show()
            } else {
                opr=3
                resultText.append("*").toString()
            }
        }

        divideButton.setOnClickListener {
            if (resultText.length() <= 0) {
                val toast = Toast.makeText(this, "can not press / without numbers", Toast.LENGTH_LONG)
                toast.show()
            } else {
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
                var result:Int = calculate(resultText.text.toString(),opr)
                resultText.setText(result.toString())
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

    }

    //calculate the operation
    fun calculate(expression: String,oprn:Int): Int {
        val expr1: Int
        val expr2: Int

        if(opr==1){
        val index: Int = expression.indexOf('+', 0, true)
        expr1=expression.substring(0,index).toInt()
        expr2=expression.substring(index+1,expression.length).toInt()
        return expr1+expr2
        }

        else if(opr==2){
            val index: Int = expression.indexOf('-', 0, true)
            expr1=expression.substring(0,index).toInt()
            expr2=expression.substring(index+1,expression.length).toInt()
            return expr1-expr2
        }

        else if(opr==3){
            val index: Int = expression.indexOf('*', 0, true)
            expr1=expression.substring(0,index).toInt()
            expr2=expression.substring(index+1,expression.length).toInt()
            return expr1*expr2
        }

        else if(opr==4){
            val index: Int = expression.indexOf('/', 0, true)
            expr1=expression.substring(0,index).toInt()
            expr2=expression.substring(index+1,expression.length).toInt()
            return expr1/expr2
        }
        else
            return 0
    }

    fun clear() {
        findViewById<TextView>(R.id.text_result).text = ""
    }
}




