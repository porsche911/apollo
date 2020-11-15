package algorithm.Tree.l987;

import java.util.*;

public class Soluation {
    List<List<Integer>> res = new ArrayList<>();
    List<LocationNode> locatons;
    public List<List<Integer>> verticalTraversal(TreeNode root){
        //通过深度优先存储数据
        locatons = new ArrayList();
        dfs(root,0,0);
        Collections.sort(locatons);
        res.add(new ArrayList<Integer>());
        int prev = locatons.get(0).x;
        for (LocationNode locaton : locatons) {
            if (locaton.val != prev){
                prev = locaton.val;
                res.add(new ArrayList<Integer>());
            }
            res.get(res.size()-1).add(locaton.val);
        }
        return res;
    }

    /**
     * 使用优先队列的方法
     * 存储坐标的类Location
     * @param root
     * @return
     */
    PriorityQueue<Location> queue =
            new PriorityQueue<Location>(new Comparator<Location>() {
                @Override
                public int compare(Location node1, Location node2) {
                    if (node1.x != node2.x){
                        return Integer.compare(node1.x,node2.x);
                    }else if (node1.y !=node2.y){
                        return Integer.compare(node2.y,node1.y);
                    }else {
                      return Integer.compare(node1.val,node2.val);
                    }
                }
            });
    public List<List<Integer>> verticalTraversal1(TreeNode root){
        //递归遍历
        dfsq(root,0,0);
        ArrayList<List<Integer>> result = new ArrayList<>(16);
        result.add(new ArrayList<>(16));
        int pre = queue.peek().x;
        while (!queue.isEmpty()){
            Location poll = queue.poll();
            if (pre !=poll.x){
                pre = poll.x;
                result.add(new ArrayList<>());
            }
            result.get(result.size()-1).add(poll.val);
        }
        return result;
    }

    private void dfsq(TreeNode root, int x, int y) {
        if (root !=null){
            queue.add(new Location(x,y,root.val));
            dfsq(root.left,x-1,y-1);
            dfsq(root.right,x+1,y-1);
        }
    }

    private void dfs(TreeNode root, int x, int y) {
        if (root !=null){
            locatons.add(new LocationNode(x,y,root.val));
            dfs(root.left,x-1,y-1);
            dfs(root.right,x+1,y-1);
        }
    }
}
class LocationNode implements Comparable<LocationNode> {
    int x;
    int y;
    int val;
    public LocationNode(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    @Override
    public int compareTo(LocationNode that) {
        if (this.x != that.x){
            return Integer.compare(this.x,that.x);
        }
        else if (that.y != this.y){
            return Integer.compare(this.y,that.y);
        }else {
            return Integer.compare(this.val,that.val);
        }
    }
}
class Location {
    int x;
    int y;
    int val;
    public Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

