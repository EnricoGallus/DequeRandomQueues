import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int counter = 0;
    private Item[] q;

    /**
     * construct an empty randomized queue
     */
    public RandomizedQueue() {
        q = (Item[]) new Object[0];
    }

    /**
     * is the queue empty?
     * @return
     */
    public boolean isEmpty() {
        return counter == 0;
    }

    /**
     * return the number of items on the queue
     * @return
     */
    public int size() {
        return counter;
    }

    /**
     * add the item
     * @param item
     */
    public void enqueue(Item item) {
        validateEnqueue(item);

        if (counter == q.length) {
            resize(q.length == 0 ? 1 : 2 * q.length);
        }

        q[counter++] = item;
    }

    /**
     * remove and return a random item
     * @return
     */
    public Item dequeue() {
        validateEmpty();

        int random = StdRandom.uniform(counter);

        Item item = q[random];
        q[random] = q[--counter];
        q[counter] = null;
        if (counter > 0 && counter == q.length/4) {
            resize(q.length/2);
        }

        return item;
    }

    /**
     * return (but do not remove) a random item
     * @return
     */
    public Item sample() {
        validateEmpty();

        Item item = null;
        while (item == null) {
            int random = StdRandom.uniform(counter);
            item = q[random];
        }

        return item;
    }

    /**
     * return an independent iterator over items in random order
     * @return
     */
    public Iterator<Item> iterator() {
        return new RandomizedIterator<Item>(q);
    }

    private class RandomizedIterator<Item> implements Iterator<Item> {
        private RandomizedQueue<Item> queue = new RandomizedQueue<Item>();

        public RandomizedIterator(Item[] q) {
            for (Item item : q) {
                if (item == null) {
                    break;
                }

                queue.enqueue(item);
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Item next() {
            if (queue.isEmpty()) {
                throw new NoSuchElementException();
            }
            return queue.dequeue();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        System.arraycopy(q, 0, copy, 0, Math.min(q.length, capacity));
        q = copy;
    }

    private void validateEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    private void validateEnqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    /**
     * unit testing (optional)
     * @param args
     */
    public static void main(String[] args) {

    }
}
