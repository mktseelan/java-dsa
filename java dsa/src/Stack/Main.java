package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomStack st = new CustomStack(20);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);

        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());

        CustomQueue q = new CustomQueue(20);
        q.push(20);
        q.push(30);
        q.push(40);
        q.push(50);
        q.push(60);

        q.pop();

        q.push(788);

        q.display();

        List<Integer> = new ArrayList<>();



    }
}
