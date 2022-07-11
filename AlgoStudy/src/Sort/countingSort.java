package Sort;

//출처:https://st-lab.tistory.com/104?category=892973
public class countingSort {
	public static void main(String[] args) {

		int[] arr = new int[100];
		int[] counting = new int[31]; // 수의 범위 0~30
		int[] result = new int[100]; // 정렬된 배열

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 31);
		}

		// counting
		for (int i = 0; i < arr.length; i++) {
			// arr의 해당 val에 대한 값 counting
			counting[arr[i]]++;
		}

		for (int i = 1; i < counting.length; i++) {
			// 갯수 누적합
			counting[i] += counting[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {

			// i 번째 인덱스로 하는 counting 배열을 1 감소 시킨뒤
			// counting 배열의 값을 인덱스로 하여 result에 val 저장
			int val = arr[i];
			counting[val]--;
			result[counting[val]] = val;
		}

		// 초기 배열
		System.out.println("arr[]");
		for (int i = 0; i < arr.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println();

		// counting 배열
		System.out.println("counting[]");
		for (int i = 0; i < counting.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.print(counting[i] + " ");
		}
		System.out.println();
		System.out.println();

		// 정렬된 배열
		System.out.println("result[]");
		for (int i = 0; i < result.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.print(result[i] + " ");
		}
		System.out.println();
		System.out.println();

	}
}
