package com.array.day0226;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* letcod Q438找到字符串中所有字母异位词
*题目描述：给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
说明：字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
* @author 祁舟
* 2020年3月9日14:06:25
* */
public class Q438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        int l = 0; //滑动窗口左边界
        int r = 0;//滑动窗口右边界
        int total = p.length();//目前剩下还未有匹配字符的数量
        int [] needs = new int[26]; //需求数组，表示p字符串中出现的元素 出现频率
        int [] windows = new int [26];//窗口数组，表示窗口中出现的元素 出现频率
        for (char ch:p.toCharArray()) {
            needs[ch - 'a'] ++;
        }//初始化需求数组

        while (r < s.length()){
            char ch = s.charAt(r);//窗口右边界右滑
            if (needs[ch - 'a'] > 0){ //如果滑动进的字符是需求数组中的字符 则窗口对应字符频率增加
                windows[ch - 'a'] ++;
                if (windows[ch - 'a'] <= needs[ch - 'a']){//如果滑动进的字符出现的频率还没有超过p字符串中的出现频率
                    total --;// 还未匹配字符的数量减少
                }
            }

            while (total == 0){ //所有需要匹配的字符都已经出现
                if (r - l + 1 == p.length()) {
                    list.add(l); //此时长度与匹配字符串长度相同 则符合要求 进队
                }

                char lchar = s.charAt(l);
                if (needs[lchar - 'a'] > 0){//此时需要左边界右滑，即将出窗口的字符判断是否是需要匹配的字符
                    windows[lchar - 'a']--;//是需要匹配的字符，则其在窗口频率减少 因为即将出窗口
                    if (windows[lchar - 'a'] < needs[lchar - 'a']) {//此字符出窗口后匹配字符数量不够了
                        total++;//需要匹配的字符数量增加
                    }
                }
                l++;//窗口左边界右滑
            }
            r++;//窗口右边界右滑
        }

        return  list;
    }

    public static void main(String[] args) {
        Q438 a = new Q438();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(a.findAnagrams(s,p));
    }
}
