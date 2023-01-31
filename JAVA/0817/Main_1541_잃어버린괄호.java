import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1541_잃어버린괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), "+-", true);
        Deque<String> dq = new ArrayDeque<String>();
        while (st.hasMoreTokens()) {
            dq.push(st.nextToken());
        }

        int tmp = 0;
        int result = 0;
        while (dq.size() > 0) {
            String t = dq.pop();
            if (t.equals("+")) {
                result = Integer.parseInt(dq.pop()) + result;
            } else if (t.equals("-")) {
                tmp -= result;
                result = 0;
            } else {
                result += Integer.parseInt(t);
            }
        }
        result += tmp;

        System.out.println(result);
    }
}
