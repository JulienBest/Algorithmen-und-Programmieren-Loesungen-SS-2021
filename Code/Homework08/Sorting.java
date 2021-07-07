package Homework_08;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Sorting {

    public static void ausgabe(int[] numbers) {

        System.out.println("Array mit groesse: " + numbers.length);
        for (int i : numbers) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] numbers) {
        int temp;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = numbers.length - 1; j > i; j--) {
                if (numbers[j - 1] > numbers[j]) {
                    temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int target = numbers[i];
            int j;
            for (j = i - 1; (j >= 0) && (numbers[j] > target); j--) {
                numbers[j + 1] = numbers[j];
            }
            numbers[j + 1] = target;
        }
    }

    public static void merge(int[] a, int left, int m, int right) {
        int[] b = new int[a.length]; // auxilary array
        for (int i = left; i <= right; i++) {
            b[i] = a[i];
        }
        int i = left;
        int j = m + 1;
        int k = left;
        while (i <= m && (j) <= right) {
            // wenn kein tausch statt findet wird i erhoeht
            if (b[i] <= b[j]) {
                a[k] = b[i];
                i++;
            } else // wenn tausch stattfinden wird j erhoeht
            {
                a[k] = b[j];
                j++;
            }
            // k wird immer erhöht, laeuft einmal durchs array
            k++;
        }

        // rest zurueck kopieren
        while (i <= m) {
            a[k] = b[i];
            k++;
            i++;
        }
    }

    public static void mergeSortHelper(int[] numbers, int left, int right) {
        if (left < right) {
            int m = (left + right) / 2;
            // pro mergesort -> 2x mergesort + 1x merge = Mergelawine
            mergeSortHelper(numbers, left, m);
            mergeSortHelper(numbers, m + 1, right);
            merge(numbers, left, m, right);
        }
    }

    public static void mergeSort(int[] numbers) {
        mergeSortHelper(numbers, 0, numbers.length - 1);
    }

    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void quickSort(int[] numbers) {
        quickSortHelper(numbers, 0, numbers.length - 1);
    }

    public static void quickSortHelper(int[] numbers, int left, int right) {
        if (left < right) {
            int midpoint = partition(numbers, left, right);
            quickSortHelper(numbers, left, midpoint - 1);
            quickSortHelper(numbers, midpoint + 1, right);
        }
    }

    public static int partition(int[] numbers, int left, int right) {
        int pivot = numbers[right];
        int border = left;
        for (int i = left; i < right; i++) {
            if (numbers[i] <= pivot) {
                swap(numbers, border, i);
                border++;
            }
        }
        swap(numbers, border, right);
        return border;
    }

    public static void main(String[] args) {

        int number_of_arrays = 100; // number of arrays
        int step_size = 200; // step width

        // initialize arrays
        int[][] arrays_copy1 = new int[number_of_arrays][];
        int[][] arrays_copy2 = new int[number_of_arrays][];
        int[][] arrays_copy3 = new int[number_of_arrays][];
        int[][] arrays_copy4 = new int[number_of_arrays][];
        int[][] arrays_copy5 = new int[number_of_arrays][];
        for (int i = 0; i < number_of_arrays; i++) {
            arrays_copy1[i] = new int[step_size * i];
            arrays_copy2[i] = new int[step_size * i];
            arrays_copy3[i] = new int[step_size * i];
            arrays_copy4[i] = new int[step_size * i];
            arrays_copy5[i] = new int[step_size * i];
            for (int j = 0; j < step_size * i; j++) {
                int value = (int) (Math.random() * 100);
                arrays_copy1[i][j] = value;
                arrays_copy2[i][j] = value;
                arrays_copy3[i][j] = value;
                arrays_copy4[i][j] = value;
                arrays_copy5[i][j] = value;
            }
        }

        try {
            FileWriter fstream = new FileWriter("algorithm.csv");
            BufferedWriter out = new BufferedWriter(fstream);

            ausgabe(arrays_copy1[1]);
            quickSort(arrays_copy1[1]);
            ausgabe(arrays_copy1[1]);

            for (int i = 0; i < number_of_arrays; i++) {

                long start_1 = System.currentTimeMillis();
                bubbleSort(arrays_copy1[i]);
                long end_1 = System.currentTimeMillis();
                long timeBubbleSort = end_1 - start_1;

                long start_2 = System.currentTimeMillis();
                selectionSort(arrays_copy2[i]);
                long end_2 = System.currentTimeMillis();
                long timeSelectionSort = end_2 - start_2;

                long start_3 = System.currentTimeMillis();
                insertionSort(arrays_copy3[i]);
                long end_3 = System.currentTimeMillis();
                long timeInsertionSort = end_3 - start_3;

                long start_4 = System.currentTimeMillis();
                mergeSort(arrays_copy4[i]);
                long end_4 = System.currentTimeMillis();
                long timeMergeSort = end_4 - start_4;

                long start_5 = System.currentTimeMillis();
                quickSort(arrays_copy5[i]);
                long end_5 = System.currentTimeMillis();
                long timeQuicksort = end_5 - start_5;

                out.write(arrays_copy1[i].length + "," + timeBubbleSort + "," + timeSelectionSort + ","
                        + timeInsertionSort + "," + timeMergeSort + "," + timeQuicksort);
                out.newLine();

                System.out.println(arrays_copy1[i].length + "\t" + timeBubbleSort + "\t" + timeSelectionSort + "\t"
                        + timeInsertionSort + "\t" + timeMergeSort + "\t" + timeQuicksort);
            }

            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
