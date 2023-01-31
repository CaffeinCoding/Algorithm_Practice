import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }
                return Math.abs(o1) - Math.abs(o2);
            }

        });
        int N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(in.readLine());
            if (tmp == 0) {
                int t = 0;
                if (!q.isEmpty()) {
                    t = q.poll();
                }
                sb.append(t).append("\n");
            } else {
                q.add(tmp);
            }
        }

        System.out.println(sb);
    }
}
