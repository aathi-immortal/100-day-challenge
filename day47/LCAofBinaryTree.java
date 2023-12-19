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
public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
        // get the path from the root node to the give x and y node
        // store it in the seperate array
        // compare it untill find the same value if found return it

        List<Integer> trackNodeX = new ArrayList<>();
        List<Integer> trackNodeY = new ArrayList<>();
        rootToLeafBuilder(root, trackNodeX, x);
        rootToLeafBuilder(root, trackNodeY, y);
        // display(trackNodeX);
        // display(trackNodeY);
        // return 2;
        return findFirstMatch(trackNodeX,trackNodeY);
    }
    private static void display(List<Integer> trackNode) {
        for(int data : trackNode)
        {   
                System.out.print(data + " ");
        }
        System.out.println();
    }
    private static int findFirstMatch(List<Integer> trackNodeX, List<Integer> trackNodeY) {
        int index = 0;
        int minSize = Math.min(trackNodeX.size(),trackNodeY.size());
        while(index < minSize)
        {
            if(trackNodeX.get(index) != trackNodeY.get(index))
                return trackNodeX.get(index - 1);
            index++;
        }
        return trackNodeX.get( index - 1);
    }

    private static void rootToLeafBuilder(TreeNode<Integer> root, List<Integer> trackedNode, int destination) {
        List<Integer> listOfPath = new ArrayList<>();
        rootToLeaf(root, trackedNode,listOfPath, destination);
    }

    private static void rootToLeaf(TreeNode<Integer> root, List<Integer> trackedNode,List<Integer> listOfPath, int destination) {
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
    static void load(List<Integer>list1,List<Integer> list2)
    {
        for(int data : list2)
        {
            list1.add(data);
        }
    }








}
