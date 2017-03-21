/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms;

import java.util.ArrayList;

/**
 *
 * @author farukmoralioglu
 * Algorithm that checks whether a given binary tree is binary search tree or not
 * 
 */
public class CheckBST {
    
    ArrayList<Integer> list = new ArrayList<>();
    
    public void copyToArray(TreeNode root){ //in order traversal
        if(root == null){
            return;
        }
        copyToArray(root.left);
        list.add(root.val);
        copyToArray(root.right);
    }
    
    public boolean isBST(TreeNode root){
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) > list.get(i+1)){
                return false;
            }
        }
        return true;
    }
}
