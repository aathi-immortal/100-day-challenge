
class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class PreToTree {
    public static TreeNode preOrderTree(int[] preOrder) {
        int start = 0;
        int end = preOrder.length - 1;
        TreeNode head = new TreeNode();
        buildTree(preOrder, start, end, head);
        return head;
    }

    private static void buildTree(int[] preOrder, int start, int end, TreeNode head) {

        head.data = preOrder[start];

        // 1.split left and right subtree
        int numberOfLeftChilds = 0;

        int numberOfRightCHilds = 0;
        for (int index = start + 1; index <= end; index++) {
            if (preOrder[start] < preOrder[index]) {
                break;
            }
            numberOfLeftChilds++;
        }
        numberOfRightCHilds = (end - start) - numberOfLeftChilds;// one for parent node

        if (numberOfLeftChilds > 0) {
            head.left = new TreeNode();
            buildTree(preOrder, start + 1, start + numberOfLeftChilds, head.left);
        }
        if (numberOfRightCHilds > 0) {
            head.right = new TreeNode();
            buildTree(preOrder, end - numberOfRightCHilds + 1, end, head.right);
        }

    }

    public static void main(String[] args) {
        int[] array = { 8, 5, 1, 7, 10, 12 };
        TreeNode head = preOrderTree(array);

        System.out.println("finish " + head.data);
        inOrder(head);
    }

    private static void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.println(head.data);
        inOrder(head.right);
    }
}
