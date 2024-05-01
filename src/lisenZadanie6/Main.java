package lisenZadanie6;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int sum = sumParallel(array);
        System.out.println("Сумма элементов: " + sum);
    }

    private static int sumParallel(int[] array) {
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(processors);

        try {
            int chunkSize = array.length / processors;
            int[] results = new int[processors];
            int startIndex = 0;

            for (int i = 0; i < processors; i++) {
                int endIndex = (i == processors - 1) ? array.length : startIndex + chunkSize;
                int[] chunk = new int[endIndex - startIndex];
                System.arraycopy(array, startIndex, chunk, 0, endIndex - startIndex);

                final int index = i;
                executor.submit(() -> {
                    int localSum = 0;
                    for (int num : chunk) {
                        localSum += num;
                    }
                    results[index] = localSum;
                });

                startIndex = endIndex;
            }

            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

            int totalSum = 0;
            for (int result : results) {
                totalSum += result;
            }
            return totalSum;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return Integer.MIN_VALUE;
        }
    }
}