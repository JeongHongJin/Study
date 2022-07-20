package Sort;

//출처: https://st-lab.tistory.com/233?category=892973
public class mergeSortTopDown {
	public static int[] sorted;

	public static void merge_sort(int[] a) {
		sorted = new int[a.length];
		merge_sort(a, 0, a.length - 1);
		sorted = null;
	}

	private static void merge_sort(int[] a, int left, int right) {

		// left == right 즉, 부분리스트가 1개의 원소만 갖고있는 경우
		// 더이상 쪼갤 수 없으므로 return한다.
		if (left == right)
			return;

		int mid = (left + right) / 2; // 절반 idx
		merge_sort(a, left, mid); // left ~ mid
		merge_sort(a, mid + 1, right); // mid + 1 ~ right
		merge(a, left, mid, right); // 병합
	}

	// left ~ right 병합
	private static void merge(int[] a, int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int idx = left;

		while (l <= mid && r <= right) {
			// 왼쪽 부분리스트 l번째 우너소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
			// 왼쪾의 l번째 우너소를 새 배열에 넣고 idx++
			if (a[l] <= a[r]) {
				sorted[idx] = a[l];
				idx++;
				l++;
			} else {
				// 오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
				// 오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx++
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		// 왼쪽 부분리스트가 먼저 모두 새 배열에 채워지는 경우 (l > mid)
		// 오른쪽 부분리스트 원소가 남아있는 경우
		// 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
		if (l > mid) {
			while (r <= right) {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		} else {
			// 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
			// 왼쪽 부분리스트 원소가 아직 남아있을 경우
			// 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
			while (l <= mid) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
		}
		// 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
		for (int i = left; i <= right; i++) {
			a[i] = sorted[i];
		}
	}
}
