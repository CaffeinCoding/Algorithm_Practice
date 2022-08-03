import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int swCnt = Integer.parseInt(in.readLine());
		StringTokenizer tn = new StringTokenizer(in.readLine(), " ");
		int[] sw = new int[swCnt];
		for (int i = 0; i < swCnt; i++) {
			sw[i] = Integer.parseInt(tn.nextToken());
		}

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			int[] feature = new int[2];
			tn = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < 2; i++) {
				feature[i] = Integer.parseInt(tn.nextToken());
			}
			if (feature[0] == 1) {
				for (int k = feature[1] - 1; k < swCnt; k += feature[1]) {
					sw[k] = sw[k] == 1 ? 0 : 1;
				}
			} else {
				int idx = feature[1] - 1;
				sw[idx] = sw[idx] == 1 ? 0 : 1;
				for (int k = 1; idx + k < swCnt && idx - k >= 0; k++) {
					if (sw[idx - k] == sw[idx + k]) {
						sw[idx - k] = sw[idx - k] == 1 ? 0 : 1;
						sw[idx + k] = sw[idx + k] == 1 ? 0 : 1;
					}else {
						break;
					}
				}
			}
		}
		for (int i = 0; i < swCnt; i++) {
			if (i % 20 == 0 && i != 0)
				System.out.println();
			System.out.print(sw[i] + " ");
		}
	}
}
