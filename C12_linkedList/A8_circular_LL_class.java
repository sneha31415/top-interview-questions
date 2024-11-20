package C12_linkedList;

public class A8_circular_LL_class {
    public static Node insert_at_head(Node head, int data){
        Node toInsert = new Node(data);
        if(head == null){
            toInsert.next = toInsert;
            return toInsert;
        }
        toInsert.next = head;

        Node temp = head;
//        find tail
        while(temp != null && temp.next != head){
            temp = temp.next;
        }
//        point tail to new head
        temp.next = toInsert;
//        return the new head
        return toInsert;
    }
    public static void print_circularLL(Node head){
        if(head ==  null){
            return;
        }
        Node temp = head;
        System.out.print(temp.data + "-> ");
        while(temp.next != head){
            temp  = temp.next;
            System.out.print(temp.data + "-> ");
        }
        System.out.println();
    }

//    function to get the node of a desired data
    public static Node getNode(Node head, int data){
        Node temp = head;
//        for all nodes except for the last node
        while (temp != null && temp.next != head){
            if(temp.data == data){
                return temp;
            }
            temp = temp.next;
        }
//        check for the last node
        if(temp.data == data){
            return temp;
        }
        System.out.println("node not present");
        return null;
    }

    public static Node deleteNode(Node head, int data){
        Node todelete = getNode(head, data);
        if(todelete == null || head == null){
            return head;
        }
        if(todelete == head){
//        update the head
            head = head.next;
        }
        Node temp = head;
        while(temp != null && temp.next != todelete){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        todelete.next = null;
        return head;
    }


    public static void main(String[] args) {
        Node head = null;
        head = insert_at_head(head, 0);
        print_circularLL(head);
        head = insert_at_head(head, 1);
        head = insert_at_head(head, 2);
        head = insert_at_head(head, 3);
        print_circularLL(head);
        head = deleteNode(head,1);
        print_circularLL(head);
        head = deleteNode(head,3);
        print_circularLL(head);

    }
}
