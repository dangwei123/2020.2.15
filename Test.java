/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null){
            return root;
        }
        return left==null?right:left;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public String tree2str(TreeNode t) {
        if(t==null){
            return "";
        }
        if(t.left==null&&t.right==null){
            return t.val+"";
        }
        if(t.right==null){
            return t.val+"("+tree2str(t.left)+")";
        }
        return t.val+"("+tree2str(t.left)+")"+"("+tree2str(t.right)+")";
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(0,inorder.length,0,inorder.length,preorder,inorder,map);
    }
    private TreeNode buildTree(int p_s,int p_e,int i_s,int i_e,int[] preorder, int[] inorder,
    Map<Integer,Integer> map){
        if(p_s==p_e){
            return null;
        }
        int root_val=preorder[p_s];
        TreeNode root=new TreeNode(root_val);
        int i_val=map.get(root_val);
        int leftNum=i_val-i_s;
        root.left=buildTree(p_s+1,p_s+1+leftNum,i_s,i_val,preorder,inorder,map);
        root.right=buildTree(p_s+1+leftNum,p_e,i_val+1,i_e,preorder,inorder,map);
        return root;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index=inorder.length-1;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<=index;i++){
            map.put(inorder[i],i);
        }
        return buildTree(inorder,postorder,0,index,map);
    }
    private TreeNode buildTree(int[] inorder, int[] postorder,int start,int end,Map<Integer,Integer> map){
        if(start>end){
            return null;
        }
        int root_val=postorder[index];
        TreeNode root=new TreeNode(postorder[index--]);
        int inorder_val=map.get(root_val);
        root.right=buildTree(inorder,postorder,inorder_val+1,end,map);
        root.left=buildTree(inorder,postorder,start,inorder_val-1,map);
        return root;
    }
}

