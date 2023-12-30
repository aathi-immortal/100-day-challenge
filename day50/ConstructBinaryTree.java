import java.util.ArrayList;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};

public class ConstructBinaryTree {
    public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {
                // traverse the preoder array 
                int start  =0;
                int end = inorder.length;
                int index = 0;
                ArrayList<Integer> nodes = new ArrayList<>();
                constructTree(start,end,inorder,preorder,index,nodes);
                return buildTree(nodes);
    }

    private static TreeNode buildTree(ArrayList<Integer> nodes) {

        
    }

    private static void constructTree(int start, int end, int[] inorder, int[] preorder, int index,ArrayList<Integer> nodes) {
            if(start > end)
            {
                nodes.add(-1);

            }
                
            int data  = preorder[index];
            nodes.add(data);
            int mid_index = getIndex(inorder,data);
            constructTree(start, mid_index - 1, inorder, preorder, mid_index, nodes);
            constructTree(mid_index + 1, end, inorder, preorder, mid_index, nodes);
    }

    private static int getIndex(int[] inorder, int data) {
        for(int i = 0;i<inorder.length;i++)
        {
            if(data == inorder[i])
                return i;
        }
        return -1;

    }
}
