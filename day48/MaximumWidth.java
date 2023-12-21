import java.util.ArrayDeque;

/************************************************************
 * 
 * Following is the TreeNode class structure
 * 
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * 
 * TreeNode(int val) {
 * this.val = val;
 * this.left = null;
 * this.right = null;
 * }
 * }
 * 
 * 
 ************************************************************/
public class Solution {
    public static int getMaxWidth(TreeNode root) {
        // do the level order
        // tack the max widht
        int maxWidth = 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root == null)
            return 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodesLevel = queue.size();
            if (maxWidth < nodesLevel)
                maxWidth = nodesLevel;
            for (int i = 0; i < nodesLevel; i++) {
                if (queue.peek().left != null)
                    queue.add(queue.peek().left);
                if (queue.peek().right != null)
                    queue.add(queue.peek().right);
                queue.poll();
            }
        }
        return maxWidth;

    }
}