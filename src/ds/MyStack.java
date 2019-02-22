package ds;/*
WHAT? 
Stack implementation using double  linked list 

Refer : http://en.wikipedia.org/wiki/Stack_%28abstract_data_type%29

This LinkedList implementation taken from jdk  source code 
*/


public class MyStack {

	private class Node {
		Object item;
		Node prev; // previous pointer
		Node next; // next pointer

		Node(Node prev, Object item, Node next) {
			this.prev = prev;
			this.item = item;
			this.next = next;
		}
	}


	int size;    // number of nodes in the list
	Node first; // head pointer
	Node last;  // tail pointer

	public MyStack() {
	}



	private void linkFirst(Object e) {
		final Node f = first;
		final Node newNode = new Node(null, e, f);
		first = newNode;
		if (f == null) {
			last = newNode;
		} else {
			f.prev = newNode;
		}
		size++;
	}

	private  Object unlinkFirst() {

		final Node f = first;
		if (f == null) {
			throw new NoSuchElementException();
		}

		final Object element = f.item;
		final Node next = f.next;
		f.item = null;
		f.next = null; 
		first = next;
		if (next == null) {
			last = null;
		} else{
			next.prev = null;
		}
		size--;
		return element;
	}


	public void push(Object e) {
		linkFirst(e);
	}

	public Object pop() {
		return unlinkFirst();
	}
					       

	public int size() {
		return size;
	}

	public void printStack() {
		Node ptr = first;
		while(ptr != null ) {
			System.out.println(ptr.item);
			ptr = ptr.next;
		}
	}


	public static class NoSuchElementException extends RuntimeException {

		public NoSuchElementException() {
			super();
		}
		public NoSuchElementException(String s) {
			super(s);
		}
	}



	public static void main(String[] args) {

		MyStack stack = new MyStack();

		stack.push("one");
		stack.push("two");
		System.out.println(stack.size());
		stack.printStack();
		System.out.println("pop: " + stack.pop());
	}

}
