package lisenZadanie4;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(new MyRunnable(i));
            thread.start();
        }
    }

    static class MyRunnable implements Runnable {
        private final int threadNumber;

        public MyRunnable(int threadNumber) {
            this.threadNumber = threadNumber;
        }

        @Override
        public void run() {
            String colorCode = "\u001B[" + (threadNumber % 8 + 30) + "m"; // Для себя выбираем цвет в диапазоне от 30 до 37
            System.out.println(colorCode + "Поток " + threadNumber);
        }
    }
}