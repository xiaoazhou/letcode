package com.array.day0226;

public class Q167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            int right = twoBinarySearch(numbers,numbers.length,temp,i);
            if (right != -1){
                return new int[]{i,right};
            }
        }
        return new int[]{};
    }

    public int twoBinarySearch(int[] numbers,int n,int target,int l){
        int left = l,right = n-1;
        while (left <= right){
            int mid = (right+left)/2;
            if (numbers[mid] == target)
                return mid;
            else if (numbers[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
 }
