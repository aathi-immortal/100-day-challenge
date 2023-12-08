import java.util.*;
/*************************************************************

     Following is thr TreeNode class structure

     class BinaryTreeNode<T>
     {
         T data;
         BinaryTreeNode<T> left;
         BinaryTreeNode<T> right;

         BinaryTreeNode(T data) {
             this.data = data;
             left = null;
             right = null;
         }
     };

 *************************************************************/
public class HeightBlanced {

    public static boolean isBalancedBT(TreeNode<Integer> root) {
        // find the left child node height
        // and right child node height
                
    
            return checkHeightBlanced(root) != -1;
        
        
    }
    public static int checkHeightBlanced(TreeNode<Integer>root)
    {
        if(root == null)
            return 0;
        int leftHeight = checkHeightBlanced(root.left);
        if(leftHeight == -1)
            return -1;
        int rightHeight = checkHeightBlanced(root.right);
        if(rightHeight == -1)
            return -1;
        int height = Math.max(leftHeight,rightHeight) + 1;
        if(Math.abs(leftHeight - rightHeight)> 1){
            
            return -1;
        }   

            
        return height;
    }
}













