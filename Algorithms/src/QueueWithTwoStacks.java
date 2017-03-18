
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author farukmoralioglu
 * A queue implementation using two stacks
 * 
 */
public class QueueWithTwoStacks {
    
    Stack<Integer> first;
    Stack<Integer> second;
    
    
    public QueueWithTwoStacks(){
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void enqueue(int value){
        first.push(value);
    }
    
    public int dequeue(){
        moveFromFirstToSecond();
        int value = second.pop();
        moveFromSecondToFirst();
        return value;
    }
    
    public int peek(){
        moveFromFirstToSecond();
        int value = second.pop();
        moveFromSecondToFirst();
        return value;
    }
    
    private void moveFromFirstToSecond(){
        while(!first.isEmpty()){
            second.push(first.pop());
        }
    }
    
    private void moveFromSecondToFirst(){
        while(!second.isEmpty()){
            first.push(second.pop());
        }
    }
}
