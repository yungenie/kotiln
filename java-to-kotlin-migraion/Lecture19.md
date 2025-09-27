# 코틀린의 이모저모
1. Type Alias와 as import
2. 구조분해와 componentN 함수
3. Jump와 Label
4. TakeIf와 TakeUnless

## 1. Type Alias와 as import
### Type Alias
- Alias 엘리어스
- 얼라이언스(별칭)

#### as import
- 동일한 이름의 함수를 같은 클래스에서 둘 다 사용하고 싶을때 as라는 별칭을 붙여서 import할 수 있다.


## 3. Jump와 Label
- 파라미터를 명시하는 것을 추천한다.

### forEach 구문
- break, continue가 불가능하다.
- break문을 만약 사용하고 싶으면, run 구문안에 return@run을 사용해야한다.
- continue문을 사용하고 싶으면, return@forEach를 사용해야한다.

> forEach 구문 보다는 그냥 일반 for문을 사용하는게 낫다.


### Label
- 특정 라벨에 대해 동작할 수 있게끔 하는 기능..!

## 4. TakeIf와 TakeUnless
### TakeIf
- 주어진 조건을 만족하면 그 값을 반환, 아니면 null 반환
### TakeUnless
- 주어진 조건을 만족하지 않으면 그 값을 반환, 아니면 null 반환