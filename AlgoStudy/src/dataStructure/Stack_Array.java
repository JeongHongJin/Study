package dataStructure;

public class Stack_Array {
	int top;
	int size;
	int[] stack;

	public Stack_Array(int size) {
		this.size = size;
		stack = new int[size];
		top = -1;
	}

	public void push(int item) {
		stack[++top] = item;
		System.out.println(stack[top] + " Push");
	}

	public void pop() {
		if (size == 0) {
			return;
		}
		int pop = stack[top];
		System.out.println(pop + " Pop");
		stack[top--] = 0;
	}

	public void peek() {
		if (size == 0) {
			return;
		}
		System.out.println(stack[top]);
	}
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
}
