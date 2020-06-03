package com.array.day0226;

import java.util.HashSet;
import java.util.Set;

/**
 * Q202 快乐数
 * 题目描述：编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 * 2020年3月19日22:25:32
 */
public class Q202 {
    public boolean isHappy(int n) {
        if (n == 1)
            return true;
        Set<Integer> set = new HashSet<>();
        int temp = n;

        while (!set.contains(n)){
            if (n == 1)
                return true;
            set.add(n);
            System.out.println(n);
            temp = n;
            n = 0;
            while (temp != 0){
                n += (int)Math.pow((temp % 10),2);
                temp = temp / 10;
            }
        }
        return false;
    }
}
