import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        int R = 100;
        int L = 10;
        int sum = 0;
        int[][] map = new int[R + 1][R + 1];
        for (int i = 0; i < R + 1; i++) {
            for (int j = 0; j < R + 1; j++) {
                map[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            for (int r = row; r < row + L; r++) {
                for (int c = col; c < col + L; c++) {
                    if (map[r][c] == 0) {
                        map[r][c] = 1;
                        sum += 1;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
