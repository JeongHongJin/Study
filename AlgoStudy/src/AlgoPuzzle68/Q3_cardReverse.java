package AlgoPuzzle68;

public class Q3_cardReverse {
	public static void main(String[] args) {
		boolean[] visit = new boolean[101];
		for (int i = 2; i < 101; i++) {
			for (int j = i; j < 101; j += i) {
				visit[j] = !visit[j];
			}
		}
		for (int i = 1; i < visit.length; i++) {
			if (!visit[i])
				System.out.println(i);
		}
	}
}
