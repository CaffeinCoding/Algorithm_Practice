import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산_유효성_검사 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(in.readLine());
            boolean flag = true;
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                st.nextToken();
                if (st.countTokens() > 2) {
                    if (st.nextToken().charAt(0) - '0' > 0) {
                        flag = false;
                        continue;
                    }
                } else {
                    if (st.nextToken().charAt(0) - '0' < 0) {
                        flag = false;
                        continue;
                    }
                }
            }
            if (flag) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
