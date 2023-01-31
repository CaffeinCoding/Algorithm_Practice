import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
    static int min;
    static List<Integer> com;

    public static void combina(int cnt, int[] left, int[] right, int idx, int N) {
        if (cnt == 0) {
            System.out.println(Arrays.toString(left) + " : " + Arrays.toString(right));
            return;
        }
        for (int i = idx; i < N; i++) {
            if (cnt <= N / 2) {
                right[right.length - cnt] = i;
            } else {
                left[left.length - (cnt - N / 2)] = i;
            }
            combina(cnt - 1, left, right, idx + 1, N);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(in.readLine());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            com = new ArrayList<Integer>();
            for (int i = 0; i < N; i++) {
                com.add(i);
            }

            combina(N, new int[N / 2], new int[N / 2], 0, N);
        }
    }
}
