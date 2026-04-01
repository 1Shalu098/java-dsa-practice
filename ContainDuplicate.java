import java.util.HashSet;


/* 
Quation: 217. Contains Duplicate in Leetcode;

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.


 */


public class ContainDuplicate {
     public 
     static boolean containsDuplicate(int[] nums) {
        int n= nums.length;
        HashSet<Integer> set = new HashSet<>();

        for( int i=0; i<n; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
       boolean result = containsDuplicate(nums);
        System.out.println(result);
    }
}
