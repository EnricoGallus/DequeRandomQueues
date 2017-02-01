import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int counter = 0;

    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }

    /**
     * construct an empty deque
     */
    public Deque() {
    }

    /**
     * is the deque empty?
     * @return
     */
    public boolean isEmpty() {
        return counter == 0;
    }

    /**
     * return the number of items on the deque
     * @return
     */
    public int size() {
        return counter;
    }

    /**
     * add the item to the front
     * @param item
     */
    public void addFirst(Item item) {
        validateAdd(item);
        counter++;

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.previous = null;
        if (oldFirst != null) {
            oldFirst.previous = first;
        }

        if (counter <= 1) {
            last = first;
        }
    }

    /**
     * add the item to the end
     * @param item
     */
    public void addLast(Item item) {
        validateAdd(item);
        counter++;

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.previous = oldLast;
        if (oldLast != null) {
            oldLast.next = last;
        }

        if (counter <= 1) {
            first = last;
        }
    }

    /**
     * remove and return the item from the front
     * @return
     */
    public Item removeFirst() {
        validateRemove();
        counter--;

        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = first;
        }
        else {
            first.previous = null;
        }

        return item;
    }

    /**
     * remove and return the item from the end
     * @return
     */
    public Item removeLast() {
        validateRemove();
        counter--;

        Item item = last.item;
        last = last.previous;
        if (isEmpty()) {
            first = last;
        }
        else {
            last.next = null;
        }

        return item;
    }

    /**
     * return an iterator over items in order from front to end
     * @return
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException(); }
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }

            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private void validateAdd(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    private void validateRemove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    /**
     * unit testing (optional)
     * @param args
     */
    public static void main(String[] args) {

    }
}