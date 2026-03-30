public class StackLinkedlist {
    static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class stacks {
    static node head = null;
    public static boolean isempty(){
        return head ==null;
    }
    // pop
    public static void pop(int data){
        node newnode = new node(data);
        if (isempty()) {
            head = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }
     // push
     public static int push(){
        if (isempty()) {
            System.out.println("stack is empty ");
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;
     }
     // peek
     public static int peek(){
        if (isempty()) {
            System.out.println("Stack is empty ");
            return -1;
        }
        return head.data;
     }
        
    }
    public static void main(String[] args) {
        stacks s = new stacks();
        s.pop(1);
        s.pop(2);
        s.pop(3);
        s.pop(4);
        s.pop(4);
        s.pop(5);
        s.pop(6);
         while (!s.isempty()) {
            System.out.println(s.peek());
            s.push();
         }
    }
}
