 // next gretet element 

import java.util.Stack;

public class StackNextGreter {
    public static void NextGreter(int arr[], int ans []) {
        Stack<Integer> s = new Stack<>();
       // ans[] = 
        for (int i = arr.length-1; i >= 0; i--) {
            //int curr = arr[i];
            while (!s.isEmpty()&& arr[s.peek()] <= arr[i]) {
                s.pop();
            }   
            if (s.isEmpty()) {
                ans[i] =-1;
                
            }else{
                int currentvVAl = arr[s.peek()];
                ans[i] = currentvVAl;
            }
            s.push(i);
           
        }   
    }
    
    public static void main(String[] args) {
        int arr [] = {6, 8, 0, 1, 3};
        int ans [] = new int[arr.length];
        NextGreter(arr, ans);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(+ans[i]+" ");
        }
       System.out.println();
    }
}
