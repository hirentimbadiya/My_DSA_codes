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
class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        helper(root , ans , new ArrayList<>());
        return ans;
    }
    public void helper(TreeNode root , List<List<Integer>> ans , List<Integer> tempList){
        // create a queue
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            // take size 
            int size = que.size();
            // add the nodes that comes in size
            for(int i = 0 ; i < size ; i++){
                // remove from queue 
                TreeNode node = que.poll();
                // add in tempList
                tempList.add(node.val);
                // add if there are childrens
                if(node.left != null){
                    que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
            }
            // add in ans
            ans.add(new ArrayList<>(tempList));
            // reset the tmepList
            tempList = new ArrayList<>();
        }
    }
}
