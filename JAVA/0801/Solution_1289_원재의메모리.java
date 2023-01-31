import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1289_원재의메모리 {
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder re = new StringBuilder();
        int T;
        T = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            re.append("#").append(test_case).append(" ");
            String input = in.readLine().replaceAll("0+", "0").replaceAll("1+", "1").replaceAll("^0","");
            int size = input.length();
            re.append(size).append("\n");
        }
        System.out.println(re);
    }
}
