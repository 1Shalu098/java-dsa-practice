 /*
 1748. Sum of Unique Elements( solve leetcode problem )
 
 You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.

Return the sum of all the unique elements of nums.

 

Example 1:

Input: nums = [1,2,3,2]
Output: 4
Explanation: The unique elements are [1,3], and the sum is 4.
Example 2:

Input: nums = [1,1,1,1,1]
Output: 0
Explanation: There are no unique elements, and the sum is 0.
 
 */
 
 public class Sum_unique_elemet {
    public int sumOfUnique(int[] nums) {
        int sum =0;
       int freq [] = new int[101];
       for(int num : nums){
           freq[num]++;
       }
       for(int i=0; i<freq.length; i++){
        if(freq[i] == 1){
            sum += i;
        }
       }
        return sum;
    }
    public static void main(String[] args) {       
        
        Sum_unique_elemet obj = new Sum_unique_elemet();
        int[] nums = {1,2,3,2};
        System.out.println(obj.sumOfUnique(nums));
    }
    
}
