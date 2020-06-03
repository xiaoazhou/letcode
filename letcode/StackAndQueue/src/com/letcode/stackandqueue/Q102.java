package com.letcode.stackandqueue;

import java.util.*;

/**
 * Q102 二叉树的层序遍历
 * 题目描述： 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 2020年5月29日22:03:45
 * @author xiaoazhou
 */

public class Q102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        Queue<AbstractMap.SimpleEntry<TreeNode,Integer>> queue = new LinkedList<>();

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
                res.add(list);
                res.get(level).add(treeNode.val);
            }else {
                res.get(level).add(treeNode.val);
            }


        }

        return res;
    }

}
