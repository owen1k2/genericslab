package edu.grinnell.csc207.genericslab;

public class LinkedList<T> {
    private class Node {
        public T value;
        public Node next;
        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node first;


    /**
     * Constructs a new, empty linked list.
     */
    public LinkedList() {
        this.first = null;
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(T value) {
        if (first == null) {
            first = new Node(value, null);
        } else {
            Node cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(value, null);
        }
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        int sz = 0;
        Node cur = first;
        while (cur != null) {
            sz += 1;
            cur = cur.next;
        }
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        int origIndex = index;
        Node cur = first;
        while (index > 0 && cur != null) {
            index -= 1;
            cur = cur.next;
        }
        if (cur == null) {
            throw new IndexOutOfBoundsException(origIndex);
        } else {
            return cur.value;
        }
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public T remove(int index) {
        if (index < 0 || (index == 0 && first == null)) {
            throw new IndexOutOfBoundsException(index);
        } else if (index == 0) {
            T ret = first.value;
            first = first.next;
            return ret;
        } else {
            int origIndex = index;
            Node cur = first;
            while (index > 1 && cur.next != null) {
                index -= 1;
                cur = cur.next;
            }
            if (cur.next == null) {
                throw new IndexOutOfBoundsException(origIndex);
            } else {
                T ret = cur.next.value;
                cur.next = cur.next.next;
                return ret;
            }
        }
    }

    /**
     * Adds an element between each element of the LinkedList.
     * 
     * @param sep the element being added
     */
    public void intersperse(T sep) {
        Node temp = first;

        while(temp.next != null) {
            Node add = temp;
            add.value = sep;
            temp.next = add;
            temp = temp.next.next;
        }
    }

    /**
     * NOTE: There is no reason to implement this function
     * because we have no idea what type will be replacing T. As such
     * we have no idea if there will be any logical maximum.
     * Finds the maximum element of the linked list
     * 
     * @return T the maximum element of the linked list.
     */
    public T maximum() {
        throw new UnsupportedOperationException();
    }


    /**
     * NOTE: There is no reason to implement this function because
     * we have no idea what the object to be converted to a
     * String will be.
     * 
     * @return String s, the string representation of the list
     */
    public String toString() {
        throw new UnsupportedOperationException();
    }


    /**
     * NOTE: Like `maximum()`, there is no reason to implement 
     * this function because we have no idea what type will be 
     * replacing T, so we have no idea how the elements would
     * be sorted.
     */
    public void insertionSort() {
        throw new UnsupportedOperationException();
    }
}