package com.sdu.letcode;
import java.lang.Math;
/**
 * letcode������
 * @author qizhou
 * 2019��9��5��19:23:19
 */
public class Q5 {
	 public static String longestPalindrome(String s) {
		 char[] cy = s.toCharArray();
		  //���������ǿ�ֱ�ӷ���
	        if (cy.length == 0) {
					return "";
				}
	      //�������ĳ�����1����ô�������Լ�
	        if (cy.length == 1) {
				return s.substring(0,1);
			}
			 int len = 0;//����Ĵ�����
			 int[] index = {0,0};//��һ���������洢�ַ����±�
			 //
			 for (int i = 0; i < cy.length; i++) {
				int temp = i;	
				int j ;
				//Ѱ�ҺͿ�ͷ�ַ���ͬ���ַ����ټ����һ���Ƿ��ǻ����ַ���
				while ( (j=s.indexOf(cy[temp],i+1)) != -1) {
					//�˴�д�Ĳ��ã�ָ�붨�����
					i = temp;
					int temp1 = j;
					//��������ָ��һ����ͷ����һ���ں�����ͬ���ַ����������������
					while ( i < temp1 ) {
						if (cy[i] == cy[temp1]) {
							i++;
							temp1--;						
						}else {
							 //������ָ���Ӧ���ַ���ͬʱֱ������
							break;
						};
						//������ָ������ʱ��ȷ���ǻ��ģ�����len������
						if (i >= temp1) {
							len = Math.max(len, j-temp+1);
							if (len == j-temp+1) {
								index[0] = temp;
								index[1] = j;
							}
						}
						
					
					}
					//��ԭi����Ϊ֮ǰʹ����������ָ��(��������)
					i = j;				
				}
				//ԭ��û�ӣ����˺þ�
				//��ԭi������ͬ��
				i = temp;
			}
		     
			 return s.substring(index[0],index[1]+1);
	    }
	public static void main(String[] args) {
		System.out.println(longestPalindrome("ac"));

	}
}
