package ds;

/**
Hashtable implementation.

Source code taken from jdk src Hashtable.java

*/

public class MyHashtable {

	private class Entry  {
		int hash;
		Object key;
		Object value;
		Entry next;

		protected Entry(int hash, Object key, Object value, Entry next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}


	 private Entry[] table;
	 private int count;

	 public MyHashtable(int capacity) {
		 this.table = new Entry[capacity];
	 }

	 public MyHashtable() {
		 this(10);
	 }

	 public Object put(Object key, Object value) {
		 // Make sure the value is not null
		 if (value == null) {
			 throw new NullPointerException();
		 }

		 // Makes sure the key is not already in the hashtable.
		 Entry tab[] = table;
		 int hash = key.hashCode();
		 int index = (hash & 0x7FFFFFFF) % tab.length;

		 for (Entry e = tab[index] ; e != null ; e = e.next) {
			 if ((e.hash == hash) && e.key.equals(key)) { // if key is already there, then replace it with new value
				 Object old = e.value;
				 e.value = value;
				 return old;
			 }
		 }

	
		 // Creates the new entry.
		 Entry e = tab[index];
		 tab[index] = new Entry(hash, key, value, e);
		 count++;
		 return null;
	 }


	 public Object get(Object key) {
		 Entry tab[] = table;
		 int hash = key.hashCode();
		 int index = (hash & 0x7FFFFFFF) % tab.length;
		 for (Entry e = tab[index] ; e != null ; e = e.next) {
			 if ((e.hash == hash) && e.key.equals(key)) {
				 return e.value;
			 }
		 }
		 return null;
	 }

	 public Object remove(Object key) {
		 Entry tab[] = table;
		 int hash = key.hashCode();
		 int index = (hash & 0x7FFFFFFF) % tab.length;

		 for (Entry e = tab[index], prev = null ; e != null ; prev = e, e = e.next) {
			 if ((e.hash == hash) && e.key.equals(key)) {
				 if (prev != null) {
					 prev.next = e.next;
				 } else {
					 tab[index] = e.next;
				 }
				 count--;
				 Object oldValue = e.value;
				 e.value = null;
				 return oldValue;
			 }
		 }
		 return null;
	 }

	 public int length(){
	 	return this.count;
	 }



	public static void main(String[] args) {

		MyHashtable htable = new MyHashtable();

		htable.put("1", "ONE");
		htable.put("2", "TWO");
		htable.put("2", "TWO");
		htable.put("2", "TWO");

		System.out.println(htable.length());
		System.out.println(htable.get("1"));

	}

}
