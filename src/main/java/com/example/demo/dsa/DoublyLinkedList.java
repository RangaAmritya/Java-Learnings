package com.example.demo.dsa;

public class DoublyLinkedList {

    Node head;
    Node tail;
    int length;

    class Node{
        Node next;
        Node prev;
        int value;

        public Node(int value){
            this.value=value;
        }
    }

    public DoublyLinkedList(int value){
        Node newNode= new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public void append(int value){
        Node newNode= new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
        length++;
    }


}
