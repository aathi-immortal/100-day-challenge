/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<>();
      ArrayDeque<TreeNode> queue = new ArrayDeque<>();    
      if(root == null)
          return ans;
      queue.add(root);
      // level order traversal 
      List<Integer> tem = new ArrayList<>();
      while (!queue.isEmpty()) {
          TreeNode node = queue.poll();
          if(node.val == -1)
              tem.add(node.val);
          else
          {
              tem.add(node.val);
          if(node.left != null)
              queue.add(node.left);
          else
          {
              queue.add(new TreeNode(-1));
          }
          if(node.right != null)
              queue.add(node.right);
          else
              queue.add(new TreeNode(-1));
          }
      }
      

      
      int i = 0;
      int height = 0;
      boolean zigZag = false;
      while(i< tem.size())
      {
          int limit = (int)Math.pow(2,height);
          List<Integer> holder = new ArrayList<>();
          int start = i;
          while(i < tem.size() && i < limit + start)
          {
              int data = tem.get(i++);
              if(data != -1)
                  holder.add(data);
          }
          height++;
          if(zigZag)
              holder  = reverse(holder);
          zigZag = !zigZag;
          if(holder.size() != 0)
              ans.add(holder);
      }
      return ans;
      
  }
  static List<Integer> reverse(List<Integer> array)
  {
      List<Integer> ans  =new ArrayList<>();
      for(int i = array.size() - 1;i > -1;i--)
      {
          ans.add(array.get(i));
      }
      return ans;
  }
}




















