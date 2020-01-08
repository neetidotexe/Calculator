package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView
    private var opr: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declaring all variables
        resultText = findViewById<TextView>(R.id.text_result)
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
            resultText.text = ""
            opr=0  //clear the operations as well
        }

        //Operations
        //addition
        plusButton.setOnClickListener {
            var len: Int = resultText.length()
            if (len <= 0) {
                val toast = Toast.makeText(this, "can not press + without numbers", Toast.LENGTH_LONG)
                toast.show()
            } else if (resultText.text.get(len - 1).equals('-') || resultText.text.get(len - 1).equals('/') || resultText.text.get(len - 1).equals('x')) {
                val toast = Toast.makeText(this, "can not press two operations without operands", Toast.LENGTH_LONG)
                toast.show()
            } else if(opr!=0){
                equalFun()
                opr=1
                resultText.append("+").toString()
            } else {
                opr = 1
                resultText.append("+").toString()
            }
        }

        //subtraction
        minusButton.setOnClickListener {
            var len: Int = resultText.length()
            if (len <= 0) {
                resultText.append("-").toString()
            }else if (resultText.text.get(len - 1).equals('+') || resultText.text.get(len - 1).equals('/') || resultText.text.get(len - 1).equals('x')) {
                val toast = Toast.makeText(this, "can not press two operations without operands", Toast.LENGTH_LONG)
                toast.show()
            } else if(opr!=0){
                equalFun()
                opr=2
                resultText.append("-").toString()
            }  else {
                opr = 2
                resultText.append("-").toString()
            }
        }

        //multiplication
        multiplyButton.setOnClickListener {
            var len: Int = resultText.length()
            if (len <= 0) {
                val toast = Toast.makeText(this, "can not press * without numbers", Toast.LENGTH_LONG)
                toast.show()
            } else if (resultText.text.get(len - 1).equals('+') || resultText.text.get(len - 1).equals('-') || resultText.text.get(len - 1).equals('/')) {
                val toast = Toast.makeText(this, "can not press two operations without operands", Toast.LENGTH_LONG)
                toast.show()
            } else if(opr!=0){
                equalFun()
                opr=3
                resultText.append("x").toString()
            }  else {
                opr = 3
                resultText.append("x").toString()
            }
        }

        //division
        divideButton.setOnClickListener {
            var len: Int = resultText.length()
            if (len <= 0) {
                val toast = Toast.makeText(this, "can not press / without numbers", Toast.LENGTH_LONG)
                toast.show()
            } else if (resultText.text.get(len - 1).equals('+') || resultText.text.get(len - 1).equals('-') || resultText.text.get(len - 1).equals('x')) {
                val toast = Toast.makeText(this, "can not press two operations without operands", Toast.LENGTH_LONG)
                toast.show()
            } else if(opr!=0){
                equalFun()
                opr=4
                resultText.append("/").toString()
            }  else {
                opr = 4
                resultText.append("/").toString()
            }
        }

        //calculate result...call equalFun function
        equalButton.setOnClickListener {
            equalFun()
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
    private fun calculate(expression: String, oprn: Int): Int {
        val expr1: Int
        val expr2: Int

        if (opr == 1) {
            val index: Int = expression.indexOf('+', 0, true)
            try {
                expr1 = expression.substring(0, index).toInt()
                expr2 = expression.substring(index + 1, expression.length).toInt()
                return expr1 + expr2
            } catch (ex: Exception) {
                return 2
            }
        } else if (opr == 2) {
            val index: Int = expression.indexOf('-', 0, true)
            try {
                expr1 = expression.substring(0, index).toInt()
                expr2 = expression.substring(index + 1, expression.length).toInt()
                return expr1 - expr2
            } catch (ex: Exception) {
                val toast=Toast.makeText(this,ex.localizedMessage,Toast.LENGTH_LONG)
                toast.show()
                return 2
            }
        } else if (opr == 3) {
            val index: Int = expression.indexOf('x', 0, true)
            try {
                expr1 = expression.substring(0, index).toInt()
                expr2 = expression.substring(index + 1, expression.length).toInt()
                return expr1 * expr2
            } catch (ex: Exception) {
                return 2
            }
        } else if (opr == 4) {
            val index: Int = expression.indexOf('/', 0, true)
            try {
                expr1 = expression.substring(0, index).toInt()
                expr2 = expression.substring(index + 1, expression.length).toInt()
                //check for divide by zero error
                if (expr2 == 0) {
                    return 1
                }else{
                return expr1 / expr2}
            }
            catch(ex: Exception) {
                return 2
            }
        }else
            return 0
    }

    private fun equalFun(){
        if (resultText.length() <= 0) {
            val toast = Toast.makeText(this, "can not press = without numbers", Toast.LENGTH_LONG)
            toast.show()
        } else {
            var result: Int = calculate(resultText.text.toString(), opr)
            if (result == 1) {
                resultText.text = "Can't divide a number by 0"
            } else if(result==2){
                resultText.text="Operands out of limit"//can't be greater than 2147483647 or less than -2147483647"
            } else {
                resultText.setText(result.toString())
            }
        }
    }
}


