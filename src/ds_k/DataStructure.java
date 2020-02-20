package ds_k;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class DataStructure {
    public static void main(String[] args) {

        List list = new ArrayList<>();
        Stack stack = new Stack();
        Queue queue = new ArrayDeque();


        LinkedList linkedList = new LinkedList();

        HashSet hashSet =  new HashSet();
        HashMap hashMap =  new HashMap();
        Hashtable hashtable = new Hashtable();


        TreeSet treeSet = new TreeSet();
        TreeMap treeMap = new TreeMap();


        Tree tree = new Tree() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };

    }
}
