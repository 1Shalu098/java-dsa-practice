
/*
941. Valid Mountain Array (leetcode problem solve)

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

 

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
*/

// package Leetcode_Qs_daily_solve;

public class Valid_Mountain_Array {
     public boolean validMountainArray(int[] arr) {
        
        if(arr.length < 3) return false;
         
         int i = 0;
         int j= arr.length-1;
         while(i<j){
            if(arr[i+1] > arr[i]) {
                i++;
            }else if(arr[j-1] > arr[j]){
                j--;
            }else{
                break;
            }
         }
        return i != 0 && j != arr.length - 1 && i == j;
    }
        public static void main (String[] args) {
            Valid_Mountain_Array obj = new Valid_Mountain_Array();
            int[] arr = {0,3,2,1};
            System.out.println(obj.validMountainArray(arr));
        }

}
