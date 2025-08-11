package com.yunjin.lec9

fun main() {
    val kotlinPerson = KotilnPerson("코틀린", 10)
    print(kotlinPerson.name)
    kotlinPerson.age = 11
    val javaPeron = JavaPerson("자바", 30)
    print(javaPeron.name)
    javaPeron.age = 31
}

class KotilnPerson constructor(
    name: String,
    age: Int
) {
    val name: String = name
    var age: Int = age

    init {
        if(age <= 0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다")
        }
    }

    constructor(name: String) : this(name, 0) {// 부생성자(secondary constructor
        print("첫번째 부생성자")
    }
    constructor(): this("new 사람") {
        print("두번째 부생성자")
    }

    val isAdult: Boolean
        get() = this.age >= 2
}