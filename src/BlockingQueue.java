import java.util.LinkedList;
import java.util.Queue;


//Producer-Consumer implementation
public class BlockingQueue {
    private final Queue<Integer> queue;
    private final int capacity;

    public BlockingQueue(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public boolean add(int element) {

        //while is very important instead of if as what if two adder threads wants
        //to add
        while (queue.size() == capacity) {
            synchronized (queue) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        queue.offer(element);
        queue.notifyAll();
        return true;
    }

    public int remove() {
        while (queue.size() == 0) {
            synchronized (queue) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        int element = queue.poll();
        queue.notifyAll();
        return element;
    }
}
