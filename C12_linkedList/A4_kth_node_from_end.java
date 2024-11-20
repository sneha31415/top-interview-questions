package C12_linkedList;

import static C12_linkedList.A1_LL_operations.takeInput;
import static C12_linkedList.A1_LL_operations.printLL;

public class A4_kth_node_from_end {
    public static Node kth_from_end(Node head, int k){
        if(head == null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < k; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        Node head = takeInput();
        printLL(head);
        Node k = kth_from_end(head, 3);
        System.out.println(k.data);

    }
}
