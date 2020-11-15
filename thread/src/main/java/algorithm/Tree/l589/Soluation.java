package algorithm.Tree.l589;

import java.util.*;

public class Soluation {
    /**
     * 递归方式解决
     */
    List<Integer> res = new ArrayList<>(16);
    public List<Integer> preorder(Node root) {
        if (root ==null) return res;
        res.add(root.val);
        for (Node node : root.children){
            preorder(node);
        }
        return res;
    }

    /**
     * 通过借助linklist来实现
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root){
        if (root == null) return res;
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (linkedList.size()>0){
            root = linkedList.pollLast();
            res.add(root.val);
            List<Node> childrenList = root.children;

            for (int i = childrenList.size()-1; i >= 0; i--) {
                linkedList.add(childrenList.get(i));
            }
        }
        return res;
    }

    /**
     * N叉树的后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root){
        if (root == null) return res;
        res = helper(root);
        res.add(root.val);
        return res;
    }
    private List<Integer> helper(Node root) {
        List<Node> childrenList = root.children;
        for (Node node : childrenList) {
            helper(node);
            res.add(node.val);
        }
        return res;
    }

    /**
     * 通过迭代的方式来实现后序遍历
     * @param root 从linkedList导入到statck中
     * @return
     */

    public List<Integer> postorder1(Node root){
        if(root == null) return res;
        LinkedList<Node> linkedList = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        linkedList.add(root);
        while (linkedList.size()>0){
            root = linkedList.pollLast();
            stack.add(root.val);
            List<Node> childrenList = root.children;
            for (int i = 0; i <childrenList.size() ; i++) {
                linkedList.add(childrenList.get(i));
            }
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
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


