import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    /**
     * construct an empty randomized queue
     */
    public RandomizedQueue() {

    }

    /**
     * is the queue empty?
     * @return
     */
    public boolean isEmpty() {
        throw new NotImplementedException();
    }

    /**
     * return the number of items on the queue
     * @return
     */
    public int size() {
        throw new NotImplementedException();
    }

    /**
     * add the item
     * @param item
     */
    public void enqueue(Item item) {
        throw new NotImplementedException();
    }

    /**
     * remove and return a random item
     * @return
     */
    public Item dequeue() {
        throw new NotImplementedException();
    }

    /**
     * return (but do not remove) a random item
     * @return
     */
    public Item sample() {
        throw new NotImplementedException();
    }

    /**
     * return an independent iterator over items in random order
     * @return
     */
    public Iterator<Item> iterator() {
        throw new NotImplementedException();
    }

    /**
     * unit testing (optional)
     * @param args
     */
    public static void main(String[] args) {

    }
}
