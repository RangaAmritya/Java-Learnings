package com.example.demo.dsa;

import java.util.ArrayList;

public class DSALearning {



    public static void main(String [] args){

        // Experiment with LinkedList class

        LinkedList linkedList = new LinkedList(4);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.append(10);
//        System.out.println(linkedList.findKthFromEnd(2).value);
//        linkedList.printList();
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(3);
        doublyLinkedList.append(8);

        doublyLinkedList.printList();
        ArrayList<Integer> arrayList= new ArrayList<>();

    }

}
