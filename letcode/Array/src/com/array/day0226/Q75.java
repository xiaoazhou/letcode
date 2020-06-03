package com.array.day0226;

import java.util.Arrays;

/**
 * 2020年2月23日13:16:00
 * 题目 lecode Q75 颜色分类
 * 题目描述 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class Q75 {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        int one = -1;             //使用one 和 two 将数组分为三段 更新one和two的数值
        int two = nums.length;
        for (int i = one+1; i < two;) {
            if (nums[i] == 1)
                i++;
            else if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[one+1];
                nums[one+1] = temp;
                one++;
                i++;
            }else {
                int temp = nums[i];
                nums[i] = nums[two-1];
                nums[two-1] = temp;
                two--;
            }

        }
    }

    public static void main(String[] args) {
            Q75 a = new Q75();
            int [] nums = {2,0,2,1,1,0};
            a.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
