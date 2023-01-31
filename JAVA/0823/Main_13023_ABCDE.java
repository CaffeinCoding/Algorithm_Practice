import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static boolean[] check;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        check = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }
        for (int i = 0; i < N && !flag; i++) {
            check[i] = true;
            dfs(i, 0);
            check[i] = false;
        }
        System.out.println(flag?1:0);
    }

    public static void dfs(int start, int cnt){
        if(cnt >= 4){
            flag = true;
            return;
        }
        int size = list.get(start).size();
        for (int i = 0; i < size && !flag; i++) {
            int tmp = list.get(start).get(i);
            if(!check[tmp]){
                check[tmp] = true;
                dfs(tmp, cnt+1);
                check[tmp] = false;
            }
        }
    }
}