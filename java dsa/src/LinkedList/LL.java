package LinkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public void addFirst(int val){
        Node node = new Node(val);
        node.next = head ;
        head = node;

        if(tail == null){
            tail = head;
        }

        size++;
    }

    public Node getHead(){
        return head;
    }

    public Node insertRec(int val , int index , Node curr){
        if(index == 0 ){
            Node node  = new Node(val);
            node.next = curr;
            return node;
        }
        curr.next = insertRec(val , index - 1, curr.next );
        return curr;
    }

    public void addLast(int val){
        if(tail == null){
            addFirst(val);
            return;
        }
        Node node  = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public int removeFirst(){
        int val = -1;
        if(head != null) {
            val = head.val;
            head = head.next;
        }
        else {
            System.out.println("No Node's in list");
        }
        size--;
        return val;
    }

    public Node getNode(int val){
        Node temp = head;

        while(temp != null){
            if(temp.val == val)
                return temp;

            temp = temp.next;
        }

        return temp;
    }

    public int removeLast(){
        int val = -1;
        if(isEmpty()){
            System.out.println("List is empty");
            return val;
        }
        Node temp = head;
        int num = size - 1, i = 0;
        while( i < num-1) {
            temp = temp.next;
            i++;
        }
        val = temp.next.val;
        temp.next = null;
        tail = temp;
        size--;

        return val;

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void display(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    private class Node {
        public int val;
        public Node next;

        public Node(int val){
            this.val = val;
        }

        public Node(int val , Node node){
            this.val = val;
            this.next = node;
        }
    }
}