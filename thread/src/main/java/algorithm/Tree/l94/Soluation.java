package algorithm.Tree.l94;



import java.util.*;

/**
 * 中序遍历，栈+列表
 */
public class Soluation {
    /*public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> resultList = new ArrayList<>(16);
        TreeNode current = root;
        //利用栈的先进后出来，将左子树放到栈中，因为要将栈中的所有元素都弹出，所以要判断stack不为空
        while (current !=null || !stack.isEmpty()){
            while (current !=null){
                stack.add(current);
                current = current.left;
            }
            current =stack.pop();
            resultList.add(current.val);
            current = current.right;
        }
        return resultList;
    }*/

    /**
     * 这个不用先取数，放进栈后，弹出再取数，故需要两个while循环
     *
     * @param root
     * @return
     */
    public List<Integer> LDR(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        ArrayList<Integer> resultList = new ArrayList<>(16);
        TreeNode current = root;
        while (current != null || !nodeStack.isEmpty()) {
            while (current != null) {
                nodeStack.add(current);
                current = current.left;
            }
            current = nodeStack.pop();
            resultList.add(current.val);
            current = current.right;
        }
        return resultList;
    }

    /**
     * 后序遍历，需要使用双栈来实现
     *
     * @param root
     * @return
     */
    public List<Integer> LRD(TreeNode root) {
        Stack<TreeNode> nodeStack1 = new Stack<>();//用来存储顺序节点
        Stack<TreeNode> nodeStack2 = new Stack<>();//用于输出
        List<Integer> resultList = new ArrayList<>(16);
        TreeNode current = root;
        nodeStack1.add(current);
        while (current != null || !nodeStack1.isEmpty()) {
            current = nodeStack1.pop();
            nodeStack2.add(current);
            if (current.left != null) {
                current = current.left;
                nodeStack1.add(current);
            }
            if (current.right != null) {
                current = current.right;
                nodeStack1.add(current);
            }
        }
        while (!nodeStack2.isEmpty()) {
            current = nodeStack2.pop();
            resultList.add(current.val);
        }
        return resultList;
    }

    /**
     * 前序遍历的其他实现方式,利用栈这个需要先取数，故用一个while循环
     */
    public List<Integer> DLR(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        List<Integer> resultResult = new ArrayList<>(16);
        TreeNode current = root;
        while (current != null || !nodeStack.isEmpty()) {
            if (current != null) {
                resultResult.add(current.val);
                nodeStack.add(current);
                current = current.left;
            } else {
                current = nodeStack.pop();
                current = current.right;
            }
        }
        return resultResult;
    }

    /**
     * 中序遍历的递归方法实现
     */
    ArrayList<Integer> resultList = new ArrayList<>(16);

    public List<Integer> midTraverasl(TreeNode root) {
        TreeNode current = root;
        if (current != null) {
            midTraverasl(current.left);
            resultList.add(current.val);
            midTraverasl(current.right);
        }
        return resultList;
    }

    /**
     * 前序遍历的递归方法实现
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode current = root;
        if (current != null) {
            resultList.add(current.val);
        }
        preorderTraversal(current.left);
        preorderTraversal(current.right);
        return resultList;
    }

    /**
     * 后序递归遍历
     */
    public List<Integer> houxuTraversal(TreeNode root) {
        TreeNode current = root;
        if (current != null) {
            houxuTraversal(current.left);
            houxuTraversal(current.right);
            resultList.add(current.val);
        }
        return resultList;
    }

    /**
     * 前序遍历,递归的方式
     *
     * @param node
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode node) {
        TreeNode current = node;
        if (current != null) {
            resultList.add(current.val);
            preorderTraversal1(current.left);
            preorderTraversal1(current.right);
        }
        return resultList;
    }

    /**
     * 前序遍历的栈实现
     *
     * @param node
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode node) {
        Stack<TreeNode> nodeStack = new Stack<>();
        ArrayList<Integer> resultList = new ArrayList<>(16);
        TreeNode current = node;
        while (current != null || !nodeStack.isEmpty()) {
            if (current != null) {
                resultList.add(current.val);
                nodeStack.add(current);
                current = current.left;
            } else {
                current = nodeStack.pop();
                current = current.right;
            }
        }
        return resultList;
    }

    /**
     * 后序遍历的递归实现
     *
     * @param node
     * @return
     */
    public List<Integer> LRD1(TreeNode node) {
        TreeNode current = node;
        if (current != null) {
            LRD1(current.left);
            LRD1(current.right);
            resultList.add(current.val);
        }
        return resultList;
    }

