import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> list = new ArrayDeque<Integer>();

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        sb.append("<");
        int cnt = K;
        while (list.size() > 1) {
            if (cnt <= 1) {
                sb.append(list.pop()).append(", ");
                cnt = K;
            } else {
                list.add(list.pop());
                cnt -= 1;
            }
        }
        sb.append(list.pop()).append(">");
        System.out.println(sb);
    }
}
