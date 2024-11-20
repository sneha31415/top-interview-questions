package C12_linkedList;

import static C12_linkedList.A1_LL_operations.printLL;
import static C12_linkedList.A1_LL_operations.takeInput;
import static C12_linkedList.A5_merge_two_sorted_LL.merge_2LL;
import static C12_linkedList.A3_middle_of_LL.middle;

public class A6_merge_sort_on_LL {
    public static Node merge_sort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
//      divide the LL in two parts
        Node otherhalf = slow.next;
        slow.next = null;
//        recursively sort the two parts
        Node l1 = merge_sort(head);
        Node l2 = merge_sort(otherhalf);
//        merge the two sorted
        return merge_2LL(l1, l2);

    }
    public static Node merge_sort2(Node head){
        if(head == null || head.next == null){
            return head;
        }
//        get the middle of LL
        Node mid = middle(head);

//      divide the LL in two parts
        Node l1 = head;
        Node l2 = mid.next;
        mid.next = null;

//        recursively sort the two parts
        l1 = merge_sort(l1);
        l2 = merge_sort(l2);

//        merge the two sorted parts
        return merge_2LL(l1, l2);

    }

    public static void main(String[] args) {
        Node head = takeInput();
        printLL(head);
        head = merge_sort2(head);
        printLL(head);
    }
}
