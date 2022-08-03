import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_Ladder1 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = 100;

		for (int tc = 1; tc <= 10; tc++) {
			int[][] map = new int[N][N];
			int start = 0;
			in.readLine();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2)
						start = j;
				}
			}
			int r = 99;
			int flag = 0;
			while (r > 0) {
				if (start > 0 && map[r][start - 1] == 1 && (flag == 0 || flag == 1)) {
					start--;
					flag = 1;
				} else if (start < N - 1 && map[r][start + 1] == 1 && (flag == 0 || flag == 2)) {
					start++;
					flag = 2;
				} else {
					r--;
					flag = 0;
				}
			}

			sb.append("#").append(tc).append(" ").append(start).append("\n");
		}
		System.out.println(sb);
	}
}
