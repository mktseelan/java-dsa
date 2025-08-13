package Stack;

public class CustomStack {
    protected int[] data;
    private int ptr;
    final static int DEFAULT_SIZE = 10;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size){
        data = new int[size];
        ptr = -1;
    }

    public boolean isFull(){
        return ptr == data.length -1; // ptr is at last index
    }

    public boolean isEmpty(){
        return ptr == -1;
    }

    public void push(int val) throws Exception{
        if(isFull()){
            System.out.println("Stack is full");
            throw new Exception("Stack Full");
        }
        ptr++;
        data[ptr] = val;
    }

    public int peek() throws Exception{
        if(isEmpty()){
            System.out.println("Stack is empty");
            throw new Exception("Stack empty cant peak");
        }
        return data[ptr];
    }

    public int pop() throws Exception{
        if(isEmpty()){
            System.out.println("Stack is empty");
            throw new Exception("Stack empty cant pop");
        }
        int val = data[ptr];
        ptr--;
        return val;
    }

}
