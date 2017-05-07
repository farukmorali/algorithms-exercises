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

        
public class PercolationStats {
    
    private double[] results;
    private int trials;
    
    public PercolationStats(int n, int trials){
        this.trials = trials;
        results = new double[trials];
        for(int i = 0; i < trials; i++){
            Percolation per = new Percolation(n);
            int numberOfOpenSites = 0;
            while(!per.percolates()){
                int row = StdRandom.uniform(1, n+1);
                int col = StdRandom.uniform(1, n+1);
                if(!per.isOpen(row, col)){
                    per.open(row, col);
                    numberOfOpenSites++;
                }
            }
            results[i] = numberOfOpenSites / (n*n);
        }
    }
    
    public double mean(){
        return StdStats.mean(results);
    }
    
    public double stdDev(){
        return StdStats.stddev(results);
    }
    
    public double confidenceLo(){
        return mean() - 1.96 * stdDev() / Math.sqrt(trials);
    }
    
    public double confidenceHi(){
        return mean() + 1.96 * stdDev() / Math.sqrt(trials);
    }
    
    public static void main(String[] args){
        
    }
}
