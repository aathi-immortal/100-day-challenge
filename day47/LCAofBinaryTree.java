import java.util.ArrayList;
import java.util.List;

/************************************************************

 Following is the TreeNode class structure

 class TreeNode<T>
 {
     T data;
     TreeNode<T> left;
     TreeNode<T> right;

     TreeNode(T data)
     {
         this.data = data;
         left = null;
         right = null;
     }
 };

 ************************************************************/

public class Solution {
public static int lowestCommonAncestor(TreeNode root, int x, int y) {
        // get the path from the root node to the give x and y node
        // store it in the seperate array
        // compare it untill find the same value if found return it

        List<TreeNode> trackNodeX = new ArrayList<>();
        List<TreeNode> trackNodeY = new ArrayList<>();
        rootToLeafBuilder(root, trackNodeX, x);
        rootToLeafBuilder(root, trackNodeY, y);
        // display(trackNodeX);
        // display(trackNodeY);
        // return 2;
        return findFirstMatch(trackNodeX,trackNodeY);
    }
    private static void display(List<TreeNode> trackNode) {
        for(int data : trackNode)
        {   
                System.out.print(data + " ");
        }
        System.out.println();
    }
    private static int findFirstMatch(List<TreeNode> trackNodeX, List<TreeNode> trackNodeY) {
        int index = 0;
        int minSize = Math.min(trackNodeX.size(),trackNodeY.size());
        while(index < minSize)
        {
            if(trackNodeX.get(index).data != trackNodeY.get(index).data)
                return trackNodeX.get(index - 1);
            index++;
        }
        return trackNodeX.get( index - 1);
    }

    private static void rootToLeafBuilder(TreeNode root, List<TreeNode> trackedNode, int destination) {
        List<TreeNode> listOfPath = new ArrayList<>();
        rootToLeaf(root, trackedNode,listOfPath, destination);
    }

    private static void rootToLeaf(TreeNode root, List<TreeNode> trackedNode,List<TreeNode> listOfPath, int destination) {
        if (root == null)
            return;

        
        listOfPath.add(root.data);

        if (root.data == destination)
        {
            
            load(trackedNode,listOfPath);

        }

            // traverse untill destination is reached
        
            rootToLeaf(root.left, trackedNode,listOfPath, destination);

            rootToLeaf(root.right, trackedNode,listOfPath, destination);
            listOfPath.remove(listOfPath.size() - 1);   
            
        
        


    }
    static void load(List<TreeNode>list1,List<TreeNode> list2)
    {
        for(TreeNode data : list2)
        {
            list1.add(data);
        }
    }








}
