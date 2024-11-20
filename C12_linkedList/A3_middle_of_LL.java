package C12_linkedList;
import static C12_linkedList.A1_LL_operations.takeInput;
import static C12_linkedList.A1_LL_operations.printLL;

public class A3_middle_of_LL {
//    one way is to find the length of LL and do it in two pass
//    the other way is one pass using two pointers fast and slow
    public static Node middle(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        Node head = takeInput();
        printLL(head);
        Node mid = middle(head);
        System.out.println(mid.data);
    }
}
