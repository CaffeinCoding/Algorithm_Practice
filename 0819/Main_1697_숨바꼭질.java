import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
    static int min = Integer.MAX_VALUE;
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(M < N){
            min = N - M;
        }else{
            count(N,0, 0);
        }
        System.out.println(min);
    }

    public static void count(int num, int cnt, int flag){
        if(num > 2*M || num < 0 || cnt > min){
            return;
        }
        if(num == M){
            if(cnt < min){
                min = cnt;
            }
            return;
        }
        if(flag != 2){
            count(num-1, cnt+1, 1);
        }
        if(flag != 1){
            count(num+1, cnt+1, 2);
        }
        if(num != 2){
            count(2*num, cnt+1, 0);
        }
    }

}
