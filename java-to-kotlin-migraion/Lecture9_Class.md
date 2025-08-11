# 코틀린에서 클래스를 다루는 방법
1. 클래스와 프로퍼티
2. 생성자와 init
3. 커스텀 getter, setter
4. backing field


## 1. 클래스와 프로퍼티


### 프로퍼티
- 프로퍼티란 [필드 + getter + setter]를 의미한다.


```java
// java
package com.yunjin.lec9;

public class JavaPerson {

    private final String name;
    private int age;

    public JavaPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

```kotlin
// kotlin
package com.yunjin.lec9
  
class KotilnPerson constructor( // 생성자
    name: String,
    age: Int
) {
    // 필드
    val name: String = name 
    val age: Int = age
}
```
- 클래스의 필드 선언과 생성자를 동시에 선언할 수 있다.
- 코틀린에서는 필드만 만들면 getter, setter 자동으로 만들어준다.
- 그러므로, 정확히는 프로퍼티 선언과 생성자를 동시에 합칠 수 있다.
- 생성자 constructor 키워드 생략 가능.

### 필드 접근

```kotlin
fun main() {
    val person = KotilnPerson("곽윤진", 30)
    print(person.name) // getter
    person.age = 10
}
class KotilnPerson constructor(
    name: String,
    age: Int
) {
    val name: String = name
    var age: Int = age // setter 예제를 위해 var로 변경
}
```
- .{필드}를 통해 getter와 setter를 바로 호출한다.

```kotlin
fun main() {
    val javaPeron = JavaPerson("자바", 30)
    print(javaPeron.name)
    javaPeron.age = 31
}
```
- java object 변수에도 .{필드}를 통해 접근 가능하다.


## 2. 생성자와 init
- 코틀린의 기본 생성자는 클래스의 가장 윗 부분에 만들어진다.
- 추가 생성자를 만들때는 { } 구현부에서 추가할 수 있음. constructor 라는 키워드와 함께 만들어져야 합니다.


### init
- 일반적으로 검증은 클래스 생성 시점에 검증 로직을 짠다. 
```java
// java
package com.yunjin.lec9;

public class JavaPerson {

    private final String name;
    private int age;

    public JavaPerson(String name, int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(String.format("나이는 %s일 수 없습니다", age));
        }
        this.name = name;
        this.age = age;
    }
}
```
```kotlin
fun main() {
    val javaPeron = JavaPerson("곽윤진")
    print(javaPeron.name)
}
class KotilnPerson constructor( // 주생성자(primary constructor)
    name: String,
    age: Int
) {
    val name: String = name
    val age: Int = age

    init {
        if(age <= 0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다")
        }
    }
}
```

### 주생성자와 부생성자
- 예를 들어, 이름을 넣으면 무조건 1살이다. 라는 요구사항이 있는 경우 부생성자를 이용해서 처리할 수 있다.

```java
// java
package com.yunjin.lec9;

public class JavaPerson {

    private final String name;
    private int age;

    public JavaPerson(String name, int age) { // 주생성자(primary constructor)
        this.name = name;
        this.age = age;
    }

    public JavaPerson(String name) { // ✅ init 생성자 - 부생성자(secondary constructor) 
        this(name, 1);
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

```kotlin
fun main() {
    val javaPeron = JavaPerson("곽윤진")
    print(javaPeron.name)
}
class KotilnPerson constructor( // 주생성자(primary constructor)
    name: String,
    age: Int
) {
    val name: String = name
    val age: Int = age
    
    constructor(name: String) : this(name, 0) // 부생성자(secondary constructor)
}
```
- 주생성자는 반드시 존재해야 한다. 단, 파라미터가 하나도 없어도 기본 생성자로 생성 가능..!
- 부생성자는 있을 수도 있고, 없을 수도 있다. 부생성자에서 주생성자를 this로 호출할 수 있고, body를 가질 수 있음..!!!

```kotlin
fun main() {
    val javaPeron = JavaPerson("곽윤진")
    print(javaPeron.name)
}
class KotilnPerson constructor( // 주생성자(primary constructor)
    name: String,
    age: Int
) {
    val name: String = name
    val age: Int = age

    constructor(name: String) : this(name, 0) {// 부생성자(secondary constructor
        print("첫번째 부생성자")
    }
    constructor(): this("new 사람") {
        print("두번째 부생성자")
    }
}
```
- body를 가질 수 있으니, block을 통해 코드를 집어넣을 수 있음.
- 기본 생성자를 통해 name 파라미터를 받는 생성자 호출, 해당 생성자는 주 생성자를 호출할 수 있다..!!

### init과 부생성자 호출 순서
1. init 초기화 블럭
2. 부성생자

> 그러나..! 코틀린에서는 부생성자보다는 default parameter를 사용하는 것을 권장합니다..! (주생성자 이용 권장)
>
> 다른 타입이 해당 객체로 converting을 해야할 때는 부생성자를 사용하기보다 정적 팩토리 메소드를 추천한다..!!!!

## 3. 커스텀 getter, setter
- custom getter는 클래스에 프로퍼티가 있는 것 처럼 직접 getter를 정의할 수 있다.
- 2가지 문법이 존재함. 변수 초기화처럼 하거나 중괄호 + return한 다음에 Expresion 넣어줄 수도 있다.

```kotlin

fun main() {
    val javaPeron = JavaPerson("곽윤진")
    print(javaPeron.name)
}
class KotilnPerson constructor( // 주생성자(primary constructor)
    name: String,
    age: Int
) {
    val name: String = name
    val age: Int = age

    constructor(name: String) : this(name, 0) {// 부생성자(secondary constructor
        print("첫번째 부생성자")
    }
    constructor(): this("new 사람") {
        print("두번째 부생성자")
    }
      
    val isAdult: Boolean
      get() = this.age >= 2 

    val isAdult2: Boolean
        get() {
            return this.age >= 2
        }
}   
```

> 객체의 속성인 경우라면, custom getter 사용하고 그렇지 않으면 메소드로 표현하는 것이 좋다함.