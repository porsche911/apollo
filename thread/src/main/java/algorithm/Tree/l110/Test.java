package algorithm.Tree.l110;


public class Test {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left= new TreeNode(2);
        node.right=new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.left.left = new TreeNode(4);
        node.left.left.right = new TreeNode(4);
        Solution solution = new Solution();
        solution.isBalance3(node);
    }
}
