package ru.netology

const val TYPE_MC = "MasterCard"
const val TYPE_VISA = "Visa"
const val TYPE_VkPay = "VKPay"
const val ERROR_WRONG_TYPE = -1.0
const val ERROR_LIMIT = -2.0

fun main() {
    println(commission("MasterCard", 100000, 0))
}

fun commission (typeCard : String, transfer : Int, past : Int) : Double {
   return if (transfer > 150000 || transfer + past > 600000) {
         ERROR_LIMIT
    } else {
        when (typeCard) {
            TYPE_MC -> if (transfer <= 75000) 0.0 else (transfer * 0.006) + 20
            TYPE_VISA -> if (transfer * 0.0075 > 35) transfer * 0.0075 else 35.0
            TYPE_VkPay -> 0.0
            else -> ERROR_WRONG_TYPE
        }
    }
}
