package algorithm.Tree.l110;

public class Solution {
    public boolean isBalanced(TreeNode root){
        if (root == null) return true;
        int left = higt(root.left);
        int righ = higt(root.right);
        return (Math.abs((left-righ)) <=1 && isBalanced(root.left) && isBalanced(root.right));
    }
    private int higt(TreeNode root) {
        if (root == null) return 0;
        int lett = higt(root.left);
        int right = higt(root.right);
        return Math.max(lett,right) +1;
    }

    /**
     * 在计算树的高度的同时，判断是否是平衡树
     * @param root
     * @return
     */
    public boolean balance = true;
    public boolean isBalanced1(TreeNode root){
        if (root == null) return true;
        high(root);
        return balance;
    }
    private int high(TreeNode root) {
        if (root == null || !balance) return -1;
        int highLeft = high(root.left);
        int highRigh = high(root.right);
        if ((Math.abs(highLeft-highRigh))<1){
            balance= false;
            return -1;
        }
        return Math.max(highLeft,highRigh)+1;
    }




    public boolean isBalanced2(TreeNode root){
        if (root == null) return true; //如果为空，则为平衡二叉树
        int letfHigh = high2(root.left); //获得根节点右子树的高度
        int rightHigh = high2(root.right);//获得根节点左子树的高度
        return (Math.abs(rightHigh-letfHigh) <=1 && isBalanced2(root.left) && isBalanced2(root.right));
    }
    /**
     * 计算节点的高度
     * @param root
     * @return
     */
    private int high2(TreeNode root) {
        if (root == null) return 0;//如果该节点无子节点，返回0
        int letf = high2(root.left);//找到最底下的左子树
        int right = high2(root.right);//找节点的右子树
        return Math.max(letf,right) +1;//取左右子树的最高度，比如最后一个节点的高度本为0，再找下一个节点前先进行高度加1的操作
    }

    public boolean isBalance3(TreeNode root){
        if (root == null) return true;
        high3(root);
        return balance;
    }

    private int high3(TreeNode root) {
        if (root == null) return 0;
        int left = high3(root.left);//遍历得到左子树的最后一个节点
        if (!this.balance) return -1;//因为该节点的高度已提前加1，如果该节点为非平衡二叉树，需要减1
        int right = high3(root.right);//得到节点的右子树
        if (Math.abs(left-right) >1){//如果该节点不属于平衡二叉树，则将标识置为false，且
            balance = false;
            return -1;
        }
        return Math.max(left,right)+1;
    }
}






















class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
