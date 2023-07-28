
# 맵 크기 N * N
# 1초마다 N * N으로 나눠지고, 가운데 K칸이 검게 칠해짐.
# s초만큼 진행됨.

# (R1, C1) ~ (R2, C2) 까지 프린트
# R, C는 0이 시작
s, N, K, R1, R2, C1, C2 = map(int, input().split())


# 전체 분할 수 N^s

'''
- 한번 나눴을 때,
    - N 칸으로 분할
    - 검은 영역 (N-K)/2 ~ (N+K)/2 - 1

- 두번 나눴을 때,
    - N*N 칸으로 분할
    - R, C를 N으로 나눈 나머지를 인덱스로 사용

    - 전체 검은 영역
        - (N) ~ (N*N - N - 1)


- s번 나눴을 때,
    - N^s 칸으로 분할
    - R, C를 N^(s-1)으로 나눈 나머지를 인덱스로 사용.

'''