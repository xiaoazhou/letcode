package com.letcode.greedy;
/**
 * Q605种花问题
 * @author 祁舟
 * 2019年9月26日22:45:08
 */
public class Q605 {
	 public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		 int num = 0;
		 //如果要求的种植数为0，直接返回true
		 if (n < 1) {
			return true;
		}
		 //定义一个数组，前后补0
		 int[] temp = new int[flowerbed.length+2];
		 temp[0] = 0;
		 temp[flowerbed.length+2-1] = 0;
		 System.arraycopy(flowerbed, 0, temp, 1, flowerbed.length);
		 //每个位置进行判断
		 	for (int i = 1; i < temp.length-1; i++) {		
		 		//如果当前位置没有种花
				if (temp[i] == 0) {
					//判断前后都没有种花，如果都没有则种下一颗
					if ((temp[i-1] == 0) && (temp[i+1] == 0)) {
						//更新已经种下的花的数目
						num++;
						temp[i] = 1;
					}
				}
			}
		 	//判断种下的花是不是满足要求
		 	if (num >= n) {
				return true;
			}else {
				return false;
			}
	        
	    }
	 
	 public static void main(String[] args) {
		int[] a = {0};
		int n = 1;
		System.out.println(canPlaceFlowers(a, n));
	}
}

