 
/*
3761. Minimum Absolute Distance Between Mirror Pairs (Medium Level Problem on Leetcode)

You are given an integer array nums.

A mirror pair is a pair of indices (i, j) such that:

0 <= i < j < nums.length, and
reverse(nums[i]) == nums[j], where reverse(x) denotes the integer formed by reversing the digits of x. Leading zeros are omitted after reversing, for example reverse(120) = 21.
Return the minimum absolute distance between the indices of any mirror pair. The absolute distance between indices i and j is abs(i - j).

If no mirror pair exists, return -1.

 

Example 1:

Input: nums = [12,21,45,33,54]

Output: 1

Explanation:

The mirror pairs are:

(0, 1) since reverse(nums[0]) = reverse(12) = 21 = nums[1], giving an absolute distance abs(0 - 1) = 1.
(2, 4) since reverse(nums[2]) = reverse(45) = 54 = nums[4], giving an absolute distance abs(2 - 4) = 2.
The minimum absolute distance among all pairs is 1.

Example 2:

Input: nums = [120,21]

Output: 1

Explanation:

There is only one mirror pair (0, 1) since reverse(nums[0]) = reverse(120) = 21 = nums[1].

The minimum absolute distance is 1.
*/
// package Leetcode_Qs_daily_solve;

import java.util.*;
  
public class Leetcode_3761_m{
     public int minMirrorPairDistance(int[] nums) {
        
        HashMap<Integer , Integer> map = new HashMap<>();
        int result =Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int current = nums[i];
            if(map.containsKey(current)){
                int prevIndx = map.get(current);
                result = Math.min(result, i- prevIndx);

            }
            int reverse = getreverse(current);
            map.put(reverse , i);
        }
        return result == Integer.MAX_VALUE ? -1: result;
    }
    private int getreverse(int num){
        int reverse = 0;
        while(num !=0){
            reverse = reverse*10 + num%10;
            num /= 10;
        }
        return reverse;
    }
       public static void main (String[] args) {
        Leetcode_3761_m obj = new Leetcode_3761_m();
        int[] nums = {1,12,11,10};
        System.out.println(obj.minMirrorPairDistance(nums));
    }
}