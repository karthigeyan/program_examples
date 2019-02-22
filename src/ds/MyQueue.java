package ds;/*
Queue implementation using double linked list implementation.
Refer: http://en.wikipedia.org/wiki/Queue_%28abstract_data_type%29
This LinkedList implementation taken from jdk  source code 
*/


public class MyQueue {

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

	public MyQueue() {
	}


   // removes the first element and returns it
	public Object dequeue() {
		final Node f = first;
		return (f == null) ? null : unlinkFirst(f);
	}

	//retrieves, but it does not remove
	public Object peek() {
		final Node f = first;
		return (f == null) ? null : f.item;
	}

	// adds  element  at the end of the list
	public void enqueue(Object e) {
		add(e);
	}

	private Object unlinkFirst(Node f) {
		final Object element = f.item;
		final Node  next = f.next;
		f.item = null;
		f.next = null; 
		first = next;
		if (next == null) {
			last = null;
		} else {
			next.prev = null;
		}
		size--;
		return element;
	}


	private  void add(Object e) {

		final Node l = last;
		final Node newNode = new Node(l, e, null);
		last = newNode;
		if (l == null) {
			first = newNode;
		} else {
			l.next = newNode;
		}
		size++;
	}


	public int size() {
		return size;
	}

	public void printQueue() {
		Node ptr = first;
		while(ptr != null ) {
			System.out.println(ptr.item);
			ptr = ptr.next;
		}
	}



	public static void main(String[] args) {

		MyQueue queue = new MyQueue();

		queue.enqueue("one");
		queue.enqueue("two");
		System.out.println(queue.size());
		queue.printQueue();
		System.out.println("Deque : " + queue.dequeue());
	}

}
