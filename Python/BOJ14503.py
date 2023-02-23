# N, M : 직사각형
# r, c, d : 시작 위치 및 바라보는 방향
# 0: 북쪽 / 1: 동쪽 / 2: 남쪽 / 3: 서쪽
# 회전 : 반시계

import sys

input = sys.stdin.readline

rotate = {
    0: 3,
    1: 0,
    2: 1,
    3: 2,
}
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

N, M = map(int, input().split())
r, c, d = map(int, input().split())
count = 0
room = []

for _ in range(N):
    room.append(list(map(int, input().split())))

while True:
    flag = True
    if (room[r][c] == 0):
        count += 1
        room[r][c] = 2

    for i in range(4):
        d = rotate[d]
        nr = r + dr[d]
        nc = c + dc[d]
        if (nr < N and nr >= 0 and nc < M and nc >= 0):
            if (room[nr][nc] == 0):
                r = nr
                c = nc
                flag = False
                break

    if (flag):
        nr = r - dr[d]
        nc = c - dc[d]
        if (nr < N and nr >= 0 and nc < M and nc >= 0):
            if (room[nr][nc] == 1):
                break
            else:
                r = nr
                c = nc

print(count)
