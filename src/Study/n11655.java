package Study;

import java.util.Scanner;

public class n11655 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String answer = "";
		String[] arr = s.split(" ");
		String[] answerarr = new String[arr.length];
		int charnum = 0;
		for (int i = 0; i < arr.length; i++) {
			answerarr[i] = "";
			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) >= 'A' && arr[i].charAt(j) <= 'Z') {
					charnum = arr[i].charAt(j) + 13;
					if (charnum > 90) {
						charnum -= 26;
					}
				} else if (arr[i].charAt(j) >= 'a' && arr[i].charAt(j) <= 'z') {
					charnum = arr[i].charAt(j) + 13;
					if (charnum > 122) {
						charnum -= 26;
					}
				} else
					charnum = arr[i].charAt(j);
				answerarr[i] += (char) charnum;
			}
			answer += answerarr[i];
			if (i != arr.length - 1) {
				answer += " ";
			}
		}
		System.out.println(answer);
		sc.close();
	}
}
