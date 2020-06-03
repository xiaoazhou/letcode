package com.letcode.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Q94 二叉树的中序遍历
 * 题目描述：给定一个二叉树，返回它的中序 遍历。
 * 2020年5月24日17:03:14
 * @author xiaoazhou
 */
public class Q94 {
    List<Integer> list = new ArrayList();


    //递归实现。
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root != null){

            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }

        return list;
    }


    //模仿栈命令实现
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null)
            return list;
        Command1 command = new Command1(false,root);
        Stack<Command1> stack = new Stack<>();
        stack.push(command);

        while (!stack.empty()){
            Command1 temp = stack.pop();
            if (temp.flag == false){
                if (temp.node.right != null)
                    stack.push(new Command1(false, temp.node.right));

                stack.push(new Command1(true,temp.node));

                if (temp.node.left != null)
                    stack.push(new Command1(false, temp.node.left));

            }else if (temp.flag == true){
                list.add(temp.node.val);
            }

        }


        return list;
    }


    //栈实现，标准法
    public List<Integer> inorderTraversal3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            list.add(stack.pop().val);

            curr = curr.right;


        }

        return list;
    }


    //命令类 对应inorderTraversal2
    private class Command1 {
        Boolean flag;
        TreeNode node;

        public Command1(Boolean falg, TreeNode root) {
            this.flag = falg;
            this.node = root;
        }
    }
}
