package Sorting;

import java.util.Arrays;

public class SelectionSortClass {
    public static void main(String[] args) {
        int[] testArr = {7,1,5,3,8,3,10,9,8,4,2,6};
        sortBySelect(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    /*
    несколько быстрее пузырьковой, т.к. мы не гоняем один элемент через весь список,
    кол-во перестановок сокращается с O(n^2) до O(n), но кол-во сравнений остается O(n^2)
     */
    private static void sortBySelect(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) { //отсчет с сортированных чисел
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            int temp = array[i];     // вставка отсортированного числа, в положеную ему ячейку
            array[i] = array[min];
            array[min] = temp;
        }
    }
}
