/*
 * 796. Rotate String 

 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 * 
 * Example 1:
 * Input: s = "abcde", goal = "cdeab"
 * Output: true
 * Explanation: We can shift "abcde" to the right by 2 positions to get "cdeab".
 * 
 * Example 2:
 * Input: s = "abcde", goal = "abced"
 * Output: false
 * Explanation: We cannot get "abced" from "abcde" by shifting.
 * 
 * Constraints:
 * 1 <= s.length, goal.length <= 100
 * s and goal consist of lowercase English letters.
 */

public class Leetcode796{
     public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if(n!=m) return false;
        
        String str = s+s;

        if(str.indexOf(goal) != -1){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Leetcode796 solution = new Leetcode796();
        String s1 = "abcde";
        String goal1 = "cdeab";
        System.out.println(solution.rotateString(s1, goal1)); // Output: true

        String s2 = "abcde";
        String goal2 = "abced";
        System.out.println(solution.rotateString(s2, goal2)); // Output: false
    }
 }