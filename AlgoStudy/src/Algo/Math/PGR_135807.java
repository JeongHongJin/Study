package Algo.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PGR_135807 {
	class Solution {
		public int solution(int[] arrayA, int[] arrayB) {
			int answer = 0;
			Arrays.sort(arrayA);
			Arrays.sort(arrayB);
			int tmp = arrayA[0];
			int tmp2 = arrayB[0];
			ArrayList<Integer> numA = new ArrayList<>();
			ArrayList<Integer> numB = new ArrayList<>();
			ArrayList<Integer> numC = new ArrayList<>();
			ArrayList<Integer> numD = new ArrayList<>();
			for (int i = 1; i <= Math.sqrt(tmp); i++) {
				if (tmp % i == 0) {
					numA.add(i);
					if (tmp / i != i) {
						numA.add(tmp / i);
					}
				}
			}
			for (int i = 1; i <= Math.sqrt(tmp2); i++) {
				if (tmp2 % i == 0) {
					numB.add(i);
					if (tmp2 / i != i) {
						numB.add(tmp2 / i);
					}
				}
			}
			Collections.sort(numA);
			Collections.sort(numB);
			for (int i = 0; i < numA.size(); i++) {
				int now = numA.get(i);
				boolean flag = true;
				for (int j = 0; j < arrayA.length; j++) {
					if (arrayA[j] % now != 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					numC.add(now);
				}
			}
			for (int i = 0; i < numB.size(); i++) {
				int now = numB.get(i);
				boolean flag = true;
				for (int j = 0; j < arrayB.length; j++) {
					if (arrayB[j] % now != 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					numD.add(now);
				}
			}
			for (int i = 0; i < numC.size(); i++) {
				int now = numC.get(i);
				boolean flag = true;
				for (int j = 0; j < arrayB.length; j++) {
					if (arrayB[j] % now == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					answer = Math.max(answer, now);
				}
			}
			for (int i = 0; i < numD.size(); i++) {
				int now = numD.get(i);
				boolean flag = true;
				for (int j = 0; j < arrayA.length; j++) {
					if (arrayA[j] % now == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					answer = Math.max(answer, now);
				}
			}
			return answer;
		}
	}
}
