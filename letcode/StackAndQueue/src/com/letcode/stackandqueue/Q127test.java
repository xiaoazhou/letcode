package com.letcode.stackandqueue;

import java.util.*;

public class Q127test {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }

        Map<String,Boolean> map = new HashMap<>();

        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        while (!queue.isEmpty()){
            Pair tempPair = queue.poll();
            String str = tempPair.str;
            int level = tempPair.level;
            Iterator<String> iterator = wordList.iterator();
            while (iterator.hasNext()){
                String strtemp = iterator.next();
                if (compare(str,strtemp,map) == 1){
                    if (strtemp.equals(endWord) )
                        return level+1;
                    queue.add(new Pair(strtemp,level+1));
                }
            }

        }
        return 0;
    }

    public int compare(String str1,String str2,Map<String,Boolean> map){
        if (map.containsKey(str2)|| str1.equals(str2)){
            return -1;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int num = 0;
        for (int j = 0; j < chars1.length; j++) {
            if (num > 1)
                return -1;
            if (chars1[j] != chars2[j])
                num++;
        }
        if (num != 1){
            return -1;
        }
        map.put(str2,true);
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
