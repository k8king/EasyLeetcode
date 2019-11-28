package easycode;

//import org.apache.commons.lang3.tuple.Pair;
import javafx.util.Pair;
import java.util.*;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode104 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    /**
     * 递归 DFS
     * 时间复杂度为O(N) 空间复杂度将是O(log(N))
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if(root == null ) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    /**
     * 迭代 BFS
     * 时间复杂度为O(N) 空间复杂度是O(N)
     * @param root
     * @return
     */
    public static int maxDepthV2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if(root == null) {
            return 0;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            depth++;
            int len = queue.size();
            for(int i = 0;i<len;i++) {
                TreeNode node = queue.poll();
                if(node.left!= null) {
                    queue.offer(node.left);
                }
                if(node.right!= null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }



    /**
     * 迭代 DFS
     * 时间复杂度为O(N) 空间复杂度将是O(N)
     * @param root
     * @return
     */
    public static int maxDepthV3(TreeNode root) {
        if(root==null) {return 0;};
        Stack<Pair<TreeNode,Integer>> stack =new Stack<>();
        TreeNode current=root;
        int Maxdeep=0;
        int deep=0;
        //若栈非空，则说明还有一些节点的右子树尚未探索；若p非空，意味着还有一些节点的左子树尚未探索
        while(stack.isEmpty() == false || current!= null) {
            // 优先往左边走
            while(current!=null) {
                stack.push(new Pair<TreeNode,Integer>(current,++deep));
                current = current.left;
            }
            //若左边无路，就预备右拐。右拐之前，记录右拐点的基本信息
            current = stack.peek().getKey();
            deep = stack.peek().getValue();
            //预备右拐时，比较当前节点深度和之前存储的最大深度
            if(Maxdeep<deep) {Maxdeep=deep;};
            //将右拐点出栈；此时栈顶为右拐点的前一个结点。在右拐点的右子树全被遍历完后，会预备在这个节点右拐
            stack.pop();
            current=current.right;
        }
        return Maxdeep;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode level_2l = new TreeNode(9);
        TreeNode level_2r = new TreeNode(20);
        TreeNode level_3l = new TreeNode(15);
        TreeNode level_3r = new TreeNode(7);
        TreeNode node = new TreeNode(77);

        root.left = level_2l;
        root.right = level_2r;
        level_2l.left = new TreeNode(90); //v2
        level_2r.left = level_3l;
        level_2r.right = level_3r;
        level_3r.left = node; //v2

//        System.out.println(maxDepth( root));
        System.out.println(maxDepthV3( root));
    }
}
