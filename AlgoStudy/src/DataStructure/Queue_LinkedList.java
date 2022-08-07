package DataStructure;

//출처: https://st-lab.tistory.com/184?category=856997
public class Queue_LinkedList<E> {
	private qNode<E> head;
	private qNode<E> tail;
	private int size = 0;

	public Queue_LinkedList() {
		this.head = null;
		this.tail = null;
	}

	public boolean offer(E value) {
		qNode<E> newqNode = new qNode<E>(value);
		if (size == 0) {
			head = newqNode;
		} else {
			tail.next = newqNode;
		}
		tail = newqNode;
		size++;
		return true;
	}

	public E poll() {
		if (size == 0) {
			return null;
		}

		E element = head.data;
		qNode<E> nextqNode = head.next;

		head.data = null;
		head.next = null;

		head = nextqNode;
		size--;
		return element;
	}

	public E peek() {
		if (size == 0) {
			return null;
		}
		return head.data;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object value) {
		for (qNode<E> x = head; x != null; x = x.next) {
			if (value.equals(x.data)) {
				return true;
			}
		}
		return false;
	}

	public void clear() {
		for (qNode<E> x = head; x != null;) {
			qNode<E> next = x.next;
			x.data = null;
			x.next = null;
			x = next;
		}
		size = 0;
		head = tail = null;
	}
}

class qNode<E> {

	E data;
	qNode<E> next;

	qNode(E data) {
		this.data = data;
		this.next = null;
	}
}