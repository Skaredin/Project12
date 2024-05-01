package lisenZadanie3;

public class MAin {
    public static void main(String[] args) {
        Thread evenThread = new Thread(new EvenNumbersRunnable());
        Thread oddThread = new Thread(new OddNumbersRunnable());

        evenThread.start();
        oddThread.start();
    }

    static class EvenNumbersRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Чётное число: " + i);
            }
        }
    }

    static class OddNumbersRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println("Не чётное число: " + i);
            }
        }
    }
}