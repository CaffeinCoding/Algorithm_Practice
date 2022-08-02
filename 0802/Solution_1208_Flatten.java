package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1208_Flatten {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = 10;
		int answer = 0;

		for (int tc = 1; tc <= T; tc++) {
			int dumps = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			List<Integer> boxs = new ArrayList<Integer>();
			while (st.hasMoreTokens()) {
				boxs.add(Integer.parseInt(st.nextToken()));
			}

			while (dumps-- > 0) {
				int max = Collections.max(boxs);
				int min = Collections.min(boxs);
				boxs.set(boxs.indexOf(max), max - 1);
				boxs.set(boxs.indexOf(min), min + 1);
				answer = Collections.max(boxs) - Collections.min(boxs);
				if(answer == 0 || answer == 1)
					break;
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
