package com.array.day0226;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 题目：letcode Q76 最小覆盖子串
 * 题目描述：给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 示例：输入: S = "ADOBECODEBANC", T = "ABC" 输出: "BANC"
 * 类似438题
 * 2020年3月12日20:29:36
 */
public class Q76 {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int total = t.length();
        int nums = s.length()+1;
        Map<Integer,Integer> map = new HashMap<>();
        int [] needs = new int[64];
        int [] windows = new int[64];
        for (char i:t.toCharArray()) {
            needs[i - 'A'] ++;
        }
        while (right < s.length()){
            char chr = s.charAt(right);
            if (needs[chr - 'A'] > 0){
                windows[chr - 'A']++;
                if (windows[chr - 'A'] <= needs[chr -'A']){
                    total--;
                }
            }
            while (total == 0){
                nums = Math.min(nums,right-left+1);
                if (nums == right-left+1){
                    map.put(nums,left);
                }
                char chl = s.charAt(left);
                if(needs[chl - 'A'] > 0){
                    windows[chl - 'A']--;
                    if (windows[chl - 'A'] < needs[chl - 'A']){
                        total++;
                    }
                }
                left++;
            }
            right++;
        }
        if (nums == s.length()+1)
            return "";
        return s.substring(map.get(nums),map.get(nums) + nums);
    }

    public static void main(String[] args) {

    }
}

