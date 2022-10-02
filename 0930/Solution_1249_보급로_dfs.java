import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1249_보급로_dfs {
    static int[][] map;
    static int[][] result;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, -1, 0, 1 };
    static int N;

    public static void dfs(int r, int c, int sum) {
        if (r == N && c == N) {
            result[r][c] = Math.min(result[r][c], sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr <= N && nc <= N && result[nr][nc] > map[nr][nc] + sum) {
                result[nr][nc] = map[nr][nc] + sum;
                dfs(nr, nc, result[nr][nc]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            map = new int[N + 1][N + 1];
            result = new int[N + 1][N + 1];

            for (int r = 1; r <= N; r++) {
                String[] input = in.readLine().split("");
                for (int c = 1; c <= N; c++) {
                    map[r][c] = Integer.parseInt(input[c - 1]);
                    result[r][c] = Integer.MAX_VALUE;
                }
            }
            dfs(1, 1, 0);
            sb.append("#").append(tc).append(" ").append(result[N][N]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
