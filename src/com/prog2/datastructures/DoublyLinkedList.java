package com.prog2.datastructures;

import com.prog2.interfaces.List;

public class DoublyLinkedList<T> implements List<T> {

    /**
     * A doubly liked list implementation. Nodes have a previous connection AND
     * a next connection.
     *
     * There is more memory overhead in a doubly linked list than a singly linked list.
     * This is useful in only particular cases where forward AND backward traversal
     * are necessary.
     *
     * For example, a browser uses a doubly linked list in order to allow you to
     * have a forward and backward button.
     *
     * @return
     */

    private int count;
    private Node head;
    private Node tail;

    public DoublyLinkedList(){
        count = 0;
        head = null;
        tail = null;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getLength() {
        return count;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= count){
            throw new IndexOutOfBoundsException();
        }

        int i = 0;
        Node ptr = head;

        while(i < index && ptr.next != null){
            ptr = ptr.next;
            i++;
        }

        return ptr.data;
    }

    @Override
    public List prepend(T element) {

        Node n = new Node(element);

        if(isEmpty()){
            head = n;
            tail = n;
        }else{
            n.next = head;
            head.prev = n;
            head = n;
        }

        count++;
        return this;
    }

    @Override
    public List append(T element) {

        Node n = new Node(element);

        if(isEmpty()){
            head = n;
            tail = n;
        }else{
            tail.next = n;
            n.prev = tail;
            tail = n;
        }

        count++;
        return this;
    }

    @Override
    public List insert(int index, T element) {

        Node n = new Node(element);

        if(isEmpty()){
            head = n;
            tail = n;
        }

        if(index == 0){
            prepend(element);
        }else if(index == count - 1){
            append(element);
        }

        Node ptr = head;

        for (int i = 0; i < index - 1; i++) {
            ptr = ptr.next;
        }

        n.prev = ptr;
        n.next = ptr.next;
        ptr.next = n;
        n.next.prev = n;

        count++;
        return this;
    }

    @Override
    public List remove(int index) {

        if(isEmpty()){
            return null;
        }

        Node ptr = head;

        //get ptr to the index we need to remove
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }

        //once at that index
        for (int i = index; i < count - 1; i++) {
            //set the index's data we're on to the next index's data
            ptr.prev = ptr.next;
            ptr.data = ptr.next.data;
            //move to the next index
            ptr = ptr.next;

            //once we're at the new tail, set the tail's ptr
            if (i == count - 2){
                ptr = tail;
                break;
            }
        }

        count--;
        return this;
    }

    @Override
    public int indexOf(T element) {

        Node ptr = head;

        for (int i = 0; i < count - 1; i++) {
            if(ptr.data == element){
                return i;
            }else{
                ptr = ptr.next;
            }
        }
        return -1;
    }

    private class Node{

        private T data;
        private Node next;
        private Node prev;

        Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
