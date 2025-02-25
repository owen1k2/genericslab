package edu.grinnell.csc207.genericslab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LinkedListTests {
    @Test
    public void emptyListTest() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        assertEquals(0, l.size());
    }

    @Test
    public void listAddSize10NumsAsStrings() {
        LinkedList<String> l = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            l.add(Integer.toString(i));
        }
        assertEquals(10, l.size());
    }

    @Test
    public void listGetSeveral() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        int[] elements = new int[] {3, 8, 7, 2, 6, 5, 0};
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
        }
    }

    @Test
    public void listGetOOB() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(3);
        l.add(2);
        l.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(3);
        });
    }

    @Test
    public void listRemoveSome() {
        LinkedList<String> l = new LinkedList<String>();
        l.add("!");
        l.add("@");
        l.add(".");
        l.add("#");
        l.add("&");

        // @ #
        
        assertEquals(".", l.remove(2));
        assertEquals("@", l.get(1));
        assertEquals("#", l.get(2));
        
        assertEquals("!", l.remove(0));
        assertEquals("@", l.get(0));

        assertEquals("&", l.remove(2));
        assertEquals("#", l.get(1));
    }

    @Test
    public void listRemoveOOB() {
        LinkedList<String> l = new LinkedList<String>();
        l.add("A");
        l.add("B");
        l.add("C");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(3);
        });
    }

}

