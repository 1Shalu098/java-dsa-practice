import java.util.ArrayList;

public class StackArraylist {
    public static class stack {
    static ArrayList<Integer> list = new ArrayList<>();

    public static boolean isempty(){
        return list.size() == 0;
    }
        // pop
        public static void pop (int data){
          list.add(data);
        }
        // push
        public static int push(){
            int top = list.get(list.size() -1 );
            list.remove(list.size() -1);
            return top;
        }
        // peek
        public static int peek(){
            return list.get(list.size() -1);
        }
    }
    public static void main(String[] args) {
        stack s = new stack();
        s.pop(1);
        s.pop(2);
        s.pop(3);
        s.pop(4);
        s.pop(5);

        while (!s.isempty()) {
            System.out.println(s.peek());
            s.push();
        }

    }
}
