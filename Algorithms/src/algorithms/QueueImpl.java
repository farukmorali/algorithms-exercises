/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms;

/**
 *
 * @author farukmoralioglu
 * Queue implementation using linked list
 * @param <T>
 */
public class QueueImpl<T> {
    private static class QueueNode<T>{
        private final T data;
        private QueueNode next;
        
        public QueueNode(T data){
            this.data = data;
        }
    }
    
    private QueueNode<T> first;
    private QueueNode<T> last;
    
    public void enqueue(T item){
        QueueNode<T> qn = new QueueNode<>(item);
        if(last != null){
            last.next = qn;           
        }
        last = qn;
        if(first == null){
            first = qn;
        }
    }
        
    public T dequeue() throws Exception{
        if(first == null){
            throw new NullPointerException();
        }
        T data = first.data;
        first = first.next;
        if(first == null){
            last = first;
        }
        return data;
    }
    
    public T peek(){
        if(first == null){
            throw new NullPointerException();
        }
        return first.data;
    }
        
    public boolean isEmpty(){
        return first == null;
    }
}
