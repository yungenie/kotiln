# 코틀린에서 Type을 다루는 방법
1. 기본타입
2. 타입캐스팅
3. kotlin의 3가지 특이한 타입
4. String interpolation, String indexing

## 1. 기본타입
- 코틀린의 변수는 초기값을 보고 타입을 추론하며, 기본 타입들 가의 변환은 명시적으로 이루워진다.
- to변환타입()을 사용해야 합니다.

## 2. 타입캐스팅
- 코틀린에서는 is, !is, as, as?를 이용해 타입을 확인하고 캐스팅한다.

## 3. kotlin의 3가지 특이한 타입
- Any, Unit, Nothing
- **코틀린의 Any는 Java의 Object와 같은 최상위 타입**이다.
- Unit은 Java의 void와 동일한다. 
- Nothing은 정상적으로 끝나지 않는 함수의 반환을 의미한다!

## 4. String interpolation, String indexing
- 문자열을 가공할때 ${변수}와 """ """를 사용하면 깔끔한 코딩이 가능하다.
- 문자열에서 문자를 가져올때 Java의 배열처럼 []를 사용한다.