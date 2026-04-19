
/*

1855. Maximum Distance Between a Pair of Values{Medium Level Problem on Leetcode }

You are given two non-increasing 0-indexed integer arrays nums1​​​​​​ and nums2​​​​​​.

A pair of indices (i, j), where 0 <= i < nums1.length and 0 <= j < nums2.length, is valid if both i <= j and nums1[i] <= nums2[j]. The distance of the pair is j - i​​​​.

Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.

An array arr is non-increasing if arr[i-1] >= arr[i] for every 1 <= i < arr.length.

 

Example 1:

Input: nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
Output: 2
Explanation: The valid pairs are (0,0), (2,2), (2,3), (2,4), (3,3), (3,4), and (4,4).
The maximum distance is 2 with pair (2,4).
Example 2:

Input: nums1 = [2,2,2], nums2 = [10,10,1]
Output: 1
Explanation: The valid pairs are (0,0), (0,1), and (1,1).
The maximum distance is 1 with pair (0,1).
Example 3:
*/
public class Leetcode_1855_Q {
     public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        int result =0;
        while(i<n && j<m){
            if(nums1[i] > nums2[j]){
                i++;
            }else{
                result = Math.max(result, j-i);
                j++;
            }
        }
        return result;
    }
        public static void main(String[] args) {
            Leetcode_1855_Q obj = new Leetcode_1855_Q();
            int[] nums1 = {55,30,5,4,2};
            int[] nums2 = {100,20,10,10,5};
            System.out.println(obj.maxDistance(nums1, nums2));
        }
}
