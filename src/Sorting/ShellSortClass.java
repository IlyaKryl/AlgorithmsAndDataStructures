package Sorting;

import java.util.Arrays;

public class ShellSortClass {
    public static void main(String[] args) {
        int[] testArr = {7,1,5,3,8,3,10,9,8,4,2,6};
        shellSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    /*
    Сортировка Шелла - усовершенствованный вариант сортировки вставками.
    Эффективность сортировки Шелла в определённых случаях обеспечивается тем,
    что элементы «быстрее» встают на свои места.
     */
    private static void shellSort(int[] array) {
        int length = array.length;
        int step = length / 2;
        while (step > 0) {
            for (int numberOfGroup = 0; numberOfGroup < length - step; numberOfGroup++) { //проходим по всем группам
                int j = numberOfGroup;
                while (j >= 0 && array[j] > array[j + step]) { //сортировка вставкой внутри группы
                    int temp = array[j];
                    array[j] = array[j + step];
                    array[j + step] = temp;
                    j--;
                }
            }
            step = step / 2; //уменьшаем шаг
        }
    }
}
