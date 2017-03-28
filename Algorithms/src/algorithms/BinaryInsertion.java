/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms;

/**
 *
 * @author farukmoralioglu
 * Inserts a given integer through given other integer between bits i and j
 * 
 */
public class BinaryInsertion {
    int insertBits(int n, int m, int i, int j){
        
        //first create the mask
        int allOnes = ~0;
        int leftMask = allOnes << (j+1);
        int rightMask = (1<<i) - 1;
        int mask = leftMask | rightMask;
        
        //clear bits i through j in n 
        int n_cleared = n & mask;
        //shift m to left by i bits
        int m_shifted = m<<i;
        
        return n_cleared | m_shifted;
    }
}
