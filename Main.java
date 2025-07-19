import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        System.out.println("Input: [1,null,2,3], Output: " + solution.inorderTraversal(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(8);
        root2.right.right.left = new TreeNode(6);
        root2.right.right.right = new TreeNode(7);
        System.out.println("Input: [1,2,3,4,5,null,8,null,null,6,7,9], Output: " + solution.inorderTraversal(root2));

        TreeNode root3 = null;
        System.out.println("Input: [], Output: " + solution.inorderTraversal(root3));

        TreeNode root4 = new TreeNode(1);
        System.out.println("Input: [1], Output: " + solution.inorderTraversal(root4));
    }
}
