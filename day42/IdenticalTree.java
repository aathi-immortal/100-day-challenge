import java.util.ArrayDeque;
import java.util.ArrayList;


public class Solution {
    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {

        ArrayList<Integer> array1 = levelOrderTraversal(root1);
        ArrayList<Integer> array2 = levelOrderTraversal(root2);
        if(array1.size() != array2.size())
            return false;
        for(int i = 0;i<array1.size();i++)
        {
            if(array1.get(i) != array2.get(i))
            {
                return false;
            }
        }
        return true;
    }

    static ArrayList<Integer> levelOrderTraversal(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> array = new ArrayList<>();
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
        
                BinaryTreeNode<Integer> node = queue.poll();
                if (node.data == -1)
                    array.add(-1);
                else {
                    array.add(node.data);
                if (node.left == null)
                    queue.add(new BinaryTreeNode(-1));
                else
                    queue.add(node.left);
                if (node.right == null)
                    queue.add(new BinaryTreeNode(-1));
                else    
                    queue.add(node.right);
                }

    }
    return array;    
    }


    
}
