 /*
 485 Max Consecutive Ones (Leetcode Qs )

 Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 
 */

 package Leetcode_Qs_daily_solve;

class Max_Consecutive_Ones {

     public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int count2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
                count++;
            }else{
                count2 = Math.max(count2, count);
                count =0;
            }
        }
        count2 = Math.max(count2, count);
        return count2;
    }
        public static void main (String[] args) {
            Max_Consecutive_Ones obj = new Max_Consecutive_Ones();
            int[] nums = {1,1,0,1,1,1};
            System.out.println(obj.findMaxConsecutiveOnes(nums));
        }
}