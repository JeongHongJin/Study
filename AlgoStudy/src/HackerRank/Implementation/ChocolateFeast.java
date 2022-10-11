package HackerRank.Implementation;

public class ChocolateFeast {
	public static int chocolateFeast(int n, int c, int m) {
		int answer = 0;
		int wrapper = n / c;
		answer += wrapper;
		while (wrapper >= m) {
			int tmp = wrapper / m;
			answer += tmp;
			wrapper = tmp + (wrapper % m);
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(chocolateFeast(15, 3, 2));
	}
}