    /**
     * 后序遍历的双栈实现
     *主要是利用倒序，将元素放入栈中，
     * @param
     * @return
     */
    public List<Integer> LDR2(TreeNode root) {

        ArrayList<Integer> resultList = new ArrayList<>(16);
        if (root != null) {
            Stack<TreeNode> nodeStack1 = new Stack<TreeNode>();
            Stack<Integer> nodeStack2 = new Stack<Integer>();
            nodeStack1.push(root);
            while (!nodeStack1.isEmpty()) {
                root = nodeStack1.pop();
                nodeStack2.push(root.val);
                if (root.left != null) {
                    nodeStack1.push(root.left);
                }
                if (root.right != null) {
                    nodeStack1.push(root.right);
                }
            }
            while (!nodeStack2.isEmpty()) {
                resultList.add(nodeStack2.peek());
            }
        }
        return resultList;
    }


    /**
     *
     * @param root
     * @return
     */
    public List<Integer> LRD3(TreeNode root){
        List<Integer> resultList = new ArrayList<>(16);
        if (root !=null){
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()){
                root = stack1.pop();
                stack2.push(root);
                if (root.left !=null){
                    stack1.push(root.left);
                }
                if (root.right !=null){
                    stack1.push(root.right);
                }
            }
            while (!stack2.isEmpty()){
                root = stack2.pop();
                resultList.add(root.val);
            }
        }
        return resultList;
    }

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> LRD4(TreeNode root){
        if (root !=null){
            LRD4(root.left);
            LRD4(root.right);
            resultList.add(root.val);
        }
        return resultList;
    }

    /**
     * 429  层次遍历,思路：一次while循环，处理一层
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> resultList = new ArrayList<>();
        if (root ==null){
            return resultList;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0){
            ArrayList<Integer> leelList1 = new ArrayList<>(16);
            int size = leelList1.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                leelList1.add(node.val);
                List<Node> childrenList = node.children;
                for (Node node1 : childrenList) {
                    queue.add(node1);
                }
            }
            resultList.add(leelList1);
        }
        return resultList;
    }

    /**
     * 广度优先的层次遍历
     * @param root
     * @return
     */

    public List<List<Integer>> levelOrder1(Node root){
        List<List<Integer>> resultList = new ArrayList<>(16);
        Queue<Node> queue = new LinkedList<>();
        if (root ==null) return resultList;
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> leelList = new ArrayList<>(16);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                leelList.add(root.val);
                queue.addAll(root.children);
            }
            resultList.add(leelList);
        }
        return resultList;
    }

    /**
     * 使用递归的方式实现层次遍历,深度优先
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(Node root){
        List<List<Integer>> res = new ArrayList<>();
        int level =0;
        res =helper(root,level,res);
        return res;
    }

    private List<List<Integer>> helper(Node root, int level, List<List<Integer>> res) {
        if (root ==null) return res;
        if (level +1 >res.size()){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        //处理子节点，子节点在下一层
        for (Node node : root.children){
            if (node !=null){
                //此处level需要加1处理
                helper(node,level+1,res);
            }
        }
        return res;
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(Node root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size()>0){
            int queueSize = queue.size();
            ArrayList<Integer> resultLevelList = new ArrayList<>(16);
            for (int i = 0; i < queueSize; i++) {
                root = queue.poll();
                resultLevelList.add(root.val);
                //处理子节点,此处是比较难理解的，为什么处理子节点的for循环要放在这个for循环里面：
                //这是因为：在处理第一个节点时就将其子节点全部放到队列中，先进先出，第二层子节点在上一层节点后排队
                for (Node node : root.children){
                    queue.add(node);
                }
            }
            res.add(resultLevelList);
        }
        return res;
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}




