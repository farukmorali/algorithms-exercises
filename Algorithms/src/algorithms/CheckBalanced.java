/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms;

/**
 *
 * @author farukmoralioglu
 * Checks whether the given tree is balanced or not
 * 
 */
public class CheckBalanced {
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        
        int heightDif = Math.abs(getHeight(root.left) - getHeight(root.right));
        
        if(heightDif > 1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftHeight = getHeight(root.left) + 1;
        int rightHeight = getHeight(root.right) + 1;
        
        return Math.max(leftHeight, rightHeight);
    }
}
