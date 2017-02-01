import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DequeTest {

    @Test
    public void TestEmptyDeque() {
        Deque<String> deque = new Deque<>();

        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void TestAddFirstAndRemoveFirst() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("something");

        assertEquals(1, deque.size());
        assertFalse(deque.isEmpty());

        String item = deque.removeFirst();

        assertEquals("something", item);
        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void TestNonEmptyToEmptyToNonEmpty() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("something");
        deque.addLast("last");
        deque.removeFirst();
        deque.removeFirst();
        deque.addLast("newElement");

        assertEquals(1, deque.size());
        assertEquals("newElement", deque.removeFirst());
    }

    @Test
    public void DifferentCombinations() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("firstOfAll");
        deque.addLast("previous");
        deque.addFirst("first");
        deque.addLast("secondLast");
        deque.addLast("thirdLast");
        String first = deque.removeFirst();
        String secondFirst = deque.removeFirst();
        String thirdFirst = deque.removeFirst();

        assertEquals(2, deque.size());
        assertFalse(deque.isEmpty());

        assertEquals("first", first);
        assertEquals("firstOfAll", secondFirst);
        assertEquals("previous", thirdFirst);
    }

    @Test
    public void Iterator() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("firstOfAll");
        deque.addLast("previous");
        deque.addFirst("first");
        deque.addLast("secondLast");
        deque.addLast("thirdLast");

        int counter = 0;
        for(String item : deque) {
            counter++;
        }

        assertEquals(5, counter);
    }

    @Test
    public void PushFirstPopLast() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("first");
        deque.addFirst("second");
        deque.addFirst("third");
        deque.addFirst("four");
        deque.addFirst("five");

        assertEquals("first", deque.removeLast());
        assertEquals("second", deque.removeLast());
        assertEquals("third", deque.removeLast());
        assertEquals("four", deque.removeLast());
        assertEquals("five", deque.removeLast());

        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void FailingTestRemveLastSeveralTimes() {
        Deque<Integer> deque = new Deque<>();
        deque.isEmpty();
        deque.isEmpty();
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        assertEquals(4, (int)deque.removeLast());
        assertEquals(3, (int)deque.removeLast());
    }

    @Test
    public void FailingTestRemveFirstSeveralTimes() {
        Deque<Integer> deque = new Deque<>();
        deque.isEmpty();
        deque.isEmpty();
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        assertEquals(2, (int)deque.removeFirst());
        assertEquals(3, (int)deque.removeFirst());
    }
}
