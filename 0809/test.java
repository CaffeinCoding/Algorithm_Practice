import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 1; tc++) {
            int N = Integer.parseInt(in.readLine());
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                sb.append("#").append(tc).append(" ");
                st = new StringTokenizer(in.readLine(), " ");
                if (st.countTokens() > 2) {
                    st.nextToken();
                    if (st.nextToken().charAt(0) - '0' > 0) {
                        flag = false;
                        continue;
                    }
                } else {
                    st.nextToken();
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
    }
}
