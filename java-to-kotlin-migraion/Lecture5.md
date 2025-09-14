# 코틀린에서 제어문(조건문)을 다루는 방법
- if문
- Expression과 Statement
- switch와 when

## if문 
- Java와 동일하게 사용하며 소괄호에 조건문 넣고, 블락으로 중괄호로 감싼다.
```kotiln
if (조건) {
...
}
```
## Expression과 Statement
- Java에서 if-else는 Statement이지만, Kotiln에서는 **Expression**이다.
- Statement : 프로그램의 문장 전체, 하나의 값으로 도출되지 않는다.
- Expression : 하나의 값으로 도출되는 문장
- Statement > Expression : Statement 중에 하나의 값으로 도출되는 문장이 Expression인 거다.

```kotiln
fun getPassOrFail(score: Int): String {
    return if (score >= 50) { 
        "P"
    } else {
        "F"
    }
}
```
- 코틀린은 return문으로 if-else를 Expression으로 사용할 수 있기 때문에 3항 연산자가 없다.

### 특정 범위에 포함 여부 판단
- in 범위 조건문

```kotiln
fun getPassOrFail(score: Int): String {
    return if (score in 50..100) { 
        "P"
    } else {
        "F"
    }
}
```

## switch와 when
- Java의 switch문은 코틀린에서 when으로 대체되고, case 대신에 바로 조건 경우를 작성하고 -> 화살표로 분기를 친다. default 대신에 else를 사용한다.
- when은 Expression이다.
```kotlin
fun getGradleWithSwitch(score: Int): String {
    return when (score / 10) {
        in 90..99 -> "A"
        80 -> "B"
        70 -> "C"
        60 -> "D"
        else -> "F"
    }
}
```

### 특정 타입 확인
- 자바에서 if, instanceof를 활용해서 when과 is를 사용해서 처리할 수 있음.
```kotlin
fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}
```
- is 타입 확인을 한다. startsWith를 바로 쓸 수 있다. Smart Case

### 여러 조건 확인
- 자바에서 if or 논리 연산자로 조건을 여러개 확인한 것을 코틀린은 when에서 ,로 구분해서 여러 조건을 확인할 수 있다.

```kotlin
fun judgeNumber (number: Int) {
    when (number) {
        1, 0, 1 -> printtn("어디서 많이 본 숫자입니다")
        else -> println("1, 0, -10 아닙니다")
    }
}
```


> when은 Enum Class 혹은 Sealed Class와 함께 사용할 경우, 더욱 더 진가를 발휘한다. (다음 강의에서 확인!)