package com.yunjin.lec7

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다!")
    }
}

fun main() {
    println(parseIntOrThrow("1"))
    println(parseIntOrThrow("abc"))
}