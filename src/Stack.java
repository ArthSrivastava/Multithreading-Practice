public class Stack {
    private int[] arr;
    private int stackTop;
    private final Object lock;
    public Stack(int capacity) {
        arr = new int[capacity];
        stackTop = -1;
        lock = new Object();
    }

    public boolean isFull() {
        return stackTop == arr.length - 1;
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean push(int element) {
        synchronized (lock) {
            if (isFull()) {
                return false;
            }
            ++stackTop;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            arr[stackTop] = element;
            return true;
        }
    }

    public int pop() {
        synchronized (lock) {     //we can also declare the method as synchronized
                                 // then 'this' will be used as the lock as the lock
                                // can be any object
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int obj = arr[stackTop];
            arr[stackTop] = Integer.MIN_VALUE;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            --stackTop;
            return obj;
        }
    }
}
