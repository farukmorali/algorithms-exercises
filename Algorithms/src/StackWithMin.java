
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author farukmoralioglu
 * Stack implementation which additionally returns the minimum value in the stack in constant time  
 */
public class StackWithMin extends Stack<Integer> {
    
    private final Stack<Integer> minStack;
    
    public StackWithMin(){
        minStack = new Stack<>();
    }
        
    public void push(int value){
        if(value < min()){
            minStack.push(value);
        }
        super.push(value);
    }
    
    @Override
    public Integer pop(){
        int value = super.pop();
        if(value == min()){
            minStack.pop();
        }
        return value;
    }
        
    private int min(){
        if(minStack.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return minStack.peek();
        }
    }
        
}
