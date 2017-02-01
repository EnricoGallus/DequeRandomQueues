import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomizedQueueTest {

    @Test
    public void Empty() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        assertEquals(0, queue.size());
    }

    @Test
    public void FillAsMuch() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void FailingDeque() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(2);
        rq.enqueue(1);
        rq.dequeue();

        assertEquals(1, rq.size());
    }

    @Test
    public void FailingRandom() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(348);
        rq.enqueue(227);
        rq.enqueue(100);
        assertFalse(rq.isEmpty());
        rq.enqueue(204);
        rq.enqueue(312);
        rq.enqueue(333);
        rq.enqueue(274);
        assertEquals(7, rq.size());
        rq.enqueue(183);
        rq.dequeue();
        assertEquals(7, rq.size());
    }
}
