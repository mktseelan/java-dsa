package LinkedList;

public class Main {
    public static void main(String[] args) {
        LL LinkedList = new LL();

        for(int i = 10;i <=50 ;i = i + 10){
            LinkedList.addFirst(i);
        }
        LinkedList.display();

        for(int i = 10;i <=50 ;i = i + 10){
            LinkedList.addLast(i);
        }
        LinkedList.display();

        LinkedList.removeFirst();

        LinkedList.display();

        LinkedList.removeLast();

        LinkedList.display();

        LinkedList.insertRec(7 , 0 , LinkedList.getHead());

        LinkedList.display();

        System.out.println(LinkedList.size());
    }
}
