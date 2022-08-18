import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
    static int cnt;
    static int r;
    static int c;
    static boolean flag = true;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        mappingZ(N, 0, 0);
    }

    public static void mappingZ(int N, int x, int y) {
        if (N == 1) {
            if (x == r && y == c) {
                System.out.println(cnt);
                flag = false;
            }
            cnt++;
            return;
        }
        mappingZ(N / 2, x, y);
        mappingZ(N / 2, x, y + N / 2);
        mappingZ(N / 2, x + N / 2, y);
        mappingZ(N / 2, x + N / 2, y + N / 2);
    }
}
