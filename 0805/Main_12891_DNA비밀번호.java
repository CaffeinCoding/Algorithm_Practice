import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        Deque<Character> map = new ArrayDeque<Character>();
        HashMap<Character, Integer> dna = new HashMap<Character, Integer>() {
            {
                put('A', 0);
                put('C', 1);
                put('G', 2);
                put('T', 3);
            }
        };
        int N = 4;
        int[] checkList = new int[N];
        int[] cnt = new int[N];
        boolean flag = true;
        int answer = 0;

        st.nextToken();
        int P = Integer.parseInt(st.nextToken());
        char[] list = in.readLine().toCharArray();
        st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < N; i++) {
            checkList[i] = Integer.parseInt(st.nextToken());
        }

        for (char c : list) {
            map.add(c);
            cnt[dna.get(c)] += 1;
            if (map.size() == P) {
                for (int k = 0; k < N; k++) {
                    if (cnt[k] < checkList[k]) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    answer += 1;
                cnt[dna.get(map.pop())] -= 1;
                flag = true;
            }
        }
        System.out.println(answer);
    }
}