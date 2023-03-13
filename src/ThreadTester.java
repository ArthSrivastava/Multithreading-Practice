public class ThreadTester {
    public static void main(String[] args) {
        System.out.println("Main starting");

//        Thread thread1 = new Thread1("thread1");
//        thread1.setDaemon(true);
//        thread1.start();

//        Thread thread2 = new Thread(new Thread2(), "thread2");
        //Or we can just pass the run method implementation
        //in the lambda
//        Thread thread2 = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("Inside " + Thread.currentThread() + " " + i);
//            }
//        }, "thread2");
//        thread2.start();
//        Stack stack = new Stack(5);
//        new Thread(() -> {
//            int counter = 0;
//            while (++counter < 10) {
//                System.out.println("Pushed: " + stack.push(100));
//            }
//        }, "Pusher").start();
//        new Thread(() -> {
//            int counter = 0;
//            while (++counter < 10) {
//                System.out.println("Popped: " + stack.pop());
//            }
//        }, "Popper").start();

        //Thread states
        /*
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1);
                for (int i = 10000; i >= 0; i--);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "States");
        thread.start();

        while (true) {
            Thread.State state = thread.getState();
            System.out.println(state);
            if (state == Thread.State.TERMINATED) break;
        }
        */

        //Implementation of deadlock in java code
        //Asked in Arcesium and Goldmann sachs

        String lock1 = "l1";
        String lock2 = "l2";
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Acquired lock thread1");
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Acquired lock thread2");
                }
            }
        });
        thread1.start(); thread2.start();
        System.out.println("Main exiting");
    }
}