package Sort;

//출처:https://st-lab.tistory.com/195?category=892973
public class bubbleSort {
	public static void bubble_sort(int[] a) {
		bubble_sort(a, a.length);
	}

	private static void bubble_sort(int[] a, int size) {

		// 1 round당
		// 배열 크기 - 1 만큼 진행
		for (int i = 1; i < size; i++) {
			// 각 round별 비교횟수는 배열 크기의 현재 round를 뺀 만큼 비교
			for (int j = 0; j < size - i; j++) {
				// 현재 원소가 다음 원소보다 클경우
				// 서로 원소의 위치를 교환
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
