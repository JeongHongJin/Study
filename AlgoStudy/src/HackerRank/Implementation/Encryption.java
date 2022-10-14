package HackerRank.Implementation;

public class Encryption {
	public static String encryption(String s) {
		double a = Math.sqrt(s.length());
		a = Math.ceil(a);
		int len = (int) (a);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (len * (len - 1) < s.length()) {
				for (int j = 0; j < len; j++) {
					if (i + len * j >= s.length())
						continue;
					sb.append(s.charAt(i + (len * j)));
				}
			} else
				for (int j = 0; j < len - 1; j++) {
					if (i + len * j >= s.length())
						continue;
					sb.append(s.charAt(i + (len * j)));
				}
			sb.append(' ');
		}
		return sb.toString();
	}
}
