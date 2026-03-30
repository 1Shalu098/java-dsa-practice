public class QueuesLL {
    static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Queue {

     static node head = null;
     static node tell = null;

    public static boolean isempty(){
       return head ==null & tell==null;
    }
    public static void Add(int data){
        node newnode = new node(data);
        if (head == null) {
            head=tell=newnode;
        }
        tell.next = newnode;
        tell = newnode;

    }
    public static int remove(){
        if (isempty()) {
            System.out.println(" empty queues ");
            return -1;
        }
        int fornt = head.data;
        if (tell == head) {
            head = tell = null;
        }else{
            head = head.next;
        }
        return fornt;
    }
    public static int peek(){
        if (isempty()) {
            System.err.println("empty ");
            return -1;
        }
        return head.data;
    }
        
    }
    public static void main(String[] args) {
       Queue q = new Queue();
       q.Add(1);
      q.Add(2);
     q.Add(3);
     q.Add(4);
     q.Add(5);

     while (!q.isempty()) {
        System.out.println(q.peek());
        q.remove();
     }
       
    }
}
