package Leetcode_Qs_daily_solve;

  /* 

2404. Most Frequent Even Element (solve leetcode problem)

  Given an integer array nums, return the most frequent even element.

If there is a tie, return the smallest one. If there is no such element, return -1.

 

Example 1:

Input: nums = [0,1,2,2,4,4,1]
Output: 2
Explanation:
The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
We return the smallest one, which is 2.
Example 2:

Input: nums = [4,4,4,9,2,4]
Output: 4
Explanation: 4 is the even element appears the most.
Example 3:

Input: nums = [29,47,21,41,13,37,25,7]
Output: -1
Explanation: There is no even element.
  */

 public class Most_frequnt{
     public int mostFrequentEven(int[] nums) {
        int[] freq = new int[100001]; 

        int ans = -1;
        int maxfreq = 0;

        for (int num : nums) {
            if (num % 2 != 0) continue;

            freq[num]++;

            if (freq[num] > maxfreq || 
               (freq[num] == maxfreq && num < ans)) {
                maxfreq = freq[num];
                ans = num;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Most_frequnt obj = new Most_frequnt();
        int[] nums = {0,1,2,2,4,4,1};
        System.out.println(obj.mostFrequentEven(nums));
    }
}