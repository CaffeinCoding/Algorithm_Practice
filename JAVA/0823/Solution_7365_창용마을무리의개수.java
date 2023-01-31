import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_7365_창용마을무리의개수 {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] check;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            list = new ArrayList<ArrayList<Integer>>();
            st = new StringTokenizer(in.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            check = new boolean[N];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                list.add(new ArrayList<Integer>());
            }
            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                int S = Integer.parseInt(st.nextToken())-1;
                int E = Integer.parseInt(st.nextToken())-1;
                list.get(S).add(E);
                list.get(E).add(S);
            }

            for (int i = 0; i < N; i++) {
                if(!check[i]){
                    bfs(i);
                    cnt += 1;
                }
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int start){
        Deque<Integer> dq = new ArrayDeque<Integer>();
        dq.add(start);
        check[start] = true;
        while(!dq.isEmpty()){
            int tmp = dq.poll();
            int size = list.get(tmp).size();
            for (int i = 0; i < size; i++) {
                int t = list.get(tmp).get(i);
                if(!check[t]){
                    dq.add(t);
                    check[t] = true;
                }
            }
        }
    }
}
