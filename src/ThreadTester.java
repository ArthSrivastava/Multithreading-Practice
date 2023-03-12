public class ThreadTester {
    public static void main(String[] args) {
        System.out.println("Main starting");

        Thread thread1 = new Thread1("thread1");
//        thread1.setDaemon(true);
        thread1.start();

//        Thread thread2 = new Thread(new Thread2(), "thread2");
        //Or we can just pass the run method implementation
        //in the lambda
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Inside " + Thread.currentThread() + " " + i);
            }
        }, "thread2");
        thread2.start();


        System.out.println("Main exiting");
    }
}