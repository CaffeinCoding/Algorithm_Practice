import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int N = 4;
        char[] e = { 'A', 'C', 'G', 'T' };
        int[] cntList = new int[N];
        int[] cnt = new int[N];

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] list = in.readLine().toCharArray();

        st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cntList[i] = Integer.parseInt(st.nextToken());
        }

    }
}