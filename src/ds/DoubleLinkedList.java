package ds;/*
WHAT? 
Double linked list implementation.
Refer:http://en.wikipedia.org/wiki/Linked_list

This LinkedList implementation taken from jdk  source code 
*/


public class DoubleLinkedList {

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

	public DoubleLinkedList() {
	}


	public void add(Object e) {

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

	private Object unlink(Node x) {
		final Object element = x.item;
		final Node next = x.next;
		final Node prev = x.prev;

		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
			x.prev = null;
		}

		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			x.next = null;
		}

		x.item = null;
		size--;
		return element;
	}


	void linkLast(Object e) {
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

	void linkBefore(Object e, Node succ) {
		final Node prev = succ.prev;
		final Node newNode = new Node(prev, e, succ);
		succ.prev = newNode;
		if (prev == null) {
			first = newNode;
		} else {
			prev.next = newNode;
		}
		size++;
	}

	public boolean remove(Object o) {
		if (o == null) {
			for (Node x = first; x != null; x = x.next) {
				if (x.item == null) {
					unlink(x);
					return true;
				}
			}
		} else {
			for (Node x = first; x != null; x = x.next) {
				if (o.equals(x.item)) {
					unlink(x);
					return true;
				}
			}
		}
		return false;
	}



	public void add(int index, Object element) {
		if( ! (index >= 0 && index <= size)) {
			throw new IndexOutOfBoundsException();
		}

		if (index == size) {
			linkLast(element);
		} else {
			linkBefore(element, node(index));
		}
	}

	public Object get(int index) {
		if( ! (index >= 0 && index <= size)) {
			throw new IndexOutOfBoundsException();
		}

		return node(index).item;
	}

	Node node(int index) {

		if (index < (size >> 1)) { // index < size/2 - iterate from left
			Node x = first;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			return x;
		} else { // index > size>2 interage from right
			Node x = last;
			for (int i = size - 1; i > index; i--) {
				x = x.prev;
			}
			return x;
		}
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

		DoubleLinkedList list = new DoubleLinkedList();

		list.add("one");
		list.add("two");
		System.out.println(list.size());
		list.printList();
	}

}
