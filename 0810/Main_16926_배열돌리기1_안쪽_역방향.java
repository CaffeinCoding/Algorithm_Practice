import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1_안쪽_역방향 {
    static int[] direct = { 1, -1 };

    public static void rotate(String[][] map, int N, int M, int row, int col, int low, boolean flag) {
        int rChk = row;
        int cChk = col;
        String outTmp = map[row][col];
        for (int d : direct) {
            if (flag) {
                for (int c = col; c + d < M && c + d >= low; c += d) {
                    map[rChk][c] = map[rChk][c + d];
                    cChk = c + d;
                }
                for (int r = row; r + d < N && r + d >= low; r += d) {
                    map[r][cChk] = map[r + d][cChk];
                    rChk = r + d;
                }
            } else {
                for (int r = row; r + d < N && r + d >= low; r += d) {
                    map[r][cChk] = map[r + d][cChk];
                    rChk = r + d;
                }
                for (int c = col; c + d < M && c + d >= low; c += d) {
                    map[rChk][c] = map[rChk][c + d];
                    cChk = c + d;
                }
            }
            row = rChk;
            col = cChk;
        }
        if (flag) {
            map[row + direct[0]][col] = outTmp;
        } else {
            map[row][col + direct[0]] = outTmp;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        String[][] map = new String[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int c = 0; c < M; c++) {
                map[r][c] = st.nextToken();
            }
        }
        int loop = Math.min(N, M) / 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < loop; j++) {
                rotate(map, N - j, M - j, j, j, j, j % 2 == 0);
            }
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
