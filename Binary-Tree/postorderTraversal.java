class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root , res);
        return res;
    }
    public void postorder(TreeNode root , List<Integer> ans){
        if(root == null) return;
        
        postorder(root.left , ans);
        postorder(root.right , ans);
        ans.add(root.val);
    }
}
