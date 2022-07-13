package Sort;

//출처:https://st-lab.tistory.com/179?category=892973
public class insertionSort {
	public static void insertion_sort(int[] a) {
		insertion_sort(a, a.length);
	}

	private static void insertion_sort(int[] a, int size) {
		for (int i = 1; i < size; i++) {
			// 타겟 넘버
			int target = a[i];
			int j = i - 1;

			// 타겟이 이전 원소보다 크기 전 까지 반복
			while (j >= 0 && target < a[j]) {
				// 이전 원소를 한 칸씩 뒤로
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = target;
		}
	}
}
