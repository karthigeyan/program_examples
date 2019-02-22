package ds;

/**
WHAT? 
Stack implementation using array

Refer : http://en.wikipedia.org/wiki/Stack_%28abstract_data_type%29

*/


public class ArrayStack {

	int top = -1;
	Object[] elements;

	public ArrayStack(int size) {
		top = -1;
		elements = new Object[size];
	}

	public void push(Object e ) {
		if( top == elements.length -1 ) {
			throw new RuntimeException("Stack is full");
		}else {
			elements[++top] = e;
		}
	}

	public Object pop() {
		if( top < 0 ) {
			throw new RuntimeException("Stack is empty");
		} else {
			return elements[top--];
		}
	}

	public Object peek() {
		if( top < 0 ) {
			throw new RuntimeException("Stack is empty");
		} else {
			return elements[top];
		}
	}

	public void printStack() {
		for(int i=top; i>=0; i--) {
			System.out.println(elements[i]);
		}
	}


	public static void main(String[] args) {

		ArrayStack stack = new ArrayStack(4);

		stack.push("one");
		stack.push("two");
		stack.printStack();
		System.out.println("pop : " + stack.pop());

	}
}


