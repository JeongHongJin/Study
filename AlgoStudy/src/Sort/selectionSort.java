package Sort;

public class selectionSort {

	public static void selection_sort(int[] a) {
		selection_sort(a, a.length);
	}

	private static void selection_sort(int[] a, int size) {

		for (int i = 0; i < size - 1; i++) {
			int min_idx = i;

			// 최솟값 index 찾기
			for (int j = i + 1; j < size; j++) {
				if (a[j] < a[min_idx]) {
					min_idx = j;
				}
			}
			// 최솟값과 swap
			swap(a, min_idx, i);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
