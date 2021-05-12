package Sorting;

import java.util.Arrays;

public class InsertionSortClass {
    public static void main(String[] args) {
        int[] testArr = {7,1,5,3,8,3,10,9,8,4,2,6};
        insertionSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    /*
    работает вдвое быстрее пузырьковой и немного быстрее сортировки выбором,
    но тоже имеет O(n^2)
     */
    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) { //i - разделяющий маркер
            int temp = array[i]; //делаем копию помеченного элемента
            int j = i;
            while (j > 0 && array[j-1] > temp) { //пока не будет найден наименьший элемент
                array[j] = array[j-1]; //сдвигаем элементы вправо
                j--;
            }
            array[j] = temp; //вставляем помеченный элемент в положенное ему место
        }
    }
    /*
    применяется в стандартной сортировке Java; если размер массива меньше 47, то
    используется сортировка вставкой вместо быстрой сортировки
     */
}
