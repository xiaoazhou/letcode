package com.letcode.stackandqueue;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Q127 单词接龙
 * 题目描述： 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 2020年6月3日16:01:48
 * @author xiaoazhou
 */
public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        Object[] arrayArea1 = wordList.toArray();
        String[] arrayWord = new String[arrayArea1.length];
        for (int i = 0; i < arrayArea1.length; i++) {
            arrayWord[i] = arrayArea1[i].toString();
        }
        boolean[] visit = new boolean[arrayWord.length];
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        while (!queue.isEmpty()){
            Pair tempPair = queue.poll();
            String str = tempPair.str;
            int level = tempPair.level;
            for (int i = 0; i < arrayWord.length; i++) {
                int numReturn = compare(str,arrayWord[i],visit,i);
                if (numReturn == 1){
                    if (arrayWord[i].equals(endWord)){
                        return level+1;
                    }
                    queue.add(new Pair(arrayWord[i],level+1));
                }
            }
        }
            return 0;
    }

        public int compare(String str1,String str2,boolean[] visit,int i){
            if (visit[i]){
                return -1;
            }

            int num = 0;
            for (int j = 0; j < str1.length(); j++) {
                if (num > 1)
                    return -1;
                if (str1.charAt(j) != str2.charAt(j))
                    num++;
            }
            if (num != 1){
                return -1;
            }
            visit[i] = true;
            return 1;
        }


    class Pair{
        public String str;
        public int level;
        public Pair(String str,int level){
            this.str = str;
            this.level = level;
        }
    }

}
