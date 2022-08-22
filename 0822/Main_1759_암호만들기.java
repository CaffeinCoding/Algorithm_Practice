import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
    static StringBuilder sb = new StringBuilder();
    static char[] arr;
    static int C;
    static int L;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine(), " ");
        arr = new char[C];
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        comb(new char[L], 0, 0);
        System.out.println(sb);
    }

    public static void comb(char[] pick, int cnt, int idx) {
        if (cnt == L) {
            int vCnt = 0;
            for (char c : pick) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vCnt += 1;
                }
            }
            if (vCnt >= 1 && vCnt <= L - 2) {
                sb.append(new String(pick)).append("\n");
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            pick[cnt] = arr[i];
            comb(pick, cnt + 1, i + 1);
        }
    }
}
