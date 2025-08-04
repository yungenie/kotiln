# 코틀린에서 클래스를 다루는 방법
1. 클래스와 프로퍼티
2. 생성자와 init
3. 커스텀 getter, setter
4. backing field


## 클래스와 프로퍼티
- 프로퍼티란 [필드 + getter + setter]를 의미한다.


```java
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
package com.yunjin.lec9

class KotilnPerson constructor(
    name: String,
    age: Int
) {
    val name: String = name
    val age: Int = age
}
```
- 코틀린에서는 필드만 만들면 getter, setter 자동으로 만들어준다.
- todo 생성자까지는 만들어줘야하는 것 같음.. 


<table>
  <thead>
    <tr>
      <th>Java 코드</th>
      <th>Kotlin 코드</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>
        <code>

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
        
</code>
</td>
<td>
<code>

    package com.yunjin.lec9
    
    class KotilnPerson constructor(
        name: String,
        age: Int
    ) {
        val name: String = name
        val age: Int = age
    }
</code>
</td>
</tr>
</tbody>
</table>
