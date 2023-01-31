import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17478_재귀함수가뭔가요 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(in.readLine());
		String q = "\"재귀함수가 뭔가요?\"";
		String a1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		String a2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		String a3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		String af = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		String f = "라고 답변하였지.";
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recurrency(cnt, q, a1, a2, a3, af, f);
		System.out.println(f);
	}

	public static void recurrency(int cnt, String q, String a1, String a2, String a3, String af, String f) {
		System.out.println(q);
		if (cnt == 0) {
			System.out.println(af);
			return;
		} else {
			System.out.println(a1);
			System.out.println(a2);
			System.out.println(a3);
		}
		q = "____" + q;
		a1 = "____" + a1;
		a2 = "____" + a2;
		a3 = "____" + a3;
		af = "____" + af;
		f = "____" + f;
		
		recurrency(cnt-1, q, a1, a2, a3, af, f);
		
		System.out.println(f);
	}
}
