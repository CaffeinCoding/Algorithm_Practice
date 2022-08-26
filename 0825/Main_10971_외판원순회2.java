import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {
    static int N, S;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[N];
        visited[0] = true;
        dfs(0, 0, 0, visited);

        System.out.println(min);
    }

    public static void dfs(int start, int cnt, int result, boolean[] visited) {
        if (cnt == N - 1) {
            result += map[start][0];
            if (min > result && map[start][0] > 0) {
                min = result;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && map[start][i] != 0) {
                visited[i] = true;
                dfs(i, cnt + 1, result + map[start][i], visited);
                visited[i] = false;
            }
        }
    }
}
