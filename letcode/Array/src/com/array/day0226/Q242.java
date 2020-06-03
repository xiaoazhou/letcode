package com.array.day0226;

import java.util.HashMap;
import java.util.Map;

/**
 * Q242 有效的字母异位词
 * 题目描述：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 2020年3月19日21:48:04
 */
public class Q242 {
    public boolean isAnagram(String s, String t) {//我的初始想法 使用map来做
        if (s.length()!=t.length())
            return false;
        Map<Character,Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {//将s中的字符放入map中
            char temp = s.charAt(i);
            if (map1.get(temp)==null)
                map1.put(temp,1);
            else map1.put(temp,map1.get(temp)+1);
        }

        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            if (map1.get(temp)!=null){
                if (map1.get(temp) == 1)
                    map1.remove(temp);
                else map1.put(temp,map1.get(temp)-1);
            }else return false;

        }

        return map1.isEmpty();
    }

    public boolean isAnagram2(String s, String t) {//官方做法 使用数组即可实现
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
