import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1249_보급로_bfs {
    static int[][] map;
    static int[][] result;
    static Deque<int[]> dq;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, -1, 0, 1 };
    static int N;

    public static void bfs() {
        while (!dq.isEmpty()) {
            int[] temp = dq.poll();
            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];
                if (nr <= N && nc <= N && result[nr][nc] > map[nr][nc] + temp[2]) {
                    result[nr][nc] = map[nr][nc] + temp[2];
                    dq.add(new int[] { nr, nc, result[nr][nc] });
                }
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
            dq = new ArrayDeque<>();

            for (int r = 1; r <= N; r++) {
                String[] input = in.readLine().split("");
                for (int c = 1; c <= N; c++) {
                    map[r][c] = Integer.parseInt(input[c - 1]);
                    result[r][c] = Integer.MAX_VALUE;
                }
            }
            dq.add(new int[] { 1, 1, 0 });
            bfs();
            sb.append("#").append(tc).append(" ").append(result[N][N]).append("\n");
        }
        System.out.println(sb.toString());
    }
}