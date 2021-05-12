package BinarySearch;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] testArr = {7,1,5,3,8,3,10,9,8,4,2,6};
        Arrays.sort(testArr);
        System.out.println(binarySearch(testArr, 7));
        System.out.println(binaryRecursionSearch(testArr, 4, 0, testArr.length - 1));
    }

    // O(logN)
    // Работает только на отсортированном массиве
    public static int binarySearch(int[] sortedArray, int key) {
        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (key < sortedArray[middle]) {
                high = middle - 1;
            } else if (key > sortedArray[middle]) {
                low = middle + 1;
            } else return middle;
        }

        return -1; //key не найден
    }

    public static int binaryRecursionSearch(int[] sortedArray, int key, int low, int high) {
        if (low > high)
            return -1;

        int middle = low + (high - low) / 2;

        if (key > sortedArray[middle]) {
            return binaryRecursionSearch(sortedArray, key, middle + 1, high);
        } else if (key < sortedArray[middle]) {
            return binaryRecursionSearch(sortedArray, key, low, middle - 1);
        } else {
            return middle;
        }
    }
}
