package com.letcode.greedy;
/**
 * Q665 非递减数列
 * @author 祁舟
 * 
 *	2019年10月2日22:08:29
 */
public class Q665 {
	public static boolean checkPossibility(int[] nums) {
		//定义要改变的元素数目
		int num = 0;
		//数组前后补数，头部补最小值，尾部补最大值
        int [] temp = new int[nums.length + 2];
        temp[0] = Integer.MIN_VALUE;
        temp[temp.length - 1]  = Integer.MAX_VALUE;
        for (int i = 1; i < temp.length - 1; i++) {
			temp[i] = nums[i-1];
		}
        
        //循环数组中每个位置
        for(int i = 1 ;i < temp.length - 1; i++)
        {	
        	//如果当前数大于等于前面的小于等于后面
           if (temp[i] <= temp[i+1] && temp[i] >= temp[i-1] ) {
        	   //满足非递减，直接continue
			continue;
           }else {
        	   //如果不满足
        	   //判断后面的是不是大于前面
        	   if (temp[i+1] >= temp[i-1]) {
        		   //如果后面大于前面改变这个值为小的
        		   temp[i] = temp[i-1];
            	   num++;
            	   //如果num大于1，直接返回fasle
            	   if (num > 1) {
    				return false;
			} }
        	   //如果后面的小于前面的
        	   else {
        		   //改变后面的值为目前的值
				temp[i+1] = temp[i];
				//改变后如果还不满足，直接跳出
				if (temp[i+1] < temp[i - 1]) {
					return false;
				}
				//如果满足的话，num数目增加
				else {
					//如果num大于1，直接返回fasle
					num++;
					if (num > 1) {
	    				return false;
				}
			}
        	   
				}
        	   }
           }
        //执行完毕，还没有跳出，直接返回true
        return true;
    }
	
		public static void main(String[] args) {
			int[] a = {2,3,3,2,4};
			System.out.println(checkPossibility(a));
		}
}
