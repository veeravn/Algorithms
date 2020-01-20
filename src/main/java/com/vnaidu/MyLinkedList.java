package com.vnaidu;

public class MyLinkedList {
    Node head; // head of the list

    /* Linked List node */
    private class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    private void printNthFromLast(Node head, int n)
    {
        int i = 0;
        if (head == null)
            return;
        printNthFromLast(head.next, n);
        if (++i == n)
            System.out.println(head.data);
    }

    /* Inserts a new Node at front of the list. */
    private void push(int newData)
    {

        Node newNode = new Node(newData);

        /* 3. Make next of new Node as head */
        newNode.next = head;

        /* 4. Move the head to point to new Node */
        head = newNode;
    }

    /*Drier program to test above methods */
    public static void main(String[] args)
    {
        MyLinkedList llist = new MyLinkedList();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(35);

        llist.printNthFromLast(llist.head,4);
    }
}
