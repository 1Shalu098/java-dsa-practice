import java.util.Stack;

public class StackRev_string {
    public static String reverse(String str){
        Stack<Character> ch = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            char chr = str.charAt(idx);
            ch.push(chr);
            idx++;
        }
        StringBuilder result = new StringBuilder("");
          while (!ch.isEmpty()) {
            char curr = ch.pop();
            result.append(curr);
          }
         return result.toString();
    }
    public static void main(String[] args){
        String str = "abcd";
        System.out.println(reverse(str));
    }
}
