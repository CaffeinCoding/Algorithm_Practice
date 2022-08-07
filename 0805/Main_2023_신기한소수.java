import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2023_신기한소수 {
    static String[] nums = { "1", "2", "3", "5", "7", "9" };
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] start = { "2", "3", "5", "7" };
        int N = Integer.parseInt(in.readLine());

        for (int i = 0; i < start.length; i++) {
            String tmp = start[i];
            getPrime(N - 1, tmp);
        }
        System.out.println(sb);
    }

    static void getPrime(int cnt, String tmp) {
        if (cnt == 0) {
            sb.append(tmp).append("\n");
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            String t = tmp + nums[i];
            int num = Integer.parseInt(t);
            if (prime(num)) {
                getPrime(cnt - 1, t);
            }
        }
    }

    static boolean prime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}