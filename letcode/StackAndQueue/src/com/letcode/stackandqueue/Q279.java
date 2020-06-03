package com.letcode.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Q279 完全平方数
 * 题目描述：给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 2020年6月3日00:50:06
 * @author xiaoazhou
 */
public class Q279 {
    public int numSquares(int n) {
        Pair root = new Pair(n,1);
        boolean[] visit = new boolean[n];
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Pair temp = queue.poll();
            int num = temp.num;
            int level = temp.level;

            for (int i = 1; ; i++) {
                int element = (num - (i*i));
                if( element == 0)
                    return level;
                if (element < 0){
                    break;
                }
                if (!visit[element]){
                    queue.add(new Pair(element,level+1));
                    visit[element] = true;
                }else
                    continue;

            }

        }
            
            return 0;
    }


    class Pair{
        public int num;

        public int level;

        public Pair(int num,int level){
            this.num = num;
            this.level = level;
        }
    }
}
