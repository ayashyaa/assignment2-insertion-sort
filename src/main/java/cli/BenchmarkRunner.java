package cli;

import algorithms.InsertionSort;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 5000, 10000, 20000};
        String[] types = {"Random", "Sorted", "Reverse", "NearlySorted"};
        Random random = new Random();

        try (FileWriter writer = new FileWriter("benchmark_results.csv")) {
            writer.write("InputSize,Type,TimeMs,Comparisons,Swaps\n");

            for (int n : sizes) {
                for (String type : types) {
                    int[] arr = new int[n];

                    switch (type) {
                        case "Random":
                            for (int i = 0; i < n; i++) arr[i] = random.nextInt(10000);
                            break;
                        case "Sorted":
                            for (int i = 0; i < n; i++) arr[i] = i;
                            break;
                        case "Reverse":
                            for (int i = 0; i < n; i++) arr[i] = n - i;
                            break;
                        case "NearlySorted":
                            for (int i = 0; i < n; i++) arr[i] = i;
                            for (int i = 0; i < n / 20; i++) {
                                int idx1 = random.nextInt(n);
                                int idx2 = random.nextInt(n);
                                int temp = arr[idx1];
                                arr[idx1] = arr[idx2];
                                arr[idx2] = temp;
                            }
                            break;
                    }

                    long start = System.nanoTime();
                    int[] metrics = InsertionSort.insertionSort(arr);
                    long end = System.nanoTime();

                    double timeMs = (end - start) / 1_000_000.0;
                    writer.write(n + "," + type + "," + timeMs + "," + metrics[0] + "," + metrics[1] + "\n");
                    System.out.printf("n=%d, Type=%s → Time=%.3fms, Comparisons=%d, Swaps=%d%n",
                            n, type, timeMs, metrics[0], metrics[1]);
                }
            }

            System.out.println("\n✅ Benchmark results saved to benchmark_results.csv");

        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }
}
