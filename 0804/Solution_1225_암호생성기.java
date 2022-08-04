import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int M = 8;
		
		for (int tc = 0; tc < 10; tc++) {
			int n = Integer.parseInt(in.readLine());
			Deque<Integer> nums = new ArrayDeque<Integer>();
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < M; i++) {
				nums.add(Integer.parseInt(st.nextToken()));
			}
			int cnt = 1;
			while(nums.peekLast() != 0) {
				int num = nums.pop() - cnt;
				if(num < 0) num = 0;
				nums.add(num);
				cnt += 1;
				if(cnt > 5) cnt = 1;
			}
			sb.append("#").append(n).append(" ");
			for (int i = 0; i < M; i++) {
				sb.append(nums.pop()).append(" ");
			}
			sb.append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
