# 코틀린에서 변수를 다루는 방법
1. 코틀린에서 변수를 다루는 방법
2. 코틀린에서 null을 다루는 방법

## 1. 코틀린에서 변수를 다루는 방법

### var vs val
- var는 변경이 가능한 변수
- val는 불변 변수에 사용 가능하다. (read-only)
- val 컬렉션에서는 element를 추가할 순 있다!!! 

### 타입 추론
```kotlin
val number: 10L
-> val number: Long = 10L
```
- 타입을 명시적으로 적을 수도 있고, 명시하지 않아도 알아서 추론해준다.


### Primitive Reference Type을 구분하지 않는다.
- kotlin이 알아서 boxing, unboxing을 고려해서 처리해준다.
- 이펙티브 Java에서는 boxing, unboxing 교환이 일어나면서 불필요한 객체 생성으로 추천하지 않지만, 코틀린에서는 다름.

### 인스턴스 변수 new를 붙이지 않는다!
- 객체를 인스턴스화 할 때는 new를 붙이지 않다도 된다.
```kotlin
val person = Person("곽윤진")
```


## 2. 코틀린에서 null을 다루는 방법
- 코틀린에서는 null이 가능한 타입을 완전히 다르게 취급한다.
- nullable type, safe call, elvis, !!, 플랫폼 타입에 대해서 알아보자!

### ?
- null이 들어갈 수 있는 타입이 존재함. -> 변수?

### Safe Call
- ?.
- null이 아니면 실행하고, null이면 실행하지 않는다.
- null이면 null로 반환된다.
- null이 들어갈 수 있음을 명시한다!

```kotlin
val str: String? = "ABC"
str?.length // 가능
str.length // 불가능
```


### Elvis (엘비스)
- null인 경우에만 호출되는 연산자가 있다. ?:
- early return 에도 사용할 수 있다.

```kotlin
fun calculate(number: Long?): Long {
    number ?: return 0
}
```

### !!
- nullable type이지만, null이 될 수 없는 경우 사용 가능.
- 혹시나 null이 들어오면 NPE가 나오기 때문에 null이 아닌게 확실한 경우 사용

### 플랫폼 타입
- 코틀린이 null 관련 정보를 알 수 없는 타입
- 컴파일 오류는 안나지만, 런타임 오류 날 수 있음.

