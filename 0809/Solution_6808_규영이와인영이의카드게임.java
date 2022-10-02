import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {
    static boolean[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        List<Integer> map;
        int N = Integer.parseInt(in.readLine());
        int[] arr1;
        int[] arr2;
        int M = 9;
        for (int tc = 1; tc <= N; tc++) {
            selected = new boolean[M];
            arr1 = new int[M];
            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < M; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr1);
        }
    }

    static void permute(int next, int[] pick, boolean[] select, int[] arr, int M) {
        if (next == 0) {
            return;
        }
        for (int i = 0; i < M; i++) {
            if (!select[i]) {
                select[i] = true;
                pick[pick.length - next] = arr[i];
                permute(next - 1, pick, select, arr, M);
                select[i] = false;
            }
        }
    }
}
