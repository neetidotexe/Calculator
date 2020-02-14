package com.example.calculator

import android.content.Context
import android.widget.Toast
import java.lang.Exception

class Calculation( private var context:Context) {


    fun calculate(expression: String,opr:Int): Double {
        val expr1: Double
        val expr2: Double

        if (opr == 1) {//addition
            val index: Int = expression.indexOf('+', 0, true)
            expr1 = expression.substring(0, index).toDouble()
            expr2 = expression.substring(index + 1, expression.length).toDouble()
            try {
                return expr1 + expr2
            } catch (e: Exception) {
                val toast = Toast.makeText(context, e.toString(), Toast.LENGTH_LONG)
                toast.show()
                return 0.0
            }
        } else if (opr == 2) {//subtraction
            val index: Int = expression.indexOf('-', 0, true)
            expr1 = expression.substring(0, index).toDouble()
            expr2 = expression.substring(index + 1, expression.length).toDouble()
            try {
                return expr1 - expr2
            } catch (e: Exception) {
                val toast = Toast.makeText(context, e.toString(), Toast.LENGTH_LONG)
                toast.show()
                return 0.0
            }
        } else if (opr == 3) {//multiplication
            val index: Int = expression.indexOf('x', 0, true)
            expr1 = expression.substring(0, index).toDouble()
            expr2 = expression.substring(index + 1, expression.length).toDouble()
            try {
                return expr1 * expr2
            } catch (e: Exception) {
                val toast = Toast.makeText(context, e.toString(), Toast.LENGTH_LONG)
                toast.show()
                return 0.0
            }
        } else if (opr == 4) {//division
            val index: Int = expression.indexOf('/', 0, true)
            expr1 = expression.substring(0, index).toDouble()
            expr2 = expression.substring(index + 1, expression.length).toDouble()
            try {
                return expr1 / expr2
            } catch (e: Exception) {
                val toast = Toast.makeText(context, e.toString(), Toast.LENGTH_LONG)
                toast.show()
                return 0.0
            }

        } else
            return 0.0
    }




}