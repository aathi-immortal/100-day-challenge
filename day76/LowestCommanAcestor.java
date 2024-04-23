
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LowestCommanAcestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // traverse the tree
        TreeNode dummy = root;
        int smallValue = p.val > q.val ? q.val : p.val;
        int highValue = p.val < q.val ? q.val : p.val;
        while (dummy.val != p.val && dummy.val != q.val) {

            
            if(dummy.val > highValue)
            {
                //move to left subtree
                dummy = dummy.left;
            }
            else if(dummy.val < smallValue)
            {
                dummy = dummy.right;
            }
            else 
            {
                return dummy;
            }

        }
        return dummy;

    }

}
