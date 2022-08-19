import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
    static StringTokenizer st;
    static ArrayList<int[]> list = new ArrayList<int[]>();
    static int[] nums;

    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        nums = new int[M];
        int[][] map = new int[N+D][M];

        for (int i = 0; i < M; i++) {
            nums[i] = i;
        }

        for (int i = 0; i < D; i++) {
            map[i] = new int[M];
        }
        for (int i = D; i < N+D; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(3, new int[3], 0);

        for (int[] t : list) {
            int cnt = 0;
            boolean[][] visitedK = new boolean[N+D][M];
            for (int i = 0; i < N; i++) {
                // boolean[] visitedN = new boolean[M];
                for(int d = 0; d < D; d++){
                for (int j = 0; j < M; j++) {
                    for (int k = 0; k < t.length; k++) {
                        if(map[i+D][j] == 1){
                            if(!visitedK[i+D][k]){
                                if(distance(j, t[k], i+D, i) >= D){
                                    cnt += 1;
                                    visitedK[i+D][k] = true;
                                    // visitedN[j] = true;
                                }
                            }
                        }
                    }
                }
                }
            }
            if(cnt > max){
                max = cnt;
                System.out.println(Arrays.toString(t));
            }
            System.out.println(Arrays.toString(t));
        }

        System.out.println(max);
    }
    
    public static void comb(int cnt, int[] choose, int idx){
        if(cnt == 0){
            list.add(choose.clone());
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            choose[choose.length - cnt] = nums[i];
            comb(cnt - 1, choose, i + 1);
        }
    }

    public static int distance(int ax, int bx, int ay, int by){
        return Math.abs(ax-bx)+Math.abs(ay-by);
    }
}
