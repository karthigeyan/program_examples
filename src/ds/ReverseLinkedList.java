package ds;/*
What?
Reverses the given single linked list .
Refer:http://en.wikipedia.org/wiki/Linked_list

HOW?

*/


public class ReverseLinkedList {

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

	public ReverseLinkedList() {
	}

	//reverses the list in single iteration.
	public void reverseList() {
		Node prevNode;
		Node tempNode;
		Node nextNode;
		
		nextNode = first.next;
		first.next = null;
		prevNode = first;

		while( nextNode != null  ) {
			tempNode = nextNode;
			nextNode = nextNode.next;
			tempNode.next =  prevNode;
			prevNode = tempNode;
		}

		first = prevNode;
		last  = first;
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



	public static void main(String[] args) {

		ReverseLinkedList list = new ReverseLinkedList();

		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list.size());
		list.printList();
		list.reverseList();
		list.printList();
	}

}
