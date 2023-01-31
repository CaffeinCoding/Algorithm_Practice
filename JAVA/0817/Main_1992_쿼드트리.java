import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1992_쿼드트리 {
    static String[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        map = new String[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = in.readLine().split("");
        }

        String result = mappingZ(N, 0, 0);
        System.out.println(result);
    }

    public static String mappingZ(int N, int x, int y) {
        if (N == 1) {
            return map[x][y];
        }
        String c1 = mappingZ(N / 2, x, y);
        String c2 = mappingZ(N / 2, x, y + N / 2);
        String c3 = mappingZ(N / 2, x + N / 2, y);
        String c4 = mappingZ(N / 2, x + N / 2, y + N / 2);
        String tmp = "";
        if (c1.equals(c2) && c2.equals(c3) && c3.equals(c4) && c1.length() < 2) {
            tmp += c1;
        } else {
            tmp += "(" + c1 + c2 + c3 + c4 + ")";
        }
        return tmp;
    }
}
