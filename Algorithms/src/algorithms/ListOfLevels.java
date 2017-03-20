/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author farukmoralioglu
 * algorithm that creates and returns a list of list, 
 * which (inner list) contains the nodes at each level of a binary tree
 * 
 */
public class ListOfLevels {
    
    ArrayList<LinkedList<TreeNode>> createLevelList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> res = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        
        if(root != null){
            current.add(root);
        }
            
        while(current.size() > 0){
            res.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for(TreeNode parent : parents){
                if(parent.left != null){
                    current.add(parent.left);
                }       
                if(parent.right != null){
                    current.add(parent.right);
                } 
            }
        }
            
        return res;
    }
    
    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(int v){
            this.val = v;
        }
    }
}
