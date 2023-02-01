import sys
from collections import deque
input = sys.stdin.readline
NTARGET = "use the stairs"

F,S,G,U,D = map(int, input().split())

visited = set([S])
cnt = 0
dq = deque([S])

if(S == G):
    print(0)
else:
    while True:
        N = deque()
        while(len(dq) > 0):
            T = dq.popleft()
            nUp = T + U
            nDown = T - D
            if(nUp == G or nDown == G):
                visited.add(G)
                N.clear()
                break
            
            if(nUp <= F and nUp not in visited):
                N.append(nUp)
                visited.add(nUp)
            if(nDown >= 1 and nDown not in visited):
                N.append(nDown)
                visited.add(nDown)
        cnt += 1
        if(len(N) > 0):
            dq = N
        else:
            if(G not in visited):
                print(NTARGET)
            else:
                print(cnt)
            break