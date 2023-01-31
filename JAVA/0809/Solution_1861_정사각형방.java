import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(in.readLine());
            int[][] map = new int[N][N];
            int M = N * N;
            int[] nums = new int[M + 1];
            int idx = 1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    nums[idx++] = M;
                }
            }
            int max = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int cnt = count(map, 1, r, c, N);
                    if (cnt >= max) {
                        max = cnt;
                        if (map[r][c] < nums[max]) {
                            nums[max] = map[r][c];
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(nums[max]).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    public static int count(int[][] map, int cnt, int r, int c, int N) {
        int m = map[r][c];
        if (r - 1 >= 0 && map[r - 1][c] - m == 1) {
            cnt = count(map, cnt + 1, r - 1, c, N);
        } else if (r + 1 < N && map[r + 1][c] - m == 1) {
            cnt = count(map, cnt + 1, r + 1, c, N);
        } else if (c - 1 >= 0 && map[r][c - 1] - m == 1) {
            cnt = count(map, cnt + 1, r, c - 1, N);
        } else if (c + 1 < N && map[r][c + 1] - m == 1) {
            cnt = count(map, cnt + 1, r, c + 1, N);
        }
        return cnt;
    }
}
