package algorithm.Tree.l104;

public class Solution {
    /**
     * 通过深度优先解决
     * @param root
     * @return
     */
    int result =0;
    int index = 0;
    public int maxDepth(TreeNode root){
        int left =0;
        int right = 0;
        if (root == null) return 0;
        left = helper1(root,0);
        right = helper2(root,0);
        return Math.max(left,right)+1;
    }
    private int helper2(TreeNode root, int index) {
        if (root.right !=null){
            index++;
            helper2(root.right,index);
        }
        return index;
    }
    private int helper1(TreeNode root, int index) {

        if (root.left !=null){
            index ++;
            helper1(root.left,index);
        }
        return index;
    }

    public int maxDepth1(TreeNode root){
        if (root == null) return 0;
        helper(root);
        return result;
    }
    public int maxDepth2(TreeNode root){
        if (root == null) return 0;
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        return Math.max(left,right)+1;
    }

    private void helper(TreeNode root) {
        index++;
        if (root.left !=null || root.right !=null){
            if (root.left !=null){
                helper(root.left);
                index --;
            }
            if (root.right !=null){
                helper(root.right);
                index--;
            }
        }else {
            result = Math.max(result,index);
            return;
        }
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
