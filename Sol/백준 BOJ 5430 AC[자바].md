# 백준 BOJ 5430 AC[자바]

## 문제 분석

- 할일이 없어서 언어를 만드는 사람이 있다니 세상 말세다 진짜

- AC는 정수 배열에 연산을 하기 위해 만듬.

- 연산

  - R : 뒤집기
    그냥 수의 순서를 다 뒤집음

  - D : 버리기

    현재 배열의 맨 앞 수를 버림.

- 주어진 명령을 숫자 배열에서 실행할 때, 남은 배열을 출력할 것.





### 입력조건

```
int_T(테스트 케이스 수)
각 테스트 케이스 별로{
	String_주어지는 명령
	int_숫자 배열 크기
	int[]_숫자 배열 ("[%d,%d,%d]" 형태)
}
```





## 풀이과정

- 입력조건이 굉장히 모호하게 되어 있음.
  - 좌우에 괄호를 쳐내고, 콤마 단위로 찢어서 그대로 숫자 배열에 넣어버리기.

- 삽입조건이 없고, 삭제만 가능한 것이 이 문제의 포인트
  1. 처음에, 맨 앞과 맨 뒤를 가르키는 포인터를 선언함.
  2. 어느 포인터를 수정할지 가르키는 변수를 하나 선언.
  3. R이 들어오면 포인터를 가르키는 변수를 바꾸고
  4. D가 들어오면,
     - 앞을 가르키면 앞 포인터를 하나 올리고,
     - 뒤를 가르키면 뒤 포인터를 하나 내림.
- 실제로 배열을 건드리는 것이 아니라,
- 명령을 하나씩 처리하면서 출력 위치만 찾아내는 것.



- 다양한 조건 처리에 애를 먹었다...



## 코드 구성

- 문자열을 입력받아 숫자 배열로 바꾸는 부분

  ```java
  String str = br.readLine();
  // 앞뒤의 괄호를 자름.
  str = str.substring(1, str.length()-1);
  int[] map;
  try {
      map = Stream.of(str.split(",")).mapToInt(Integer::parseInt).toArray();
  } catch(Exception e) {
      // [] 가 입력으로 들어오면, 임의로 처리해줌.
      map = new int[0];
  }
  ```

