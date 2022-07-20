package Sort;

public class quickSortLeftPivot {
	public static void sort(int[] a) {
		left_pivot_sort(a, 0, a.length - 1);
	}

	// low 현재 부분배영읠 왼쪽
	// high 현재 부분배열의 오른쪽
	private static void left_pivot_sort(int[] a, int low, int high) {
		// low가 high보다 크거나 같다면 정렬 할 원소가
		// 1개 이하 이므로 정렬하지 않고 return한다.
		if (low >= high) {
			return;
		}
		// 피벗을 기준으로 요소들이 왼쪽과 오른쪽으로 약하게 정렬 된 상태로 만든 뒤
		// 최종적으로 pivot의 위치를 얻는다.
		// 이 후 해당 pivot을 기준으로 왼쪽 부분리스트와 오른쪽 부분리스트로 나누어 분할 정복

		int pivot = partition(a, low, high);

		left_pivot_sort(a, low, pivot - 1);
		left_pivot_sort(a, pivot + 1, high);
	}

	// left: 현재 배열의 가장 왼쪽
	// right: 현재 배열의 가장 오른쪽
	private static int partition(int[] a, int left, int right) {
		int low = left;
		int high = right;
		int pivot = a[left];

		// low가 high보다 작을 때 까지 반복
		while (low < high) {

			// high가 low보다 크면서, high의 요소가 pivot보다 작거나 같은 원소를 찾을 때 까지 high를 감소
			while (a[high] > pivot && low < high) {
				high--;
			}

			// high가 low보다 크면서, low의 요소가 pivot보다 큰 원소를 찾을 때 까지 low 증가
			while (a[low] <= pivot && low < high) {
				low++;
			}
			// 교환 될 두 요소 찾으면 swap
			swap(a, low, high);
		}
		// 마지막으로 맨 처음 pivot으로 설정했던 위치(a[left])의 원소와 low가 가르키는 원소를 바꾼다.
		swap(a, left, low);

		// 두 요소가 교환되었다면 피벗이었던 요소는 low에 위치하므로 low를 반환
		return low;
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
