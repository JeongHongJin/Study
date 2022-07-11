package DataStructure;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

//출처:https://st-lab.tistory.com/183
public class Queue_Array<E> implements Queue<E> {

	private static final int DEFAULT_CAPACITY = 64;
	private Object[] array;
	private int size;

	private int front;
	private int rear;

	// 초기 용적 할당 안한경우
	public Queue_Array() {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}

	// 초기 용적 할당을 한경우
	public Queue_Array(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}

	private void resize(int newCapacity) {
		int arrayCapacity = array.length;// 현재 용적

		Object[] newArray = new Object[newCapacity]; // 용적 변경한 배열

//		i = new array index
//		j = original array
//		index 요소 개수 만큼 새 배열에 값 복사
		for (int i = 1, j = front + 1; i <= size; i++, j++) {
			newArray[i] = array[j % arrayCapacity];
		}
		this.array = null;
		this.array = newArray;
		front = 0;
		rear = size;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		int start = (front + 1) % array.length;
//		i : 요소 개수만큼만 반복한다.
//		idx : 원소 위치로, 매 회 (idx + 1) % array.length 위치로 갱신
		for (int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length) {
			if (array[idx].equals(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		return toArray(new Object[size]);
	}

	@Override
	public <T> T[] toArray(T[] a) {
		final T[] res;
		// 들어오는 배열의 길이가 큐의 요소 개수보다 작은경우
		if (a.length < size) {
			// front가 rear보다 앞에 있을 경우(요소가 없는 경우 f==r)
			if (front <= rear) {
				return (T[]) Arrays.copyOfRange(array, front + 1, rear + 1, a.getClass());
			}
			// front가 rear보다 뒤에 있을 경우
			res = (T[]) Arrays.copyOfRange(array, 0, size, a.getClass());
			int rearlength = array.length - 1 - front;
			// 뒷 부분 복사
			if (rearlength > 0) {
				System.arraycopy(array, front + 1, res, 0, rearlength);
			}
			// 앞 부분 복사
			System.arraycopy(array, 0, res, rearlength, rear + 1);
			return res;
		}
		// front가 rear보다 앞에 있는 경우 or 요소가 없을 경우 f == r
		if (front <= rear) {
			System.arraycopy(array, front + 1, a, 0, size);
		}
		// front가 rear보다 뒤에 있는 경우
		else {
			int rearlength = array.length - 1 - front;
			// 뒷 부분 복사
			if (rearlength > 0) {
				System.arraycopy(array, front + 1, a, 0, rearlength);
			}
			// 앞 부분 복사
			System.arraycopy(array, 0, a, rearlength, rear + 1);
		}
		
		return a;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
		front = rear = size = 0;

	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(E e) {
		if ((rear + 1) % array.length == front) {
			resize(array.length * 2); // 용적 가득차면 2배로 늘려준다.
		}
		rear = (rear + 1) % array.length;
		array[rear] = e;
		size++;

		return true;
	}

	@Override
	public E remove() {
		E item = poll();
		if (item == null) {
			throw new NoSuchElementException();
		}
		return item;
	}

	@Override
	public E poll() {
		if (size == 0) {// 삭제할게 없을때
			return null;
		}
		front = (front + 1) % array.length;// front를 한 칸 옮김

		@SuppressWarnings("unchecked")
		E item = (E) array[front]; // 반환할 데이터 임시 저장

		array[front] = null; // 해당 front의 데이터 삭제
		size--; // 사이즈 감소

		// 용적이 최소 크기(64)보다 크고 요소 개수가 1/4 미만일 경우
		if (array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
			// 아무리 작아도 최소용적 미만으로 줄이지 않는다.
			resize(Math.max(array.length / 2, DEFAULT_CAPACITY));
		}

		return item;
	}

	@Override
	public E element() {
		E item = peek();
		if (item == null) {
			throw new NoSuchElementException();
		}
		return item;
	}

	@Override
	public E peek() {
		// 요소가 없을 경우 null 반환
		if (size == 0) {
			return null;
		}

		@SuppressWarnings("unchecked")
		E item = (E) array[(front + 1) % array.length];
		return item;
	}

}
