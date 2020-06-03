package com.sdu.letcode;

/**
 * 2020年2月20日15:57:58
 * 题目 letcode 80题 删除排序数组中的重复项
 * 题目描述 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Q80 {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                if (flag){
                    if (count != i){
                        count++;
                        nums[count] = nums[i];
                    }
                    flag = false;
                }
            }
            else {
                flag = true;
                if (count != i){
                    count++;
                    nums[count] = nums[i];
                }
                else
                    count++;
            }
        }

        return count+1;
    }

    public static void main(String[] args) {

    }
}
