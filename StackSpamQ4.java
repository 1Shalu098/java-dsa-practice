import java.util.Stack;

public class StackSpamQ4 {
    public static void stackspam(int stack[], int sapam[]){
        Stack<Integer> s = new Stack<>();
        sapam[0] = 1;
        s.push(0);
        for (int i = 1; i < stack.length; i++) {
            int currentvVAl = stack[i];
            while (!s.isEmpty() && currentvVAl > stack[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                sapam[i] = i+1;
            }else{
                int preHigh = s.peek();
                sapam[i] = i- preHigh;
            }
            s.push(i);
        }

    }
    public static void main(String[] args) {
        int stack [] = {100, 80, 60, 70, 60, 85, 100};
        int sapam [] = new int[stack.length];
        stackspam(stack, sapam);
        for (int i = 0; i < sapam.length; i++) {
            System.out.println(sapam[i]+" ");
        }
    }
}
