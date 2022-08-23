import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
    static boolean[][] list;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(in.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            list = new boolean[N][N];


            for (int i = 0; i < N; i++) {
                list[i] = new boolean[N];
                list[i][i] = true;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine()," ");
                int flag = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                switch(flag){
                    case 0:
                    for (int j = 0; j < N; j++) {
                        if(list[b][j] == true){
                            list[a][j] = true;
                        }
                        if(list[a][j] == true){
                            list[b][j] = true;
                        }
                    }
                    break;
                    case 1:
                    if(list[a][b]){
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
