import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3025_돌던지기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}

		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(in.readLine()) - 1;
			rolling(map, n, R, C);
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void rolling(char[][] map, int n, int R, int C) {
		for (int r = 0; r < R - 1; r++) {
			if (map[r + 1][n] == 'X') {
				map[r][n] = 'O';
				break;
			} else if (map[r + 1][n] == 'O') {
				if (n - 1 >= 0 && map[r + 1][n - 1] == '.' && map[r][n - 1] == '.') {
					n = n - 1;
					r = r - 1;
				} else if (n + 1 < C && map[r + 1][n + 1] == '.' && map[r][n + 1] == '.') {
					n = n + 1;
					r = r - 1;
				} else {
					map[r][n] = 'O';
					break;
				}
			} else if (r + 1 == R - 1) {
				map[r + 1][n] = 'O';
				break;
			}
		}
	}

}
