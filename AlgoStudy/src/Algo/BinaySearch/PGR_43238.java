package Algo.BinaySearch;

import java.util.Arrays;

public class PGR_43238 {
	class Solution {
		public long solution(int n, int[] times) {
	        long answer = 0;
	        Arrays.sort(times);
	        long left = 0;
	        long right = (long)n * times[times.length-1];
	        while(left <= right){
	            long mid = (left + right) / 2;
	            long sum = 0;
	            for(int i = 0 ; i<times.length;i++){
	                sum += mid / times[i];
	            }
	            if(sum < n){ //모든 검사 시간 대비 mid가 n명 미만으로 검사하는 경우
	                left = mid + 1;
	            }else{
	                right = mid - 1;
	                answer = mid;
	            }
	        }
	        return answer;
	    }
	}
}
