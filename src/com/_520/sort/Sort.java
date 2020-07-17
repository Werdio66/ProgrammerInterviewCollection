package com._520.sort;

/**
 * @author Werdio丶
 * @since 2020-07-01 09:52:38
 */
public class Sort {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void bubbleSort(int[] array){

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]){
                    swap(array, j + 1, j);
                }
            }
        }
    }

    public void selectSort(int[] array){

        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (array[index] > array[j]){
                    index = j;
                }
            }
            swap(array, index, i);
        }
    }

    public void insertSort(int[] array){

        for (int i = 0; i < array.length; i++) {
            int current = array[i + 1];
            int index = i;
            while (index >= 0 && current < array[index]){
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = current;
        }
    }



}
