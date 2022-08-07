import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2493_탑 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<int[]> map = new ArrayDeque<int[]>();
        int N = Integer.parseInt(in.readLine());
        int[] list = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (map.size() > 0) {
                if (map.peek()[1] > list[i]) {
                    sb.append(map.peek()[0] + 1).append(" ");
                    break;
                } else {
                    map.pop();
                }
            }
            if (map.size() == 0)
                sb.append(0).append(" ");
            map.push(new int[] { i, list[i] });
        }
        System.out.println(sb);
    }
}
