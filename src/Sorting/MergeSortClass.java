package Sorting;

import java.util.Arrays;

public class MergeSortClass {
    public static void main(String[] args) {
        int[] testArr = {7, 1, 5, 3, 8, 3, 10, 9, 8, 4, 2, 6};
        mergeSort(testArr);
        System.out.println(Arrays.toString(testArr));

    }

    // O(N*logN)
    private static void mergeSort(int[] array) {
        recursionMergeSort(array, 0, array.length - 1);
    }

    private static void recursionMergeSort(int[] array, int start, int finish) {
        System.out.println("Sort " + start + ".." + finish);

        if (array.length == 0)
            return;

        if (start == finish) // выход из рекурсии - массив из 1 элемента отсортирован по определению
            return;

        int mid = (start + finish) / 2; // середина массива

        recursionMergeSort(array, start  , mid);    // сортировка 1-й половины массива
        recursionMergeSort(array,mid + 1, finish); // сортировка 2-й половины массива
        merge(array, start, finish);
    }

    private static void merge(int[] array, int begin, int end) {
        int mid = (begin + end) / 2;

        int[] tmp = new int[end - begin + 1];

        int leftMarker = begin;

        int rightMarker = mid + 1;

        int cursor = 0;

        while ((leftMarker <= mid) || (rightMarker <= end)) {
            if (leftMarker > mid) {                     //если левый массив полностью записан
                tmp[cursor++] = array[rightMarker++];   //записываем остаток правого массива
                continue;                               //возвращаемся в цикл
            }
            if (rightMarker > end) {                    //если правый массив полностью записан
                tmp[cursor++] = array[leftMarker++];    //записываем остаток левого массива
                continue;                               //возвращаемся в цикл
            }
            if (array[leftMarker] < array[rightMarker]) {   //сравниваем элементы левого и правого массива
                tmp[cursor++] = array[leftMarker++];        //и записываем наименьший во временный массив
            } else {
                tmp[cursor++] = array[rightMarker++];
            }
        }
        System.arraycopy(tmp, 0, array, begin, end - begin + 1);
        System.out.println(Arrays.toString(tmp));
    }
}