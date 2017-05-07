/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package percolation;

/**
 *
 * @author farukmoralioglu
 */
public class Percolation {

    /**
     */
    
    private final boolean[][] isOpen;
    WeightedQuickUnionWithPathCompressionUF wuf;
    private int numberOfOpenSites;
    int n;
    
    public Percolation(int n){
        wuf = new WeightedQuickUnionWithPathCompressionUF(n*n + 2);
        numberOfOpenSites = 0;
        isOpen = new boolean[n][n];
        this.n = n;
        
        for(int i = 0; i < isOpen.length; i++){
            for(int j = 0; j < isOpen[i].length; j++){
                isOpen[i][j] = false;
            }
        }
        
        for(int x = 0; x < n; x++){
            wuf.union(0, x + 1);
        }
        
        for(int y = 0; y < n; y++){
            wuf.union((n*n)+1,(((n-1)*n)+y + 1));
        }
    }
    
    public void open(int row, int col){
        validate(row, col);
        int siteNumber = getSiteNumber(row, col);
        
        numberOfOpenSites++;
        isOpen[row - 1][col -1] = true;
        
        if((row - 2 >= 0) && (col - 1 >= 0) && isOpen[row - 2][col - 1]){
            wuf.union(siteNumber, siteNumber - n);
        }
        if((row < n) && (col - 1 >= 0) && isOpen[row][col - 1]){
            wuf.union(siteNumber, siteNumber + n);
        }
        if((row - 1 >= 0) && (col - 2 >= 0) && isOpen[row - 1][col - 2]){
            wuf.union(siteNumber, siteNumber - 1);
        }
        if((row - 1 >= 0) && (col < n) && isOpen[row - 1][col]){
            wuf.union(siteNumber, siteNumber + 1);
        }
    }
    
    public boolean isOpen(int row, int col){
        validate(row, col);
        return isOpen[row - 1][col - 1];
    }
    
    public boolean isFull(int row, int col){
        validate(row, col);
        int siteNumber = getSiteNumber(row, col);
        return isOpen(row, col) && wuf.isConnected(0, siteNumber);
    }
    
    public int numberOfOpenSites(){
        return numberOfOpenSites;
    }
    
    public boolean percolates(){
        return wuf.isConnected(0, n*n+1);
    }
    
    private void validate(int row,  int col){
        if(row - 1 < 0 || row > n || col - 1 < 0 || col > n){
            throw new java.lang.IndexOutOfBoundsException();
        }
    }
    private int getSiteNumber(int row, int col){
        return (row - 1)*n + col;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
}
