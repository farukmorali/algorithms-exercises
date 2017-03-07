package algorithms;

/**
 *
 * @author farukmoralioglu
 */
public class LoopBeginning {

    //this algorithm detects a loop in a linked list 
    //and if there is a loop returns the starting point if the loop
    
    public ListNode beginningNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow){ // 
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        
        slow = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    
    
    class ListNode{
        public int data;
        public ListNode next;
        
        public ListNode(int data){
            this.data = data;
        }
    }
}
