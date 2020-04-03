package com._520.offer;

@SuppressWarnings("all")
public class 旋转数组的最小数字 {

    public int minArray(int[] numbers) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right){
            int mid = (left + right) >> 1;

            if (numbers[mid] == numbers[right]){
                right--;
            }else if (numbers[mid] > numbers[right]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return numbers[left];
    }


    public static void main(String[] args) {
        旋转数组的最小数字 x = new 旋转数组的最小数字();
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(x.minArray(arr));
    }
}
