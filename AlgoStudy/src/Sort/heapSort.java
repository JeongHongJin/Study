package Sort;

//출처: https://st-lab.tistory.com/225?category=892973
public class heapSort {
	public static void sort(int[] a) {
		sort(a, a.length);
	}

	private static void sort(int[] a, int size) {
		// 부모노드와 heapify과정에서 음수가 발생하면 잘못된 참조 발생
		// 원소가 1개이거나 0개일 경우는 정렬 할 필요가 없다.
		if (size < 2) {
			return;
		}

		// left child = idx * 2 + 1
		// right child = idx * 2 + 2
		// parent node = (idx - 1) / 2

		// 가장 마지막 요소의 부모 인덱스
		int parentIdx = getParent(size - 1);

		// max heap
		for (int i = parentIdx; i >= 0; i--) {
			heapify(a, i, size - 1);
		}

		for (int i = size - 1; i > 0; i--) {
			// root인 0번째 인덱스와 i번째 인덱스의 값을 교환
			// 0 ~ (i - 1) 까지의 부분트리에 대해 max haep을 만족하게 재구성
			swap(a, 0, i);
			heapify(a, 0, i - 1);
		}

	}

	// 부모 인덱스
	private static int getParent(int child) {
		return (child - 1) / 2;
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private static void heapify(int[] a, int parentIdx, int lastIdx) {

		int leftChildIdx;
		int rightChildIdx;
		int largestIdx;

		// 현재 부모 인덱스의 자식 노드 인덱스가 마지막 인덱스를 넘지 않을 때 까지 반복
		// 이 경우 left child 기준으로 반복
		// right child 기준으로 검사하면 마지막 parent idx가 left child만 가지고 있는 경우
		// left child와 비교 교환을 할 수 없다.

		while ((parentIdx * 2) + 1 <= lastIdx) {
			leftChildIdx = (parentIdx * 2) + 1;
			rightChildIdx = (parentIdx * 2) + 2;
			largestIdx = parentIdx;

			// left child와 비교
			if (a[leftChildIdx] > a[largestIdx]) {
				largestIdx = leftChildIdx;
			}
			// right child와 비교
			if (rightChildIdx <= lastIdx && a[rightChildIdx] > a[largestIdx]) {
				largestIdx = rightChildIdx;
			}

			// swap하는 경우 swap 이후 child가 parent가 되게 교체
			if (largestIdx != parentIdx) {
				swap(a, parentIdx, largestIdx);
				parentIdx = largestIdx;
			} else {
				return;
			}
		}

	}
}
