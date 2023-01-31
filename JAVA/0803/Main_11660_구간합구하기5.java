import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660_구간합구하기5 {
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] sumList = new int[N][N];
		for (int r = 0; r < N; r++) {
			int temp = 0;
			st = new StringTokenizer(in.readLine(), " ");
			for (int c = 0; c < N; c++) {
				temp += Integer.parseInt(st.nextToken());
				sumList[r][c] = temp;
			}
		}
		for (int tc = 0; tc < M; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken()) - 1;

			int sum = 0;
			for (int r = x1; r < x2; r++) {
				if (y1 == 0) {
					sum += sumList[r][y2];
				} else {
					sum += sumList[r][y2] - sumList[r][y1-1];
				}
			}

			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
