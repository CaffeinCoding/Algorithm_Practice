import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
    static int[] p;
    static int N, M;

    public static int find(int x){
        if(p[x] == x){
            return p[x];
        }
        
        return p[x] = find(p[x]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(in.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            p = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                p[i] = i;
            }
            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                int c = Integer.parseInt(st.nextToken());
                int a = find(Integer.parseInt(st.nextToken()));
                int b = find(Integer.parseInt(st.nextToken()));
                
                switch(c){
                    case 0:
                    if(a != b){
                        p[b] = a;
                    }
                    break;
                    case 1:
                    if(a == b){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                    break;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
