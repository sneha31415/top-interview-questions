package C12_linkedList;

import java.io.File;
import java.util.Scanner;

public class A1_LL_operations {
    public static Node insertAtFront(Node head, int data){
        Node newhead = new Node(data);
        newhead.next = head;
        head = newhead;
//   while the method can modify the object(i,e the remaining LL) through the reference,
//   if the method tries to change the reference itself(i,e the head), that change will not affect the original reference.
//   so we need to return the new reference to the head and make head in out  main() point to the new reference
        return head;
    }
    public static void printLL(Node head){
        Node ptr = head;
        while(ptr != null){
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println();
    }
    public static Node insertAtEnd(Node head, int data){
        if(head == null){
            return insertAtFront(head, data);
        }
//        travel to the tail of the LL
        Node ptr = head;
        while(ptr.next != null){
            ptr = ptr.next;
        }
        Node toinsert = new Node(data);
        ptr.next = toinsert;
        return head;
    }

    public static int LL_length(Node head){
        int length = 0;
        Node ptr = head;
        while(ptr != null){
            length ++;
            ptr = ptr.next;
        }
        return length;
    }

//    insert after p nodes in LL
    public static Node insert(Node head, int data, int p){
        if(head == null || p == 0){
            return insertAtFront(head, data);
        }
        else if(p > LL_length(head)){
            return insertAtEnd(head, data);
        }else {
            Node ptr = head;
            int steps = 1;
            while (steps < p) {
                ptr = ptr.next;
                steps += 1;
            }
            Node toinsert = new Node(data);
            toinsert.next = ptr.next;
            ptr.next = toinsert;
        }
        return head;
    }

//    in arrays to del the first elem,  either we waste a cell(leave it empty) or we need O(N) time to shift all elems
//    while in LL this is the advantage
    public static Node deleteFirstNode(Node head){
        if(head == null){
            return null;
        }
        Node newhead = head.next;
        head.next = null;
        return newhead;
    }

    public static Node deleteLastNode(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node ptr = head;
        Node prv = null;
        while (ptr.next != null){
            prv = ptr;
            ptr = ptr.next;
        }
        prv.next = null;
        return head;
    }

//    delete the p th node
    public static Node delete(Node head, int p){
        if(p == 0){
            return deleteFirstNode(head);
        }
        if(p > LL_length(head)){
            System.out.println("there are not " + p + " nodes in LL ");
            return head;
        }
//        make ptr stand at the node prev to the node that you want to delete
        int steps = 2;
        Node ptr = head;
        while(steps < p){
            ptr = ptr.next;
            steps++;
        }
        ptr.next = ptr.next.next;
        return head;
    }

    public static boolean search(Node head, int data){
        if(head == null){
            return false;
        }
        Node ptr = head;
        while (ptr != null){
            ptr = ptr.next;
            if(ptr.data == data){
                return true;
            }
        }
        return false;
    }

//    recursive approach
    public static boolean search_R(Node head, int data){
        if(head == null){
            return false;
        }
        if(head.data == data){
            return true;
        }
        return search_R(head.next, data);
    }

    public static Node takeInput(){
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int data = sc.nextInt();
        Node ptr = head;
        while(data != -1){
            if(ptr == null){
                head = insertAtFront(head, data);
                ptr = head;
            }else{
                ptr.next = new Node(data);
                ptr = ptr.next;
            }
            data = sc.nextInt();
        }
        return head;
    }


    public static void main(String[] args) {
        Node head = null;
        head = insertAtFront(head, 2);
        head = insertAtFront(head, 1);
        head = insertAtFront(head, 0);
        head = insertAtEnd(head, 4);
        head = insert(head, 3, 2);
        printLL(head);
        head = deleteFirstNode(head);
        printLL(head);
        head = deleteLastNode(head);
        printLL(head);
        head = delete(head, 2);
        printLL(head);
        System.out.println(search(head, 2));
        System.out.println(search_R(head, 2));

        Node head2 = takeInput();
        printLL(head2);
    }
}

