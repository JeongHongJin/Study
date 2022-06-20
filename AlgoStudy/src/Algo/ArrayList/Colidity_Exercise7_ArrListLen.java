package Algo.ArrayList;

public class Colidity_Exercise7_ArrListLen {
	class Solution {
	    public int solution(int[] A) {
	        // write your code in Java SE 8
	        int answer = 1;
	        int idx = 0;
	        while(A[idx] != -1){
	            idx = A[idx];
	            answer++;
	        }
	        return answer;
	    }
	}

}
