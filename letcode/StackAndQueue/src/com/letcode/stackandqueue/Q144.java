package com.letcode.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Q144 二叉树的前序遍历
 * 题目描述：给定一个二叉树，返回它的 前序 遍历。
 * 2020年5月24日15:17:25
 * @author xiaoazhou
 */
public class Q144 {
    List<Integer> list = new ArrayList();

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null){
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        return list;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null)
            return list;
        Command command = new Command(false,root);
        Stack<Command> stack = new Stack<>();
        stack.push(command);

        while (!stack.empty()){
            Command temp = stack.pop();
            if (temp.flag == false){
                if (temp.node.right != null)
                    stack.push(new Command(false, temp.node.right));
                if (temp.node.left != null)
                    stack.push(new Command(false, temp.node.left));
               stack.push(new Command(true,temp.node));
            }else if (temp.flag == true){
                list.add(temp.node.val);
            }

        }

        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }

        return list;
    }


    class Command {
        Boolean flag;
        TreeNode node;

        public Command(Boolean falg,TreeNode root){
            this.flag = falg;
            this.node = root;
        }
    }
}
