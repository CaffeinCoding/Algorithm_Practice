from sys import stdin, stdout

input = stdin.readline
print = stdout.write

def binarySearch(arr, target):
    left = 0
    right = len(arr) - 1

    while (left <= right):
        mid = (left + right)//2
        if (arr[mid] == target):
            return mid + 1
        if (arr[mid] > target):
            right = mid - 1
        else:
            left = mid + 1
    return 1

N, H = map(int, input().split())
mlen = N // 2
min = N
cnt = 0
bottom = [0 for _ in range(mlen)]
up = [0 for _ in range(mlen)]

for i in range(mlen):
    b = int(input())
    u = int(input())
    bottom[i] = b
    up[i] = u

bottom.sort()
up.sort()

for i in range(1, H+1):
    res_cnt = (mlen - binarySearch(bottom, i)) + (mlen - binarySearch(up, (H + 1 - i)))
    if (res_cnt < min):
        min = res_cnt
        cnt = 1
    elif (res_cnt == min):
        cnt += 1

print(f'{min} {cnt}')
