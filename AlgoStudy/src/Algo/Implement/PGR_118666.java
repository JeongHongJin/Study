package Algo.Implement;

public class PGR_118666 {
	class Solution {
		public String solution(String[] survey, int[] choices) {
			String answer = "";
			int[] score = new int[4];
			for (int i = 0; i < survey.length; i++) {
				char c1 = survey[i].charAt(0);
				int num = choices[i] - 4;
				if (c1 == 'R') {
					score[0] += num;
				} else if (c1 == 'C') {
					score[1] += num;
				} else if (c1 == 'J') {
					score[2] += num;
				} else if (c1 == 'A') {
					score[3] += num;
				} else if (c1 == 'T') {
					score[0] -= num;
				} else if (c1 == 'F') {
					score[1] -= num;
				} else if (c1 == 'M') {
					score[2] -= num;
				} else if (c1 == 'N') {
					score[3] -= num;
				}
			}
			if (score[0] <= 0) {
				answer += "R";
			} else {
				answer += "T";
			}
			if (score[1] <= 0) {
				answer += "C";
			} else {
				answer += "F";
			}
			if (score[2] <= 0) {
				answer += "J";
			} else {
				answer += "M";
			}
			if (score[3] <= 0) {
				answer += "A";
			} else {
				answer += "N";
			}

			return answer;
		}
	}
}
