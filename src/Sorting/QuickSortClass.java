package Sorting;

import java.util.Arrays;

public class QuickSortClass {
    public static void main(String[] args) {
        int[] testArr = {7,1,5,3,8,3,10,9,8,4,2,6};
        quickSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    // O(N*logN)
    private static void quickSort(int[] array) {
        recursionQuickSort(array, 0, array.length - 1);
    }

    private static void recursionQuickSort(int[] array, int leftBorder, int rightBorder) {
        System.out.println("Sort " + leftBorder + ".." + rightBorder);
        if (array.length == 0) // условие выхода из рекурсии, если длина массива равна 0
            return;

        if (leftBorder >= rightBorder) //выходим, так как нечего уже делить
            return;

        int middleElement = array[(leftBorder + rightBorder) / 2]; // выбираем середину

        System.out.println("middle element: " + middleElement);
        System.out.println("before sort: " + Arrays.toString(array));

        int leftMarker = leftBorder, rightMarker = rightBorder;
        while (leftMarker <= rightMarker) {  // относительно элемента middle определяем меньшие элементы слева, большие справа
            while (array[leftMarker] < middleElement) {
                leftMarker++;
            }
            while (array[rightMarker] > middleElement) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {      //меняем местами
                int temp = array[leftMarker];
                array[leftMarker] = array[rightMarker];
                array[rightMarker] = temp;
                leftMarker++;
                rightMarker--;
            }
        }

        System.out.println("after sort:  " + Arrays.toString(array));

        if (leftBorder < rightMarker) // запускаем рекурсию с элементами меньшими чем middle
            recursionQuickSort(array, leftBorder, rightMarker);

        if (rightBorder > leftMarker) // запускаем рекурсию с элементами большими чем middle
            recursionQuickSort(array, leftMarker, rightBorder);
    }
}
