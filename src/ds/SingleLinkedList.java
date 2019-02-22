package ds;/*
Single linked list implementation.
Refer:http://en.wikipedia.org/wiki/Linked_list

This LinkedList implementation taken from jdk  source code 
*/


public class SingleLinkedList {

	private class Node {
		Object item;
		Node next;

		Node(Object item, Node next) {
			this.item = item;
			this.next = next;
		}
	}


	int size;    // number of nodes in the list
	Node first; // head pointer
	Node last;  // tail pointer

	public SingleLinkedList() {
	}

	public Object getFirst() {
		final Node f = first;
		if (f == null)
			throw new NoSuchElementException();
		return f.item;
	}

	public Object getLast() {
		final Node l = last;
		if (l == null) {
			throw new NoSuchElementException();
		}
		return l.item;
	}

	public void addFirst(Object e) {

		final Node f = first;
		final Node newNode = new Node(e, f);
		first = newNode;
		if (f == null) {
			last = newNode;
		}
		size++;
	}

	public void addLast(Object e) {

		final Node l = last;
		final Node newNode = new Node(e, null);
		last = newNode;
		if (l == null) {
			first = newNode;
		} else {
			l.next = newNode;
		}
		size++;
	}

	public boolean add(Object e) {
		addLast(e);
		return true;
	}



	public Object removeFirst() {
		final Node f = first;
		if (f == null) {
			throw new NoSuchElementException();
		}

		final Object element = f.item;
		final Node next = f.next;
		//unlink the first element
		f.item = null;
		f.next = null; 
		//move head pointer to the next element
		first = next;
		if (next == null) {
			last = null;
		} 
		size--;
		return element;
	}

	public Object removeLast() {
		final Node l = last;
		if (l == null) {
			throw new NoSuchElementException();
		}

		final Object element = l.item;
		l.item = null;

		// finds previous element of the last element
		// since it is single linkedlist , there is no prev pointer, so whole list should be 
		// iterated from the first.
		Node prev = null;
		Node ptr = first;
		while(ptr.next != null ) {
			prev = ptr;
			ptr = ptr.next;
		}

		//move tail pointer to the previous node 
		last = prev;
		if (prev == null) {
			first = null;
		} else {
			prev.next = null;
		}
		size--;
		return element;
	}
	


	public int size() {
		return size;
	}

	public void printList() {
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

		SingleLinkedList list = new SingleLinkedList();

		list.add("one");
		list.add("two");
		System.out.println(list.size());
		list.printList();
	}

}
