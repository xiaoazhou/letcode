package com.letcode.stackandqueue;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Q103 二叉树的锯齿形层次遍历
 * 题目描述：给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 2020年6月1日16:45:02
 * @author xiaoazhou
 */

public class Q103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<LinkedList<Integer>> res = new ArrayList<>();
            if (root == null){
                return new ArrayList<>();
            }
            LinkedList<Pair> queue = new LinkedList<>();
            queue.add(new Pair(root,0));
            while (!queue.isEmpty()){
                Pair tempPair = queue.poll();
                int level = tempPair.Level;
                TreeNode node = tempPair.node;


                if (node.left != null){
                    queue.add(new Pair(node.left,level+1));
                }
                if (node.right != null){
                    queue.add(new Pair(node.right,level+1));
                }

                if( level == res.size()){

                    res.add(new LinkedList<Integer>());
                    if (level % 2 == 1)
                        res.get(level).addFirst(node.val);
                    else
                        res.get(level).add(node.val);
                }else {
                    if (level % 2 == 1)
                        res.get(level).addFirst(node.val);
                    else
                        res.get(level).add(node.val);
                }

            }
        return (List)res;
    }



    class Pair{
        public TreeNode node;

        public int Level;

        public Pair(TreeNode node,int level){
            this.node = node;
            this.Level = level;
        }
    }
}
