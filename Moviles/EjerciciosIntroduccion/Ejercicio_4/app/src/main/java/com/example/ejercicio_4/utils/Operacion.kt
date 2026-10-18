package com.example.ejercicio_4.utils

class Operacion ( val operacion : Ops, val num1: Int, val num2: Int){

    fun asignarOps(opcion : String): Ops{
        return when(opcion.lowercase()){
            "suma" -> Ops.SUMA
            "resta" -> Ops.RESTA
            "division" -> Ops.DIVISION
            "multiplicacion" -> Ops.MULTIPLICACION
            else -> Ops.OPCION
        }
    }

    fun responderOperacion(): String{
        return when(operacion){
            Ops.SUMA -> (num1 + num2).toString()
            Ops.RESTA -> (num1 - num2).toString()
            Ops.DIVISION -> if (num2 == 0 ){
                    "No se puede dividir entre 0"
                } else {
                    (num1/num2).toString()
                }
            Ops.MULTIPLICACION -> (num1 * num2).toString()
            else -> "Operacion vacia"
        }
    }

}