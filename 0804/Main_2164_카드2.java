import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_2164_카드2 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		Queue<Integer> arr = new ArrayDeque<Integer>();
		
		for (int i = 1; i <= N; i++) {
			arr.add(i);
		}
		
		while(arr.size() > 1) {
			arr.poll();
			int num = arr.poll();
			arr.add(num);
		}
		System.out.println(arr.poll());
	}
}
