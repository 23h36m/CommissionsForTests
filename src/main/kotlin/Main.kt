package ru.netology

const val TYPE_MC = "MasterCard"
const val ERROR_WRONG_TYPE = -1.0
const val ERROR_LIMIT = -2.0

fun main() {
    println(commission("MasterCard", 100000, 0))
}

fun commission (typeCard : String, transfer : Int, past : Int) : Double {
    return when (typeCard) {
        TYPE_MC -> if (transfer > 150000 || transfer + past > 600000) {
            ERROR_LIMIT
        } else {
            if (transfer <= 75000) 0.0 else (transfer * 0.006) + 20
        }
        else -> ERROR_WRONG_TYPE
    }
}