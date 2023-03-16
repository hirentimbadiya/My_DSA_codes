import java.util.*;

public class CreateFromPostandIn {
    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        TreeNode node = buildTree(inorder, postorder);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        int postOrderIndex = n - 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        createMapping(map, inorder);

        TreeNode root = solve(inorder, postorder, postOrderIndex, 0, n - 1, map);
        return root;
    }

    static TreeNode solve(int[] in, int[] post, int index, int start, int end, HashMap<Integer, Integer> map) {
        if (index < 0 || start > end) {
            return null;
        }

        int element = post[index];
        TreeNode root = new TreeNode(element);

        int pos = map.get(element);
        // here we will pass index as index + pos - end - 1 to get the
        // element from the postorder array
        root.left = solve(in, post, index + pos - end - 1, start, pos - 1, map);
        root.right = solve(in, post, index - 1, pos + 1, end, map);

        return root;
    }

    static void createMapping(HashMap<Integer, Integer> map, int[] in) {
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
    }
}
