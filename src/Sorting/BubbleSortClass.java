package Sorting;

import java.util.Arrays;

public class BubbleSortClass {
    public static void main(String[] args) {
        int[] testArr = {7,1,5,3,8,3,10,9,8,4,2,6};
        bubbleSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

// O(n^2) -> очень медленно
    private static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
