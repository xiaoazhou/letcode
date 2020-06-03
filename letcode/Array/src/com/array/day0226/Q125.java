package com.array.day0226;
/*
*2020年2月29日01:21:20
* 题目：验证回文串
* 题目描述：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。
*/
public class Q125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)  //如果字符串为空，直接返回
            return true;
        String str = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();//去除所有非字母和数字字符，并将大写转为小写
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {//从数组两头开始判定 是否是相同字符，如果不是直接返回false
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;//执行完毕说明两两字符相等
    }

    public static void main(String[] args) {
        Q125 a = new Q125();
        String string = "A man, a plan, a canal: Panama";
        System.out.println(a.isPalindrome(string));
    }
}
