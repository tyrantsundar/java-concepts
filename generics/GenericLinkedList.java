package generics;

import java.util.List;

public class GenericLinkedList<T> {

    private ListNode head;
    private int size = 0;

    GenericLinkedList(){
    }

    public void insert(T data){
        ListNode<T> newNode = new ListNode<>(data);
        size++;
        if(head == null){
            head = newNode;
        }else{
            ListNode<T> curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public void printList(){
        if(head == null){
            System.out.println("No data");
        }

        ListNode<T> curr = head;
        while (curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
    private class ListNode<T>{
        T data;
        ListNode next;

        ListNode(T data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        GenericLinkedList<String> stringGenericLinkedList = new GenericLinkedList<>();
        stringGenericLinkedList.insert("apple");
        stringGenericLinkedList.insert("banana");
        stringGenericLinkedList.insert("orange");
        stringGenericLinkedList.printList();

        GenericLinkedList<Integer> integerGenericLinkedList = new GenericLinkedList<>();
        integerGenericLinkedList.insert(1);
        integerGenericLinkedList.insert(2);
        integerGenericLinkedList.insert(3);
        integerGenericLinkedList.printList();
    }
}
