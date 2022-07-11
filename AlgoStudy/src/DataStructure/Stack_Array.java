package DataStructure;

import java.util.Arrays;
import java.util.EmptyStackException;

//출처:https://st-lab.tistory.com/174
public class Stack_Array<E> implements StackInterface<E> {

	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] EMPTY_ARRAY = {};

	private Object[] array;
	private int size;

	// 초기 빈 상태로 생성
	public Stack_Array() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}

	// 초기 공간 할당한 상태로 생성
	public Stack_Array(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}

	private void resize() {
		// 빈 배열일 경우 (capacity 0)
		if (Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}

		int arrayCapacity = array.length; // 현재 capacity 크기

		// capacity 가득찬경우
		if (size == arrayCapacity) {
			int newSize = arrayCapacity * 2;

			// 배열 복사
			array = Arrays.copyOf(array, newSize);
			return;
		}
		// capacity 절반 미만으로 요소가 차지하고 있을 경우
		if (size < (arrayCapacity / 2)) {
			int newCapacity = (arrayCapacity / 2);
			// 배열 복사
			array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));
			return;
		}
	}

	@Override
	public E push(E item) {
		// capacity resize
		if (size == array.length) {
			resize();
		}
		array[size] = item; // 마지막 위치에 추가
		size++; // 사이즈 증가

		return item;
	}

	@Override
	public E pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		@SuppressWarnings("unchecked")
		E obj = (E) array[size - 1];

		array[size - 1] = null;
		size--;
		resize();

		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		return (E) array[size - 1];
	}

	@Override
	public int search(Object value) {

		// 같은 객체를 찾았을 경우 size - idx 값을 반환
		for (int idx = size - 1; idx >= 0; idx--) {
			if (array[idx].equals(value)) {
				return size - idx;
			}
		}
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		// 저장된 요소 모두 null 처리
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
		resize();

	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}

	public <T> T[] toArray(T[] a) {
		if (a.length < size)
			return (T[]) Arrays.copyOf(array, size, a.getClass());

		System.arraycopy(array, 0, a, 0, size);
		return a;
	}

}
