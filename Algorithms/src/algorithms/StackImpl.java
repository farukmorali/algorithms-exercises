/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms;


/**
 *
 * @author farukmoralioglu
 * A stack implementation using linked lists
 * implementing the methods pop, push, peek and isEmpty
 * @param <T>
 */
public class StackImpl<T> {
    private static class StackNode<T>{
        private final T data;
        private StackNode<T> next;
        
        public StackNode(T data){
            this.data = data;
        }
    }
    
    private StackNode<T> top;
    
    public T pop(){
        if(top == null)
            return (T) new Exception();
        
        T data = top.data;
        top = top.next;
        return data;
    }
    
    public void push(T item){
        StackNode<T> sn = new StackNode<>(item);
        sn.next = top;
        top = sn;
    }
    
    public T peek(){
        if(top == null)
            return (T) new Exception();
        return top.data;
    }
    
    public boolean isEmpty(){
        return top == null;
    }
}
