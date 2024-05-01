package lisenZadanie2;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new CountingRunnable());
        thread.start();
    }

    static class CountingRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Число с задержкой в 1 секунду "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}