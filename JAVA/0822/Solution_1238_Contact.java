import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            list = new ArrayList<ArrayList<Integer>>();
            st = new StringTokenizer(in.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            
            visited = new boolean[L];
            max = 0;

            for (int i = 0; i < L; i++) {
                list.add(new ArrayList<Integer>());
            }
            
            st = new StringTokenizer(in.readLine()," ");
            while(st.hasMoreTokens()){
                list.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
            }
            ArrayList<Integer> root = new ArrayList<Integer>();
            root.add(start);
            visited[start] = true;
            bfs(root);
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(ArrayList<Integer> p){
        ArrayList<Integer> c = new ArrayList<Integer>();
        for (int s : p) {
            int size = list.get(s).size();
            for (int i = 0; i < size; i++) {
                int tmp = list.get(s).get(i);
                if(!visited[tmp]){
                    c.add(tmp);
                    visited[tmp] = true;
                }
            }
        }
        if(c.isEmpty()){
            for (int s : p) {
                if(s > max){
                    max = s;
                }
            }
        }else{
            bfs(c);
        }
    }
}
