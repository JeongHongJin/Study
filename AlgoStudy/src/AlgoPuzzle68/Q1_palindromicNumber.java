package AlgoPuzzle68;

public class Q1_palindromicNumber {
	// 10진수, 2진수 , 8진수 로표현 가능한 대칭수 10이상에서의 최솟값.
	public static void main(String[] args) {
		boolean flag10 = true;
		boolean flag2 = true;
		boolean flag8 = true;
		for (int i = 10;; i++) {
			flag10 = true;
			flag2 = true;
			flag8 = true;
			String ten = Integer.toString(i);
			if (!check(ten))
				continue;
			String two = "";
			int Num2 = i;
			while (Num2 > 0) {
				two += Num2 % 2;
				Num2 /= 2;
			}
			if (!check(two))
				continue;
			String eight = "";
			int Num8 = i;
			while (Num8 > 0) {
				eight += Num8 % 8;
				Num8 /= 8;
			}
			if (!check(eight)) {
				continue;
			} else {
				System.out.println(i);
				break;
			}
		}
	}

	static boolean check(String s) {
		for (int j = 0; j < s.length() / 2; j++) {
			if (s.charAt(j) != s.charAt(s.length() - j - 1)) {
				return false;
			}
		}
		return true;
	}
}
