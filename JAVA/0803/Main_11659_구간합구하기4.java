import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659_구간합구하기4 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st1 = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int[] sumN = new int[N];
		int mSum = 0;
		int sum = 0;
		String[] temp = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			mSum += Integer.parseInt(temp[i]);
			sumN[i] = mSum;
		}

		for (int tc = 0; tc < M; tc++) {
			StringTokenizer rng = new StringTokenizer(in.readLine());
			int f = Integer.parseInt(rng.nextToken()) - 1;
			int l = Integer.parseInt(rng.nextToken())- 1;
			if (f == 0) {
				sum = sumN[l];
			} else {
				sum = sumN[l] - sumN[f - 1];
			}

			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}