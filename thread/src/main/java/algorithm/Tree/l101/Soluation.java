package algorithm.Tree.l101;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Soluation {
    boolean flag = true;
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    /**
     * 此方法存在缺陷
     */
    /*public boolean isSymmetric(TreeNode root){
        *//*TreeNode node1 = root;
        TreeNode node2 = root;
        if (node1 == null && node2 == null){
            flag = true;
        }
        if (node1 == null && node2 != null){
            flag = false;
        }
        if (node1 != null && node2 == null){
            flag = false;
        }
        helper1(node1);
        helper2(node2);
        //将list1和list2进行元素对比
        if (list1.size() != list2.size()){
            flag = false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)){
                flag = false;
            }
        }
        return flag;*//*
    }*/

    /**
     * 通过栈，一个一个对比左右子树
     * @param root
     * @return
     */
    Stack<TreeNode> stack = new Stack<>();
    public boolean isSymmetric1(TreeNode root){
        TreeNode node1 = root;
        TreeNode node2 = root;
        if (node1 == null && node2 == null){
            flag = true;
        }
        if (node1 == null && node2 != null){
            flag = false;
        }
        if (node1 != null && node2 == null){
            flag = false;
        }
        stack.add(node1);
        stack.add(node2);
        flag = isMirror(node1,node2);
        return flag;
    }

    /**
     * 通过递归的方式求解
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root){
        TreeNode node1 = root;
        TreeNode node2 = root;

        Boolean flag = check(node1,node2);
        return flag;

    }

    private Boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null){
            return false;
        }
        return node1.val == node2.val && check(node1.left,node2.right) && check(node1.right,node2.left);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        while (!stack.isEmpty()){
            node1 = stack.pop();
            node2 = stack.pop();
            if (node1 == null && node2 == null){
                continue;
            }
            if (node1 == null || node2 == null ||node1.val != node2.val){
                flag = false;
                return flag;
            }
            stack.add(node1.left);
            stack.add(node2.right);

            stack.add(node1.right);
            stack.add(node2.left);
        }
        return flag;
    }

    private void helper2(TreeNode node2) {
        if (node2 == null) return;
        helper2(node2.right);
        list2.add(node2.val);
        helper2(node2.left);
    }

    private void helper1(TreeNode node1) {
        if (node1 == null) return;
        helper1(node1.left);
        list1.add(node1.val);
        helper1(node1.right);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
