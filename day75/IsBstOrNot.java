import java.util.ArrayList;

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class IsBstOrNot {

	public static boolean isBST(BinaryTreeNode<Integer> root) {

		ArrayList<Integer> ans = new ArrayList<>();
		bruteForce(root, ans);
		for (int index = 0; index < ans.size() - 1; index++) {
			if (ans.get(index) > ans.get(index + 1)) {
				return false;
			}
		}
		return true;

	}

	private static void bruteForce(BinaryTreeNode<Integer> root, ArrayList<Integer> array) {

		if (root == null)
			return;

		bruteForce(root.left, array);
		array.add(root.data);
		bruteForce(root.right, array);
	}

}
