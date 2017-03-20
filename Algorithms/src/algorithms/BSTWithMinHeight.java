/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms;

/**
 *
 * @author farukmoralioglu
 * this algorithm creates a binary search tree with minimal height 
 * from a given integer array in ascending order and having distinct values
 * 
 */
public class BSTWithMinHeight {
    
    public TreeNode createBST(int[] arr){
        
        return createBSTHelper(arr, 0, arr.length - 1);
    }
    
    public TreeNode createBSTHelper(int[] arr, int start, int end){
        int mid = (start + end) / 2;
        if(mid < start || mid > end){
            return null;
        }
        TreeNode n = new TreeNode(mid);
        n.left = createBSTHelper(arr, start, mid - 1);
        n.right = createBSTHelper(arr, mid + 1, end);
        return n;
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
