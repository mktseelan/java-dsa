package Stack;

public class CustomQueue {
    private int[] data;
    private int end;
    public static final int DEFAULT_SIZE = 10;

    public CustomQueue(int size){
        this.data = new int[size];
        this.end = 0;
    }

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public void push(int val) throws Exception{
        if(isFull()){
            System.out.println("Queue Full");
            throw new Exception("Cannot enter into a full queue");
        }
        data[end++] = val;
    }

    public int pop() throws Exception{
        if(isEmpty()){
            System.out.println("Queue Empty");
            throw new Exception("Cannot pop from a empty queue");
        }
        int val = data[end];

        //move all element by one step
        for(int i=1 ; i < end ; i++){
            data[i - 1] = data[i];
        }
        end--;
        return val;
    }

    public boolean isEmpty(){
        return end == data.length;
    }

    public int front(){
        return data[0];
    }

    public boolean isFull(){
        return end == data.length;
    }

    public void display(){
        for(int i = 0 ;i<end ;i++){
            System.out.print(data[i] + " " + "->");
        }
        System.out.print("End");
        System.out.println();
    }

}
