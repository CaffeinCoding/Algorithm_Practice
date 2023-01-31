import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17829_풀링 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (N > 2) {
			int[][] remap = new int[N/2][N/2];
			int mr = 0;
			for (int r = 0; r < N; r += 2) {
				int mc = 0;
				for (int c = 0; c < N; c += 2) {
					List<Integer> max = new ArrayList<Integer>();
					for (int ir = r; ir < r + 2; ir++) {
						for (int ic = c; ic < c + 2; ic++) {
							max.add(map[ir][ic]);
						}
					}
					max.sort(Comparator.reverseOrder());
					remap[mr][mc++] = max.get(1);
				}
				mr++;
			}
			map = remap;
			N /= 2;
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				result.add(map[i][j]);
			}
		}
		result.sort(Comparator.reverseOrder());
		System.out.println(result.get(1));
	}
}
