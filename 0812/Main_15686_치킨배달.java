import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
    static int min = Integer.MAX_VALUE;
    static int[][] map;

    static void combina(int cnt, int[] pick, int idx, int[] list, int hSize) {
        if (cnt == 0) {
            int sum = 0;
            for (int i = 0; i < hSize; i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < pick.length; j++) {
                    tmp = Math.min(tmp, map[pick[j]][i]);
                }
                sum += tmp;
            }
            min = Math.min(min, sum);
            return;
        }
        for (int i = idx; i < list.length; i++) {
            pick[pick.length - cnt] = list[i];
            combina(cnt - 1, pick, i + 1, list, hSize);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<int[]> house = new ArrayList<int[]>();
        List<int[]> chicken = new ArrayList<int[]>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < N; j++) {
                char tmp = st.nextToken().charAt(0);
                if (tmp - '0' == 1) {
                    house.add(new int[] { i, j });
                } else if (tmp - '0' == 2) {
                    chicken.add(new int[] { i, j });
                }
            }
        }

        int hSize = house.size();
        int cSize = chicken.size();
        int[] list = new int[cSize];
        map = new int[cSize][hSize];
        for (int i = 0; i < cSize; i++) {
            for (int j = 0; j < hSize; j++) {
                int[] c = chicken.get(i);
                int[] h = house.get(j);
                map[i][j] = Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]);
            }
            list[i] = i;
        }

        for (int i = 0; i < cSize; i++) {
            for (int j = 0; j < hSize; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        combina(M, new int[M], 0, list, hSize);

        System.out.println(min);
    }
}
