package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2805_농작물수확하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int answer = 0;
			for (int r = -(N/2); r <= N/2; r++) {
				String[] st = in.readLine().split("");
				int setR = Math.abs(r);
				for (int c = setR; c < N-setR; c++) {
					answer += Integer.parseInt(st[c]);
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
