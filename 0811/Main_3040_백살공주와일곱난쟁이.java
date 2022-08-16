import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3040_백살공주와일곱난쟁이 {
    static int[] answer;
    static int[] list;

    public static void combina(int cnt, int[] pick, int idx, int sum) {
        if (cnt == 0) {
            if (sum == 100) {
                answer = pick.clone();
            }
            return;
        }
        for (int i = idx; i < list.length; i++) {
            sum += list[i];
            pick[pick.length - cnt] = list[i];
            combina(cnt - 1, pick, i + 1, sum);
            sum -= list[i];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = 9;
        int cnt = 7;
        list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(in.readLine());
        }

        combina(cnt, new int[cnt], 0, 0);

        for (int a : answer) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }
}
