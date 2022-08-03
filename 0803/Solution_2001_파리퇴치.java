import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int answer = 0;

			int[][] map = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + Integer.parseInt(st.nextToken());
				}
			}

			for (int r = M; r <= N; r++) {
				for (int c = M; c <= N; c++) {
					int temp = map[r][c] - map[r - M][c] - map[r][c - M] + map[r - M][c - M];
					if (temp > answer) {
						answer = temp;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}