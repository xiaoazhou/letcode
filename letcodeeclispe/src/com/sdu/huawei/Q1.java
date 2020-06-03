package com.sdu.huawei;

public class Q1 {
	
	public static void main(String[] args) {
		int[] a = {};
		System.out.println(soultion(a));
		
	}
	static int soultion(int[] nums) {
		if (nums.length <= 1||nums == null) {
			return -1;
		}
		int n = nums.length - 1;
		int count = 0;
		boolean flag = false;
		while(n >= nums.length/2 && n > 1) {
			n = searchn(nums, n);
			System.out.println(n+"sou");
			if (n <= 0) {
				flag = true;
				break;
			}else {
				count ++ ;
			}
		}
		
		if (flag) {
			return -1;
		}else {
			return count + 1;
		}
		
		
		
	}
	
	static int searchn(int[] nums,int n){
		int temp = 0;
		boolean flag = false;
		for (int i = n; i > 0; i--) {
			if (nums[i] == n - i) {
				flag = true;
			}
			if (flag) {
				temp = i;
			}
			flag = false;
		}
		if (temp < 0) {
			return -1;
		}else {
			System.out.println(temp);
			return temp ;
					
		}
		 
	}
}
