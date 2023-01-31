import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1218_괄호짝짓기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Character> dc = new ArrayDeque<Character>();

		int T = 10;
		String front = "([{<";
		String last = ")]}>";

		for (int tc = 1; tc <= T; tc++) {
			int answer = 1;
			in.readLine();
//			int N = Integer.parseInt(in.readLine());
			char[] arr = in.readLine().toCharArray();

			for (char t : arr) {
				int idx = front.indexOf(t);
				if (front.indexOf(t) > -1) {
					dc.push(last.charAt(idx));
				} else {
					if (dc.size() <= 0 || dc.pop() != t) {
						answer = 0;
						break;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
