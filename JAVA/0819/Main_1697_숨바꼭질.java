import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
    static boolean flag = false;
    static int cnt;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (M != N) {
            if (M < N) {
                cnt = N - M;
            } else {
                ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
                dq.add(N);
                count(dq, new boolean[M * 2]);
            }
        }
        System.out.println(cnt);
    }

    public static void count(ArrayDeque<Integer> dq, boolean[] visited) {
        ArrayDeque<Integer> tdq = new ArrayDeque<Integer>();
        cnt += 1;
        while (!dq.isEmpty()) {
            int tmp = dq.poll();
            check(tdq, tmp * 2, visited);
            check(tdq, tmp + 1, visited);
            check(tdq, tmp - 1, visited);
            if (flag) {
                return;
            }
        }
        if (!tdq.isEmpty()) {
            count(tdq, visited);
        }
    }

    public static void check(ArrayDeque<Integer> dq, int num, boolean[] visited) {
        if (num == M) {
            flag = true;
            return;
        }
        if (num >= 0 && num < M * 2 && !visited[num]) {
            dq.add(num);
            visited[num] = true;
        }
    }
}
