package algorithms;

public class InsertionSort {

    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int swaps = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    swaps++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }

        return new int[]{comparisons, swaps};
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};
        int[] metrics = insertionSort(arr);
        System.out.println("Comparisons: " + metrics[0]);
        System.out.println("Swaps: " + metrics[1]);
        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
