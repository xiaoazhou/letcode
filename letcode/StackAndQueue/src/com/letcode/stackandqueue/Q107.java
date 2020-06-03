package com.letcode.stackandqueue;

import java.util.*;

/**
 * Q107 二叉树的层次遍历 II
 * 题目描述：给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 2020年5月29日23:04:50
 * @author xiaoazhou
 */

public class Q107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();

        LinkedList<AbstractMap.SimpleEntry<TreeNode,Integer>> queue = new LinkedList<>();

        queue.add(new AbstractMap.SimpleEntry<TreeNode,Integer>(root,0));
        while (!queue.isEmpty()){
            AbstractMap.SimpleEntry<TreeNode,Integer> temp = queue.poll();
            TreeNode treeNode = temp.getKey();
            int level = temp.getValue();
            if (treeNode.left != null)
                queue.add(new AbstractMap.SimpleEntry<TreeNode,Integer>(treeNode.left,level+1));
            if (treeNode.right != null)
                queue.add(new AbstractMap.SimpleEntry<TreeNode,Integer>(treeNode.right,level+1));

            if (level == res.size()){
                List<Integer> list = new ArrayList<>();
                res.addFirst(list);
                res.getFirst().add(treeNode.val);
            }else {
                res.getFirst().add(treeNode.val);
            }


        }

        return res;
    }

}
