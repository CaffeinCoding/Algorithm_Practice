import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
    static char[][] check;
    static int R, C, hR, hC, result;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        check = new char[R][C];
        ArrayDeque<int[]> q = new ArrayDeque<int[]>();
        ArrayDeque<int[]> wq = new ArrayDeque<int[]>();
        for (int i = 0; i < R; i++) {
            char[] tmp = in.readLine().toCharArray();
            check[i] = tmp;
            for (int j = 0; j < C; j++) {
                if(tmp[j] == '*'){
                    wq.add(new int[]{i,j});
                }else if(tmp[j] == 'S'){
                    q.add(new int[]{i,j});
                }else if(tmp[j] == 'D'){
                    hR = i;
                    hC = j;
                }
            }
        }

        find(q, wq, 0);

        if(flag){
            System.out.println("KAKTUS");
        }else{
            System.out.println(result);
        }
    }

    public static void find(ArrayDeque<int[]> q, ArrayDeque<int[]> wq, int cnt){
        ArrayDeque<int[]> dq = new ArrayDeque<int[]>();
        ArrayDeque<int[]> wdq = new ArrayDeque<int[]>();
        while(!wq.isEmpty()){
            int[] tmp = wq.poll();
            if(tmp[0] - 1 >= 0 && check[tmp[0] - 1][tmp[1]] == '.'){
                check[tmp[0] - 1][tmp[1]] = '*';
                wdq.add(new int[]{tmp[0] - 1, tmp[1]});
            }
            if(tmp[0] + 1 < R && check[tmp[0] + 1][tmp[1]] == '.'){
                check[tmp[0] + 1][tmp[1]] = '*';
                wdq.add(new int[]{tmp[0] + 1, tmp[1]});
            }
            if(tmp[1] + 1 < C && check[tmp[0]][tmp[1] + 1] == '.'){
                check[tmp[0]][tmp[1] + 1] = '*';
                wdq.add(new int[]{tmp[0], tmp[1] + 1});
            }
            if(tmp[1] - 1 >= 0 && check[tmp[0]][tmp[1] - 1] == '.'){
                check[tmp[0]][tmp[1] - 1] = '*';
                wdq.add(new int[]{tmp[0], tmp[1] - 1});
            }
        }
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[0] == hR && tmp[1] == hC){
                result = cnt;
                return;
            }
            if(tmp[0] - 1 >= 0 && (check[tmp[0] - 1][tmp[1]] == '.' || check[tmp[0] - 1][tmp[1]] == 'D')){
                check[tmp[0] - 1][tmp[1]] = 'S';
                dq.add(new int[]{tmp[0] - 1, tmp[1]});
            }
            if(tmp[0] + 1 < R && (check[tmp[0] + 1][tmp[1]] == '.' || check[tmp[0] + 1][tmp[1]] == 'D')){
                check[tmp[0] + 1][tmp[1]] = 'S';
                dq.add(new int[]{tmp[0] + 1, tmp[1]});
            }
            if(tmp[1] + 1 < C && (check[tmp[0]][tmp[1] + 1] == '.' || check[tmp[0]][tmp[1] + 1] == 'D')){
                check[tmp[0]][tmp[1] + 1] = 'S';
                dq.add(new int[]{tmp[0], tmp[1] + 1});
            }
            if(tmp[1] - 1 >= 0 && (check[tmp[0]][tmp[1] - 1] == '.' || check[tmp[0]][tmp[1] - 1] == 'D')){
                check[tmp[0]][tmp[1] - 1] = 'S';
                dq.add(new int[]{tmp[0], tmp[1] - 1});
            }
        }

        if(dq.isEmpty()){
            flag = true;
            return;
        }

        find(dq, wdq, cnt+1);
    }
}
