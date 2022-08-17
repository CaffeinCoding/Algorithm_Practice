import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> qA = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }

        });
        PriorityQueue<int[]> qB = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }

        });
        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(in.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int BC = Integer.parseInt(st.nextToken());

            int[] A = new int[M + 1];
            int[] B = new int[M + 1];
            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 1; i <= M; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 1; i <= M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            int[][][] map = new int[BC][2][M + 1];

            for (int i = 0; i < BC; i++) {
                int[] Ad = new int[] { 1, 1 };
                int[] Bd = new int[] { 10, 10 };
                st = new StringTokenizer(in.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                for (int j = 0; j <= M; j++) {
                    coord(A[j], Ad);
                    coord(B[j], Bd);
                    map[i][0][j] = distance(X, Ad[1], Y, Ad[0]) <= C ? P : 0;
                    map[i][1][j] = distance(X, Bd[1], Y, Bd[0]) <= C ? P : 0;
                }
            }

            int result = 0;
            for (int i = 0; i <= M; i++) {
                int maxA = 0;
                int maxB = 0;
                int bcA = 0;
                int bcB = 0;
                qA.clear();
                qB.clear();
                for (int j = 0; j < BC; j++) {
                    int tmpA = map[j][0][i];
                    int tmpB = map[j][1][i];
                    if (tmpA != 0) {
                        qA.add(new int[] { tmpA, j });
                    }
                    if (tmpB != 0) {
                        qB.add(new int[] { tmpB, j });
                    }
                    if (tmpA > maxA) {
                        maxA = tmpA;
                        bcA = j;
                    }
                    if (tmpB > maxB) {
                        maxB = tmpB;
                        bcB = j;
                    }
                }
                while (maxA == maxB && maxA != 0) {
                    if (qA.size() == 0 && qB.size() == 0) {
                        if (bcA == bcB) {
                            maxA /= 2;
                            maxB /= 2;
                        }
                        break;
                    }else if(bcA != bcB){
                        break;
                    }
                    if (qA.size() == 0) {
                        if (qB.peek()[0] > maxB / 2) {
                            maxB = qB.peek()[0];
                            bcB = qB.poll()[1];
                        } else {
                            qB.poll();
                        }
                    } else if (qB.size() == 0) {
                        if (qA.peek()[0] > maxA / 2) {
                            maxA = qA.peek()[0];
                            bcA = qA.poll()[1];
                        } else {
                            qA.poll();
                        }
                    } else if (qA.peek()[0] > qB.peek()[0]) {
                        if (qA.peek()[0] > maxA / 2) {
                            maxA = qA.peek()[0];
                            bcA = qA.poll()[1];
                        } else {
                            qA.poll();
                        }
                    } else {
                        if (qB.peek()[0] > maxB / 2) {
                            maxB = qB.peek()[0];
                            bcB = qB.poll()[1];
                        } else {
                            qB.poll();
                        }
                    }
                }
                result += maxA + maxB;
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void coord(int D, int[] d) {
        switch (D) {
            case 1:
                if (d[0] - 1 >= 1) {
                    d[0] -= 1;
                }
                break;
            case 2:
                if (d[1] + 1 <= 10) {
                    d[1] += 1;
                }
                break;
            case 3:
                if (d[0] + 1 <= 10) {
                    d[0] += 1;
                }
                break;
            case 4:
                if (d[1] - 1 >= 1) {
                    d[1] -= 1;
                }
                break;
        }
    }

    public static int distance(int ax, int bx, int ay, int by) {
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }
}