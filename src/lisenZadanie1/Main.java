package lisenZadanie1;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable(), "Поток 1");
        Thread thread2 = new Thread(new MyRunnable(), "Поток 2");

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
        thread2.interrupt();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + ": " + java.time.LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
