/**
 * SinglyLinkedList
 */

public class SinglyLinkedList implements LinkedList{

    public Node head,tail;
    private int size=0;

    public SinglyLinkedList(){
        head=tail=null;
    }
    public boolean isEmpty(){
        return(size==0);
    }
    public int size(){
        return size;
    }
    public void addFirst(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            baru.pointer = head;
            head = baru;
            size++;
        }
    }

    public void addLast(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            tail.pointer = baru;
            tail = baru;
            size++;
        }
    }

    public void addAfter(int index,Object inputData){
        Node baru = new Node(inputData);
        Node C=head;
        for(int i=0;i<index;i++){
            C = C.pointer;
        }
        baru.pointer = C.pointer;
        C.pointer = baru;
    }

    public void deleteFirst(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            head = head.pointer;
            size--;
        }
    }

    public void deleteLast(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=1;i<size;i++){
                temp = temp.pointer;
            }
            tail = temp;
            tail.pointer = null;
            size--;
        }
    }

    public void deleteAfter(int index){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=0;i<index;i++){
                temp = temp.pointer;
            }
            temp.pointer = temp.pointer.pointer;
            size--;
        }
    }

    public void print(){
        Node currentNode = head;
        for(int i =0;i<size;i++){
            System.out.println(currentNode.data);
            currentNode = currentNode.pointer;
        }
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.pointer;
        }

        return currentNode.data;
    }

    @Override
    public int indexOf(Object targetData) {
        Node currentNode = head;
        int index = 0;

        while (currentNode != null) {
            if (currentNode.data == null
                    ? targetData == null
                    : currentNode.data.equals(targetData)) {
                return index;
            }

            currentNode = currentNode.pointer;
            index++;
        }

        return -1;
    }

    @Override
    public void printReverse() {
        printReverseRecursive(head);
    }

    private void printReverseRecursive(Node currentNode) {
        if (currentNode == null) {
            return;
        }

        printReverseRecursive(currentNode.pointer);
        System.out.println(currentNode.data);
    }

    @Override
    public boolean remove(Object targetData) {
        Node currentNode = head;
        Node previousNode = null;

        while (currentNode != null) {
            boolean isMatch = currentNode.data == null
                    ? targetData == null
                    : currentNode.data.equals(targetData);

            if (isMatch) {
                if (currentNode == head) {
                    head = currentNode.pointer;
                } else {
                    previousNode.pointer = currentNode.pointer;
                }

                if (currentNode == tail) {
                    tail = previousNode;
                }

                size--;
                return true;
            }

            previousNode = currentNode;
            currentNode = currentNode.pointer;
        }

        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node currentNode = head;

        for (int i = 0; i < size; i++) {
            array[i] = currentNode.data;
            currentNode = currentNode.pointer;
        }

        return array;
    }
}
