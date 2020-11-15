package algorithm.Tree.l1302;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Soluation {
    public int deepestLeavesSum(TreeNode root) {
        List<TreeNode> res = new ArrayList<>(16);
        Queue<TreeNode> queue = new LinkedList<>();
        int sum=0;
        if (root == null) return 0;
        queue.add(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            if (root.left !=null){
                queue.add(root.left);
            }
            if (root.right !=null){
                queue.add(root.right);
            }
            if (root.left ==null && root.right == null){
                res.add(root);
            }
        }
        for (TreeNode re : res) {
            sum +=re.val;
        }
        return sum;
    }
    public int deepestLeavesSum1(TreeNode root){
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                list.add(root.val);
                if (root.left !=null){
                    queue.add(root.left);
                }
                if (root.right !=null){
                    queue.add(root.right);
                }
            }
            res.add(list);
        }
        int sum =0;
        List<Integer> last = res.getLast();
        for (Integer integer : last) {
            sum += integer;
        }
        return sum;
    }

    /**
     * 通过深度优先的方式来解决
     * @param root
     * @return
     */

    int deepest=0;
    int sum =0;
    public int deepestLeavesSum2(TreeNode root){

        if (root == null) return 0;
        helper(root,0);
        return sum;

    }
    private void helper(TreeNode root, int index) {
        if (root ==  null) return;
        if (index > deepest){
            deepest = index;
            sum= root.val;
        }else if (index == deepest){
            sum += root.val;
        }
        helper(root.left,index+1);
        helper(root.right,index+1);
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
