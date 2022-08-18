import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2839_설탕배달 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int cnt = N / 5;
        N = N - cnt * 5;
        while (N > 0 && cnt >= 0) {
            if (N % 3 == 0) {
                cnt = cnt + N / 3;
                N = 0;
            } else {
                cnt -= 1;
                N += 5;
            }
        }
        System.out.println(cnt);
    }
}
