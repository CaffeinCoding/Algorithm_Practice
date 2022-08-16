import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
    static int[] direct = { 1, -1 };
    static Deque<int[]> mapK = new ArrayDeque<int[]>();

    // 회전 연산 처리
    public static void rotate(int[][] map, int N, int M, int row, int col) {
        int rChk = row;
        int cChk = col;
        int rlow = row;
        int clow = col;
        int outTmp = map[row][col];
        for (int d : direct) {

            for (int r = row; r + d < N && r + d >= rlow; r += d) {
                map[r][cChk] = map[r + d][cChk];
                rChk = r + d;
            }
            for (int c = col; c + d < M && c + d >= clow; c += d) {
                map[rChk][c] = map[rChk][c + d];
                cChk = c + d;
            }
            row = rChk;
            col = cChk;
        }
        map[row][col + direct[0]] = outTmp;
    }

    // 회전 연산 조합 찾기
    public static void permute(int next, int[] pick, boolean[] select, int[] idx, int K) {
        if (next == 0) {
            mapK.add(pick.clone());
            return;
        }
        for (int i = 0; i < K; i++) {
            if (!select[i]) {
                select[i] = true;
                pick[pick.length - next] = idx[i];
                permute(next - 1, pick, select, idx, K);
                select[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] Ks = new int[K][3];
        int[] idx = new int[K];
        for (int i = 0; i < K; i++) {
            int[] tmp = new int[3];
            st = new StringTokenizer(in.readLine());
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());
            tmp[2] = Integer.parseInt(st.nextToken());
            Ks[i] = tmp;
            idx[i] = i;
        }

        permute(K, new int[K], new boolean[K], idx, K);

        int min = Integer.MAX_VALUE;
        while (!mapK.isEmpty()) {
            int[] T = mapK.poll();
            // 연산 처리 배열 생성
            int[][] tMap = new int[N][M];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    tMap[r][c] = map[r][c];
                }
            }
            for (int t : T) {
                for (int j = Ks[t][2]; j > 0; j--) {
                    rotate(tMap, Ks[t][0] + j, Ks[t][1] + j, Ks[t][0] - j - 1, Ks[t][1] - j - 1);
                }
            }
            for (int r = 0; r < N; r++) {
                int sum = 0;
                for (int c = 0; c < M; c++) {
                    sum += tMap[r][c];
                }
                if (min > sum) {
                    min = sum;
                }
            }
        }
        System.out.println(min);
    }
}
