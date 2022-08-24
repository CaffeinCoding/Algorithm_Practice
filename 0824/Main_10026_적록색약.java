import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_10026_적록색약 {
    static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static int N, cnt, gcnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        char[][] map = new char[N][N];
        char[][] gmap = new char[N][N];

        boolean[][] check = new boolean[N][N];
        boolean[][] gcheck = new boolean[N][N];
        cnt = 0;
        gcnt = 0;
        for (int i = 0; i < N; i++) {
            char[] arr = in.readLine().toCharArray();
            check[i] = new boolean[N];
            gcheck[i] = new boolean[N];
            for (int j = 0; j < N; j++) {
                map[i][j] = arr[j];
                if (arr[j] == 'G') {
                    gmap[i][j] = 'R';
                } else {
                    gmap[i][j] = arr[j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    ArrayDeque<int[]> dq = new ArrayDeque<int[]>();
                    dq.add(new int[] { i, j });
                    check[i][j] = true;
                    bfs(dq, map, check, map[i][j]);
                    cnt += 1;
                }
                if (!gcheck[i][j]) {
                    ArrayDeque<int[]> dq = new ArrayDeque<int[]>();
                    dq.add(new int[] { i, j });
                    gcheck[i][j] = true;
                    bfs(dq, gmap, gcheck, gmap[i][j]);
                    gcnt += 1;
                }
            }
        }

        System.out.println(cnt + " " + gcnt);
    }

    public static void bfs(ArrayDeque<int[]> q, char[][] map, boolean[][] check, char c) {
        ArrayDeque<int[]> dq = new ArrayDeque<int[]>();

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int tr = tmp[0] + dr[i];
                int tc = tmp[1] + dc[i];

                if (tr < 0 || tr >= N || tc < 0 || tc >= N) {
                    continue;
                }

                if (map[tr][tc] == c && !check[tr][tc]) {
                    check[tr][tc] = true;
                    dq.add(new int[] { tr, tc });
                }
            }
        }

        if (dq.isEmpty()) {
            return;
        }
        bfs(dq, map, check, c);
    }
}
