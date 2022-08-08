import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st1;
        StringTokenizer st2;
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(in.readLine());
            List<String> pwd = new ArrayList<String>();
            st1 = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < N; i++) {
                pwd.add(st1.nextToken());
            }
            int com = Integer.parseInt(in.readLine());
            st1 = new StringTokenizer(in.readLine(), "I");
            for (int i = 0; i < com; i++) {
                st2 = new StringTokenizer(st1.nextToken(), " ");
                int idx = Integer.parseInt(st2.nextToken());
                int cnt = Integer.parseInt(st2.nextToken());
                List<String> tmp = new ArrayList<String>();
                for (int j = 0; j < cnt; j++) {
                    tmp.add(st2.nextToken());
                }
                pwd.addAll(idx, tmp);
            }

            sb.append("#").append(tc).append(" ");

            for (int i = 0; i < 10; i++) {
                sb.append(pwd.get(i)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}