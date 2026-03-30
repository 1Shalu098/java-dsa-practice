public class DoubleLinked_list {
     class node {
    int data;
    node next;
    node prev;
    node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
   }
    public static node head;
    public static node tell;
    public void Addfirst(int data){
        node newnode = new node(data);
        if (head == null) {
            head = tell = newnode;
            return;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }
    public void print(){
        if (head == null) {
            System.out.println(" list is empty");
            return;
        }
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data+ "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    // remove first
    public int remove(){
        if (head == null) {
            System.out.println(" list is empty");
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        return val;
    }
        public void reversedll(){
            node curr = head;
            node prev = null;
            node next;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                curr.prev = next;
                prev = curr;
                curr = next;
            }
            head = prev;
        }
    
    public static void main(String[] args) {
        DoubleLinked_list dll = new DoubleLinked_list();
        dll.Addfirst(1);
        dll.Addfirst(2);     
        dll.Addfirst(3);
        dll.Addfirst(4);
        dll.Addfirst(5);
        // dll.print();
        // dll.remove();
         dll.print();
        dll.reversedll();
        dll.print();

    }
}
