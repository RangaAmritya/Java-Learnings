package com.example.demo.dsa;

public class LinkedList {

    Node head;
    Node tail;
    int length;

    public LinkedList(int value){
         Node newNode = new Node(value);
         head=newNode;
         tail=newNode;
         length=1;
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
        length++;
    }

    public Node removeLast(){
        Node temp = head;
        Node pre = head;

        while(temp.next!=null){
            pre = temp;
            temp=temp.next;
        }
        tail=pre;
        tail.next=null;
        length--;
        if(length==0){
            head=null;
            tail=null;
        }
        return temp;

    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if(length==0)return null;
        Node temp =head;
        head = head.next;
        temp.next=null;
        length--;
        if(length==0){
            tail=null;
        }
        return temp;
    }
    public Node get(int index){

        if(index<0||index>=length){
            return null;
        }else{
            Node temp = head;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            return temp;
        }
    }

    public boolean set(int index,int value){
        Node temp = get(index);
        if(temp!=null){
            temp.value=value;
            return true;
        }
        return false;
    }

    public boolean insert(int index,int value){
        /**
         *
         * Four condition are there
         * 1. if index is less than 0 or greater than list length than should return false value;
         * 2. if index having value 0 this case will become prepend
         * 3. if index having value equal to length then it is same case as append \
         * 4. This is a new case should be implement using temp variable
         * */

        if(index<0 || index>length){
            return false;
        }
        if(index==0){
            prepend(value);
            return true;
        }
        if(index==length){
            append(value);
            return false;
        }
        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next=temp.next;
        temp.next=newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if(index<0||index>=length){
            return null;
        }
        if(index==0){
            return removeFirst();
        }
        if(index==length-1){
            return removeLast();
        }
        Node pre = get(index-1);
        Node temp = pre.next;

        pre.next=temp.next;
        temp.next=null;
        length--;
        return temp;
    }

    public void reverse(){
        /**
         * H        T
         * 4->6->7->10->null
         * 1 . first step to change H to T and vice versa using temp variable node
         * 2.  We are taking two(after and before) variable to swipe their position with their reference
         * */
        Node temp = head;
        head = tail;
        tail=temp;

        Node after = temp.next;
        Node before = null;

        for(int i=0;i<length;i++){
            after=temp.next;
            temp.next=before;
            before=temp;
            temp=after;
        }

    }

    public Node findKthFromEnd(int k) {
        Node slow = head; // Initialize slow pointer at head
        Node fast = head; // Initialize fast pointer at head

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) { // If k is out of bounds, return null
                return null;
            }
            fast = fast.next; // Move the fast pointer to the next node
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next; // Move the slow pointer to the next node
            fast = fast.next; // Move the fast pointer to the next node
        }

        return slow; // Return the kth node from the end (slow pointer)
    }

    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
    class Node {
        int value;
        Node next;

        Node(int value){
            this.value=value;
        }
    }

}
