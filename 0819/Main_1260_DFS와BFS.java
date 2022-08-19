import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> arr;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        arr = new ArrayList<ArrayList<Integer>>();
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.get(start).add(end);
            arr.get(end).add(start);
        }
        
        for (int i = 0; i <= N; i++) {
            arr.get(i).sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
        }
        
        dfs(new boolean[N+1], V);
        sb.append("\n");
        bfs(new boolean[N+1], V);

        System.out.println(sb);
    }

    public static void bfs(boolean[] check, int start){
        Deque<Integer> q = new ArrayDeque<Integer>();
        q.add(start);
        check[start] = true;
        while(!q.isEmpty()){
            int tmp = q.poll();
            sb.append(tmp).append(" ");
            int size = arr.get(tmp).size();
            for (int i = 0; i < size; i++) {
                int u = arr.get(tmp).get(i);
                if(!check[u]){
                    q.add(u);
                    check[u] = true;
                }
            }
        }
    }

    public static void dfs(boolean[] check, int start){
        check[start] = true;
        sb.append(start).append(" ");
        int size = arr.get(start).size();
        for (int i = 0; i < size; i++) {
            int end = arr.get(start).get(i);
            if(!check[end]){
                dfs(check, end);
            }
        }
    }
}
