public class Queues {
    public static class QueueB{
       static int arr [];
        static int rear;
        static int size;
        QueueB(int n){
            arr = new int[n];
            size = n;
            rear = -1;

        }
    
        public static boolean isempty(){
            return rear == -1;
        }
        public static void Add(int data){
            if (rear == size-1) {
                System.out.println("queue is full");
                return;
            }
            rear = rear+1;
            arr[rear] = data;
        }
        public static int remove(){
            if (isempty()) {
                System.out.println("Queues is empty");
                return -1;
            }
            int val = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear = rear-1;
            return val;
        }
        public static int peak(){
             if (isempty()) {
                System.out.println("Queues is empty");
                return -1;
            }
            return arr[0];
        }
    }
    public static void main(String[] args) {
          QueueB q = new QueueB(5);
      q.Add( 1);
      q.Add( 2);
      q.Add( 3);
      q.Add( 4);
      q.Add( 5);
      q.Add( 6);
      while (! q.isempty()) {
        System.out.println(q.peak());
        q.remove();
      }

  }
}  
