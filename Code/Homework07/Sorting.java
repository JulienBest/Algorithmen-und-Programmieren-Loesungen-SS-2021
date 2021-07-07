package Homework_07;


public class Sorting {

    public static void print(int[] numbers) {
        for (int i : numbers) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    
    public static void bubbleSort(int[] numbers) {
        int temp;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 1; j < (numbers.length - i); j++) {
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
            // Kleinstes Element finden
            int min_idx = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[min_idx] > numbers[j]) {
                    min_idx = j;
                }
            }
            // Kleinstes Element mit dem ersten unsortierten Element tauschen
            int temp = numbers[i];
            numbers[i] = numbers[min_idx];
            numbers[min_idx] = temp;
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


    public static int[] getRandomArray() {
        int[] testArr = new int[10];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = (int)(Math.random() * 100);
        }
        return testArr;
    }


    public static void main(String[] args) {
        System.out.println("\nBubble Sort Test:");
        int[] testArr = getRandomArray();
        print(testArr);
        bubbleSort(testArr);
        print(testArr);

        System.out.println("\nSelection Sort Test:");
        testArr = getRandomArray();
        print(testArr);
        selectionSort(testArr);
        print(testArr);

        System.out.println("\nInsertion Sort Test:");
        testArr = getRandomArray();
        print(testArr);
        insertionSort(testArr);
        print(testArr);
    }

}
