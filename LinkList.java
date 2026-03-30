public class LinkList {
    public static class node{
        int data;
        node next;
        public  node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static node head;
    public static node tell;
    // find the size 
    public static int size(){
      int count =0;
       // node newnode = new node();
        node temp = head;
        while (temp !=null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    // add at first 
    public  void addfirst(int data){
        node newnode = new node(data);
        if (head == null) {
            head= tell = newnode;
            return;
        }
        newnode.next =head;
        head = newnode;
    }

    // add at last
    public  void addlast(int data){
        node newnode = new node(data);
        if (head==null) {
            head = tell= newnode;
            return;
        }
        tell.next = newnode;
        tell = newnode;
    }

    // print the linked list
    public  void print (){
        if (head == null) {
            System.out.println(" empty ");
            return;
        }
        node temp = head;
        while (temp != null ) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");

    }

    // add At index
    public void addAtindx(int idx, int data){
        node newnode = new node(data);
        node temp = head;
        int i =0;
        while (i < idx-1) {
            temp = temp.next;
            i++;
        }
        newnode.next= temp.next;
        temp.next = newnode;
        
    }

    // add middel
    public  void addMiddle(int data){
        int mid = size()/2;
         node newnode = new node(data);
         int i=0;
         node temp = head;
         while (i < mid-1) {
            temp = temp.next;
            i++;
         }
         newnode.next = temp.next;
         temp.next = newnode;
    }

    // remove first 
    public int removefirst(){
        if (size()==0) {
            System.out.println(" linked list is empty ");
            return Integer.MIN_VALUE;
        }else if(size()==1){
            int val= head.data;
            head = tell = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        return val;
    }

// remove last 
    public int removelast(){
        if (size() == 0) {
            System.out.println("linked list is empty ");
            return Integer.MIN_VALUE;
        }else if (size()==1) {
            int val = head.data;
            head= tell=null;
            return val;
        }
        node pre = head;
        for (int i = 0; i <size()-2; i++) {
            pre = pre.next;
        }
        int val = pre.data;
        pre.next = null;
        tell = pre;
        return val;
    }

    // searching for index in key
    public int search(int key){
        node temp = head;
        int i=0;
         while (temp !=null) {
            if (temp.data==key) {
                return i;
            }
              temp = temp.next;
              i++;
            
         }
         return -1;
    }

    // recursive search 
    public int helper( node head , int key){
        if(head == null){
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx ==-1){
            return -1;
        }
        return idx+1;
    }
    public int recsearch(int key ){
        return helper(head, key);
    }
     // remove nth node to ende
     public void removeNth(int n){
        node temp = head;
        int sz = 0;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        if (n == sz) {
            head = head.next; // remove head
            return;
        }
        int i =0;
        int iNth = sz-n+1;
        node pre = head;
        while (i < iNth-1) {
            pre = pre.next;
            i++;
        }
        pre.next = pre.next.next;
        return;
     }

     // check palindrome 
     public boolean palindrome(){
        if (head == null || head.next == null) {
            return true;
        }
        // find mid
        node slow = head;
        node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // reverse second half
        node pre = null;
        node curr = slow;
        node next;
        while (curr != null ) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        node right = pre;
        node left = head;
        while(right != null){
            if (right.data != left.data) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
     }

     // chech linked list is cycle
     public static  boolean iscycle(){ // floyd's algorithm
        node slow = head;
        node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast= fast.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
     }
     // remove cycle 
     public static void removecycle(){
        node slow = head;
        node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if ( cycle == false) {
            return;
        }
        slow = head;
        node pre = null;
        while (slow != fast) {
            pre = fast;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = null;

     }

     // merge sort 
     public node getmid(node head){ // get mide 
        node slow = head;
         node fast = head.next;
         while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
         }
         return slow;
     }
     public node merge(node head1, node head2){
        node mergedl = new node(-1);
        node temp = mergedl;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
             temp.next = head1;
                head1 = head.next;
                temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
        }
        return mergedl.next;
     }
     public node mergesort(node head){
        if (head == null || head.next == null) {
            return head;
        }
        node mide = getmid(head);
        node rigthhead = mide.next;
        mide.next = null;
        node newleft = mergesort(head);
        node newright = mergesort(rigthhead);
        return merge(newleft, newright);
     }

     // zig zag 
     public void zigzag(){
        node slow = head;
        node fast =  head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        node mide = slow;
        node curr = mide.next;
        mide.next = null;
        node pre = curr;
        node next;
        while(curr != null){
            next = curr.next;
            curr.next = pre;
            pre =curr;
            curr = next;
        }
        node left = head;
        node right = pre;
        node nextl , nextR;
        while (left != null && right !=null) {
            nextl = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextl;
            left  = nextl;
            right = nextR;
        }
     }
    public static void main(String[] args) {
       LinkList ll = new LinkList();
      
        ll.addlast(1);
         ll.addlast(2);
          ll.addlast(3);
           ll.addlast(4);
            ll.addlast(5);
            ll.addlast(6);
       
//         ll.print();
//         System.out.println(size());
//         ll.addMiddle(8);
//         ll.print();
//         ll.removefirst();
//         ll.print();
//         ll.removelast();
//         ll.print();
//     System.out.println(ll.search(8));
//         System.out.println(ll.recsearch(8));
//         ll.removeNth(3);
//         ll.print();
//         System.out.println(ll.palindrome());
          // System.out.println(iscycle());
           //removecycle();
          // System.out.println(iscycle());
          ll.print();
         // ll.head =
        //   
        ll.zigzag();
        ll.print();
     }
 }
