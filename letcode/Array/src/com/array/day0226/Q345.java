package com.array.day0226;

import sun.text.normalizer.UCharacter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*2020年2月29日17:44:26
题目：letcodeQ345 反转字符串中的元音字母
题目描述：编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
*/
public class Q345 {
    public String reverseVowels(String s) {
        if (s.length() == 0||s.length() == 1){
            return s;
        }
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')); //建立一个元音字母的查找表
        int low = 0;//设立左右指针，初始为数组的两端
        int high = s.length()-1;
        char[] chars = s.toCharArray();
        while (low < high){
            while((!vowels.contains(s.charAt(low))) && (low < high)){//找到字符串最左边的元音字母
                low++;
            }
            while ((!vowels.contains(s.charAt(high))) && (low < high)){//找到字符串最右边的元音字母
                high--;
            }
            char temp = chars[low];          //交换元音字母
            chars[low] = chars[high];
            chars[high] = temp;
            low++;                           //左右指针移动
            high--;
        }
        return String.valueOf(chars);
    }


    public static void main(String[] args) {
        Q345 a = new Q345();
        System.out.println(a.reverseVowels("hello"));
    }
}
