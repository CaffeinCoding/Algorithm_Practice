import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int C = 3;
        int N = Integer.parseInt(in.readLine());
        int[][] list = new int[N + 1][C];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < C; j++) {
                list[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] costs = new int[N + 1][C];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < C; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < C; k++) {
                    if (j != k && list[i][k] > list[i - 1][j] + costs[i][k]) {
                        list[i][k] = list[i - 1][j] + costs[i][k];
                    }
                }
            }
        }
        Arrays.sort(list[N]);
        System.out.println(list[N][0]);
    }
}
