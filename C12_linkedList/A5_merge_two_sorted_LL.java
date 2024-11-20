package C12_linkedList;
import static C12_linkedList.A1_LL_operations.takeInput;
import static C12_linkedList.A1_LL_operations.printLL;
public class A5_merge_two_sorted_LL {

    //    IMPORTANT
    public static Node merge_2LL_recursively(Node l1, Node l2){
        if(l1 == null){
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Node c;
        if(l1.data < l2.data){
            c = l1;
            c.next = merge_2LL_recursively(l1.next, l2);
        }else{
            c = l2;
            c.next = merge_2LL_recursively(l1, l2.next);
        }
        return c;
    }
    public static Node merge_2LL(Node l1, Node l2){
        Node ptr1 = l1;
        Node ptr2 = l2;
        Node result = new Node();
        Node res = result;
        while(ptr1 != null && ptr2 != null){
            if(ptr1.data <= ptr2.data){
                result.next = ptr1;
                ptr1 = ptr1.next;
            }else{
                result.next = ptr2;
                ptr2 = ptr2.next;
            }
            result = result.next;
        }
        if(ptr1 != null){
            result.next = ptr1;
        }
        if(ptr2 != null){
            result.next = ptr2;
        }
        return res.next;
    }


    public static void main(String[] args) {
        Node head1 = takeInput();
        Node head2 = takeInput();
        printLL(head1);
        printLL(head2);
//        Node result = merge_2LL(head1, head2);
        Node result = merge_2LL_recursively(head1, head2);
        printLL(result);

    }
}
