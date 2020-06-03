package com.array.day0226;

/**
 * 2020年2月23日14:01:41
 * 题目 letcode   Q88合并两个有序数组
 * 题目描述：给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

 */
public class Q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int p1 = m-1;
       int p2 = n-1;
       int p  = m+n-1;

       while((p1 >= 0) && (p2 >= 0)){
           if (nums1[p1] >= nums2[p2]){
               nums1[p] = nums1[p1];
               p--;
               p1--;
           }else {
               nums1[p] = nums2[p2];
               p--;
               p2--;
           }
       }
       System.arraycopy(nums2,0,nums1,0,p2+1);
    }

    public static void main(String[] args) {

    }
}
