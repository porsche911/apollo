package algorithm.Tree.l104;

public class Test {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left= new TreeNode(11);
        node.right=new TreeNode(20);
        node.right.left = new TreeNode(1);
        node.right.right = new TreeNode(7);
        Solution solution = new Solution();
        //int i = solution.maxDepth1(node);
        int i = solution.maxDepth2(node);
        System.out.println(i);
    }
}
