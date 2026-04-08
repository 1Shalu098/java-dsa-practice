 
 /*

 541. Reverse String II ( solve leetcode problem  )
 
 Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

 

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"
 
 */
 public class Reverse_String2 {
    public String reverseStr(String s, int k) {
       char[]  arr = s.toCharArray();
    //   int i=0;
    //   int j=k-1;
     for (int start = 0; start < arr.length; start += 2 * k) {
            int i = start;
            int j = Math.min(start + k - 1, arr.length - 1);
      while(i<j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
     }
       String result = new String(arr);
    return result;

    }
    public static void main(String[] args) {       
        
        Reverse_String2 obj = new Reverse_String2();
        String s = "abcdefg";
        int k = 2;
        System.out.println(obj.reverseStr(s, k));
    }
 }