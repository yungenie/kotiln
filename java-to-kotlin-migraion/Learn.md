# 이슈

## Java 코드와 Kotlin 코드가 섞여 있는 프로젝트에서 kotlin 파일에서 Java 파일의 클래스를 필드 참조할 때 발생하는 문제
```

Kotlin: Cannot access '@Schema(...) field xxxx!': it is private in 'com/X/X/adapter/X/model/vo/X/X'.
```
- 비즈니스 로직에서 검증을 하는 부분에 특정 필드값이 해당하는 상태값에 맞는지 확인 로직인데, 필드 참조가 안됨...
- 이것 저것 실험해보다가 해당 필드 get해오는 custom getter 만들어서 해결함... 


출처: https://ljg960730.tistory.com/193 [MINIMALISM_JK:티스토리]
