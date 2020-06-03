package com.sdu.letcode;
/**
 * Q6 Z字型变换
 * @author 祁舟
 * 2019年9月9日19:13:13
 */
public class Q6 {
	@SuppressWarnings("null")
	public static String convert(String s, int numRows) {
		
        int len = s.length();
        char[] chs = s.toCharArray();
        if (len == 0) {
			return "";
		}
        if (numRows == 1) {
			return s;
		}
       
        int nl1 = len/(2*numRows-2);

        
        int nl2;
        int temp;
        
        if ((temp = (len % (2*numRows-2))) > numRows) {
			nl2 = temp - numRows + 1; 
		}else if (temp ==  0) {
			nl2 = 0;
		}else {
			nl2 =1;
		}
        int lines = (numRows - 1)*nl1 + nl2;
        int sorrow = 0;
        System.out.println(nl1 + "--" +nl2 +"-- "+lines);
        System.out.println(chs.length);
        char[][] nums = new char[numRows][lines];
    
        int k = 0;
        for (int j = 0; j < lines; j++) {

			for (int i = 0; i < numRows; i++) {
				if (numRows == 1||(j % (numRows-1)) == 0) {
					if (sorrow < len) {
						nums[i][j] = chs[sorrow];
						sorrow ++;
					}											
					
				}else{
					    k = numRows - 1 - (j % (numRows-1)) ;
					   
						nums[k][j] = chs[sorrow];
						sorrow++;						
					    break;
				}
			}
		}
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
        	for (int j = 0; j < lines; j++) {
				if ( nums[i][j] != '\u0000') {
					str.append(nums[i][j]);
				}
			}
			
		}
       
        return str.toString();
    }
	public static void main(String[] args) {
		String s ="Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";			
		System.out.println(convert(s, 3));
	}
}
