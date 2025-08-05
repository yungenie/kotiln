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
  
class KotilnPerson constructor( // 생성자 (주생성자 primary constructor)
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
- 주생성자는 반드시 존재해야 한다. 단, 파라미터가 하나도 없다면 기본 생성자 만들어져서 생략 가능..!

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