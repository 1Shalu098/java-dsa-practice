import java.util.Stack;

public class Q_maxRectengular_Area {
    public static void maxrectengularArea(int arr[]){
        int maxarea = 0;
        int nrs [] = new int[arr.length];
        int nrl [] = new int[arr.length];
        // next smaller right 
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }if (s.isEmpty()) {
                nrs[i] = arr.length;
            }else{
                nrs[i] = s.peek();
            }
            s.push(i);
        }
        s = new Stack<>();
        for(int i=0; i<arr.length; i++){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }if (s.isEmpty()) {
                nrl [i] = arr.length;
            }else{
                nrl [i] = s.peek();
            }
            s.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            int heigth = arr[i];
            int weigth = nrs[i] - nrl[i]-1;
            int currArea = heigth*weigth;
            maxarea = Math.max( currArea , maxarea) ;
        }
        System.out.println(" max area : "+ maxarea);
    }
    public static void main(String[] args) {
        int arr [] ={2,1,5,6,2,3};
        maxrectengularArea(arr);
    }
}
