/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms;

/*
 *
 * @author farukmoralioglu
 * implements three stacks using one array and fixed stack sizes
 * 
 */

public class ThreeStacksInOne {
    private final int numberOfStacks = 3;
    private final int stackCapacity;
    private final int[] sizes;
    private final int[] values;
    
    public ThreeStacksInOne(int stackSize){
        
      this.stackCapacity = stackSize;
      values = new int[stackSize * numberOfStacks];
      sizes = new int[numberOfStacks];
    }
    
    public void push(int stackNum, int value) throws Exception{
        if(isFull(stackNum)){
            throw new Exception();
        }
            
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }
    
    public int pop(int stackNum) throws Exception{
        if(isEmpty(stackNum)){
            throw new Exception();
        }
        
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex]; 
        values[topIndex] = 0;  
        sizes[stackNum]--;
        return value;
    }
    
    public int peek(int stackNum) throws Exception{
        if(isEmpty(stackNum)){
            throw new Exception();
        }
        
        return values[indexOfTop(stackNum)];
    }
  
    private boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }
    
    private boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }
        
    private int indexOfTop(int stackNum){
        int offset = stackCapacity * stackNum;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
