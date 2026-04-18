 
 /*
1848. Minimum Distance to the Target Element (solve leetcode problem)

 Given an integer array nums (0-indexed) and two integers target and start, find an index i such that nums[i] == target and abs(i - start) is minimized. Note that abs(x) is the absolute value of x.

Return abs(i - start).

It is guaranteed that target exists in nums.

 

Example 1:

Input: nums = [1,2,3,4,5], target = 5, start = 3
Output: 1
Explanation: nums[4] = 5 is the only value equal to target, so the answer is abs(4 - 3) = 1.
Example 2:

Input: nums = [1], target = 1, start = 0
Output: 0
Explanation: nums[0] = 1 is the only value equal to target, so the answer is abs(0 - 0) = 0.
 */
 
//  package Leetcode_Qs_daily_solve;

public class Minmum_distance {
     public int getMinDistance(int[] nums, int target, int start) {
         int n = nums.length;
         int ans=Integer.MAX_VALUE;
         for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                int k =( Math.abs(i-start));
                  if(ans>k){
                ans=k;
            }
                
            }
         }
         return ans;
        }
        public static void main(String[] args) {
            Minmum_distance obj = new Minmum_distance();
            int[] nums = {1,2,3,4,5};
            int target = 5;
            int start = 3;
            System.out.println(obj.getMinDistance(nums, target, start));
        }
    
}
