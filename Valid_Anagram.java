 
/*
242. Valid Anagram   (leetcode Question)

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false
*/

 
 public class Valid_Anagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int arr [] = new int[26];
       for (int i=0; i<s.length(); i++ ){
           arr[s.charAt(i) - 'a']++;
       }
        for (int i=0; i<t.length(); i++ ){
           arr[t.charAt(i) - 'a']--;
       }
         for(int ch : arr){
            if(ch != 0){
                return false;
            }
         }
        
        return true;
    }
    public static void main(String[] args) {
        
        String s = "anagram", t = "nagaram";
       
        System.out.println(isAnagram(s, t));
    }
}