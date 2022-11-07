import com.prog2.datastructures.SinglyLinkedList;
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
        DoublyLinkedList.Node ptr = head;

        while(i < index && ptr.next != null){
            ptr = ptr.next;
            i++;
        }

        return ptr.data;
    }

    @Override
    public List prepend(T element) {
        return null;
    }

    @Override
    public List append(T element) {
        return null;
    }

    @Override
    public List insert(int index, T element) {
        return null;
    }

    @Override
    public List remove(int index) {
        return null;
    }

    @Override
    public int indexOf(T element) {
        return 0;
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
