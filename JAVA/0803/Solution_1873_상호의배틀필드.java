import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		char[] player = { '^', 'v', '>', '<' };
		char[] direction = { 'U', 'D', 'R', 'L' };
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer hw = new StringTokenizer(in.readLine(), " ");
			int H = Integer.parseInt(hw.nextToken());
			int W = Integer.parseInt(hw.nextToken());
			int sR = 0;
			int sC = 0;
			char[][] map = new char[H][W];
			char lastDirection = 0;
			for (int r = 0; r < H; r++) {
				map[r] = in.readLine().toCharArray();
				int cSize = map[r].length;
				if (sR == 0) {
					OUT: for (int c = 0; c < cSize; c++) {
						for (int i = 0; i < 4; i++) {
							if (player[i] == map[r][c]) {
								sR = r;
								sC = c;
								lastDirection = direction[i];
								break OUT;
							}
						}
					}
				}
			}
			in.readLine();
			char[] move = in.readLine().toCharArray();
			for (char m : move) {
				if (m != 'S') {
					map[sR][sC] = '.';
					if (m == 'U') {
						if (sR > 0 && map[sR - 1][sC] == '.') {
							sR -= 1;
						}
						map[sR][sC] = player[0];
					} else if (m == 'D') {
						if ((sR < H - 1) && map[sR + 1][sC] == '.') {
							sR += 1;
						}
						map[sR][sC] = player[1];
					} else if (m == 'R') {
						if ((sC < W - 1) && map[sR][sC + 1] == '.') {
							sC += 1;
						}
						map[sR][sC] = player[2];
					} else if (m == 'L') {
						if (sC > 0 && map[sR][sC - 1] == '.') {
							sC -= 1;
						}
						map[sR][sC] = player[3];
					}
					lastDirection = m;
				} else {
					if (lastDirection == 'U') {
						for (int i = sR; i >= 0; i--) {
							if (map[i][sC] == '*') {
								map[i][sC] = '.';
								break;
							} else if (map[i][sC] == '#') {
								break;
							}
						}
					} else if (lastDirection == 'D') {
						for (int i = sR; i < H; i++) {
							if (map[i][sC] == '*') {
								map[i][sC] = '.';
								break;
							} else if (map[i][sC] == '#') {
								break;
							}
						}
					} else if (lastDirection == 'R') {
						for (int i = sC; i < W; i++) {
							if (map[sR][i] == '*') {
								map[sR][i] = '.';
								break;
							} else if (map[sR][i] == '#') {
								break;
							}
						}
					} else if (lastDirection == 'L') {
						for (int i = sC; i >= 0; i--) {
							if (map[sR][i] == '*') {
								map[sR][i] = '.';
								break;
							} else if (map[sR][i] == '#') {
								break;
							}
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			for (int r = 0; r < H; r++) {
				sb.append(new String(map[r])).append("\n");
			}
		}
		System.out.println(sb);
	}
}
