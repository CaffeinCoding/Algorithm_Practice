import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(in.readLine(), " ");
        int[] var = new int[R];
        for (int i = 0; i < R; i++) {
            var[i] = Integer.parseInt(st.nextToken());
        }

        for (int v : var) {
            int[][] result = new int[N][M];
            switch (v) {
                case 1:
                    int one = N - 1;
                    for (int r = 0; r < N; r++) {
                        for (int c = 0; c < M; c++) {
                            result[r][c] = map[one][c];
                        }
                        one -= 1;
                    }
                    break;
                case 2:
                    for (int r = 0; r < N; r++) {
                        int two = M - 1;
                        for (int c = 0; c < M; c++) {
                            result[r][c] = map[r][two];
                            two -= 1;
                        }
                    }
                    break;
                case 3:
                    result = new int[M][N];
                    for (int r = 0; r < N; r++) {
                        for (int c = 0; c < M; c++) {
                            result[c][N - r - 1] = map[r][c];
                        }
                    }
                    int tmp3 = M;
                    M = N;
                    N = tmp3;
                    break;
                case 4:
                    result = new int[M][N];
                    for (int r = 0; r < N; r++) {
                        for (int c = 0; c < M; c++) {
                            result[M - c - 1][r] = map[r][c];
                        }
                    }
                    int tmp4 = M;
                    M = N;
                    N = tmp4;
                    break;
                case 5:
                    int rN = N / 2;
                    for (int r = 0; r < N / 2; r++) {
                        int cM = M / 2;
                        for (int c = 0; c < M / 2; c++) {
                            result[r][c] = map[rN][c];
                            result[r][cM] = map[r][c];
                            result[rN][cM] = map[r][cM];
                            result[rN][c] = map[rN][cM];
                            cM += 1;
                        }
                        rN += 1;
                    }
                    break;
                case 6:
                    int srN = N / 2;
                    for (int r = 0; r < N / 2; r++) {
                        int cM = M / 2;
                        for (int c = 0; c < M / 2; c++) {
                            result[srN][cM] = map[srN][c];
                            result[srN][c] = map[r][c];
                            result[r][c] = map[r][cM];
                            result[r][cM] = map[srN][cM];
                            cM += 1;
                        }
                        srN += 1;
                    }
                    break;
                default:
                    System.out.println("check");
            }
            map = result;
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
