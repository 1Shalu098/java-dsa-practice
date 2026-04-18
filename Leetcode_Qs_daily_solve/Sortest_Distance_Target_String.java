// package Leetcode_Qs_daily_solve;

public class Sortest_Distance_Target_String {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans =  Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)){
                int diff= Math.abs(i-startIndex);
                int dist = Math.min(diff, n-diff);
                 ans = Math.min(ans, dist);
              
            }
        }
        return ans == Integer.MAX_VALUE ? -1: ans;
    }
       public static void main (String[] args) {
        Sortest_Distance_Target_String obj = new Sortest_Distance_Target_String();
        String[] words = {"hello","i","am","leetcode","hello"};
        String target = "hello";
        int startIndex = 1;
        System.out.println(obj.closestTarget(words, target, startIndex));
    }
}