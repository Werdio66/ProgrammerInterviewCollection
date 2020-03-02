package com._520.动态规划;

public class MagicIndex {

    public boolean findMagicIndex(int[] A, int n) {
        return method(A, 0, n);
    }

    private boolean method(int[] arr, int left, int right){
        if (arr.length <= 0 || left >= right){
            return false;
        }

        int mid = left - (left - right) >> 1;

        if (arr[mid] == mid){
            return true;
        }else if (arr[mid] > mid){
            return method(arr, left, mid - 1);
        }else {
            return method(arr, mid + 1, right);
        }

    }

    private boolean method1(int[] A, int n){

        int left = 0;
        int right = n;

        while (left < right){

            int mid = left - (left - right) >> 1;

            if (A[mid] == mid){
                return true;
            }else if (mid < A[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        MagicIndex magicIndex = new MagicIndex();
//        System.out.println(magicIndex.findMagicIndex(arr, arr.length - 1));

        System.out.println(magicIndex.method1(arr, arr.length - 1));
    }
}
