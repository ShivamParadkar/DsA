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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        
        int type = 0;
        while(!q.isEmpty()){
            int prevNum = -1;
            int  sz = q.size();
            for(int i=0;i<sz;i++){
                TreeNode n = q.peek();
                q.poll();
                
                if(type%2==0){
                    if(n.val%2==0){
                        return false;
                    }
                    else if(prevNum!=-1 && n.val<=prevNum)
                    {
                        return false;
                    }
                }
                else if(type%2==1){
                    if(n.val%2==1){
                        return false;
                    }
                    else if(prevNum!=-1 && n.val>=prevNum)
                    {
                        return false;
                    }
                }
                
                prevNum = n.val;
                
                // System.out.println(n.val);
                
                
                if(n.left != null){
                    q.offer(n.left);
                }
                
                if(n.right != null){
                    q.offer(n.right);
                }
            }
            type++;
        }
        
        return true;
    }
}
