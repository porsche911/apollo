package algorithm.Tree.l94;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        /*TreeNode node = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        Soluation soluation = new Soluation();
        List<Integer> integers = soluation.midTraverasl(node);
        for (Integer integer : integers) {
            System.out.println(integer);
        }*/
        Node node31 = new Node(5);
        Node node32 = new Node(6);
        List<Node> nodeList = new ArrayList<>(16);
        nodeList.add(node31);
        nodeList.add(node32);
        Node node21 = new Node(3, nodeList);
        List<Node> nodeList1 = new ArrayList<>(16);
        Node node22 = new Node(2);
        Node node23 = new Node(4);
        nodeList1.add(node21);
        nodeList1.add(node22);
        nodeList1.add(node23);
        Node node = new Node(1, nodeList1);
    }
}
