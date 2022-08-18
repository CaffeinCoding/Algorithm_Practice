import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_1987_알파벳_ArrayDeque {
    static ArrayDeque<Character> dqC = new ArrayDeque<Character>();
    static char[][] map;
    static int maxCnt;
    static int R;
    static int C;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = in.readLine().toCharArray();
        }
        maxCnt = 1;

        search(0, 0, 0, 1);

        System.out.println(maxCnt);
    }

    public static void search(int r, int c, int flag, int cnt) {
        if (dqC.contains(map[r][c])) {
            if (cnt - 1 > maxCnt) {
                maxCnt = cnt - 1;
            }
            return;
        } else {
            dqC.push(map[r][c]);
        }
        if (r - 1 >= 0 && flag != 3) {
            search(r - 1, c, 1, cnt + 1);
        }
        if (r + 1 < R && flag != 1) {
            search(r + 1, c, 3, cnt + 1);
        }
        if (c - 1 >= 0 && flag != 2) {
            search(r, c - 1, 4, cnt + 1);
        }
        if (c + 1 < C && flag != 4) {
            search(r, c + 1, 2, cnt + 1);
        }
        dqC.pop();
    }
}
