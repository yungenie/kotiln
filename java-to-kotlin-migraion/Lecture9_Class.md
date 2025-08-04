# 코틀린에서 클래스를 다루는 방법
1. 클래스와 프로퍼티
2. 생성자와 init
3. 커스텀 getter, setter
4. backing field


## 클래스와 프로퍼티


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
- .필드를 통해 getter와 setter를 바로 호출한다.