package C12_linkedList;

import static C12_linkedList.A1_LL_operations.takeInput;
import static C12_linkedList.A1_LL_operations.printLL;

public class A2_reverse_LL {
    public static Node reverseLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node ahead;
        Node prev = null;
        while(head != null){
//            store the next
            ahead = head.next;
//            reverse connection
            head.next = prev;
//            update
            prev = head;
            head = ahead;
        }
        return prev; // reversed head
    }

//    tc = O(n^2)
//    O(n) for recursion and O(n) for while loop in each recursive call
    public static Node reverseLLrecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }
//        ask recursion to reverse the remaining LL
        Node smallHead = reverseLLrecursive(head.next);
        Node temp = smallHead;
//        reach original head from reversed part head
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        head.next = null;
        return smallHead;
    }
    public static Node reverseLLrecursiveOptimised(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newhead = reverseLLrecursiveOptimised(head.next);
//        temp is nothing but "head.next"
        head.next.next = head;
        head.next = null;
        return newhead;
    }

    public static void main(String[] args) {
        Node head = takeInput();
        printLL(head);
//        Node reversehead = reverseLL(head);
//        printLL(reversehead);

        Node r = reverseLLrecursive(head);
        printLL(r);
    }

}
