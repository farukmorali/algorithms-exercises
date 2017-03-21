/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms;

/**
 *
 * @author farukmoralioglu
 * Finds the lowest common ancestor of two given nodes in a tree
 */
public class LowestCommonAncestor {
    
    public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b){
        
        if(root == null || root == a || root == b){
            return root;
        }
        
        boolean aIsOnLeft = contains(root, a);
        boolean bIsOnLeft = contains(root, b);
        
        if(aIsOnLeft != bIsOnLeft){
            return root;
        }
        
        TreeNode child = aIsOnLeft ? root.left : root.right;
        
        return LCA(child, a, b);
    }
    
    public boolean contains(TreeNode root, TreeNode node){
        if(root == null){
            return false;
        }
        if(root == node){
            return true;
        }
        return contains(root.left, node) || contains(root.right, node);
    }
}
