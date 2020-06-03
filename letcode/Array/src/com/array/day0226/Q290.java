package com.array.day0226;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 题目：Q290 单词规律
 * 题目描述：给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 2020年3月21日23:41:58
 */

public class Q290 {
    public boolean wordPattern(String pattern, String str) {
        Map<String,Character> map1 = new HashMap<>();
        Set<Character> set = new HashSet<>();
        String [] strings = str.split(" ");
        if (strings.length != pattern.length())
            return false;
        for (int i = 0; i < strings.length; i++) {
            if (map1.get(strings[i]) == null) {
                if (set.contains(pattern.charAt(i)))
                    return false;
                else {
                    map1.put(strings[i], pattern.charAt(i));
                    set.add(pattern.charAt(i));
                }
            }else if (map1.get(strings[i]).equals(pattern.charAt(i)))
                continue;
             else
                return false;
        }
        return true;
    }
}
