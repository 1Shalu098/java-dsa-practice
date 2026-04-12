
/*
2418. Sort the People
 (https://leetcode.com/problems/sort-the-people/) { solve leetcode problem }

You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.

For each index i, names[i] and heights[i] denote the name and height of the ith person.

Return names sorted in descending order by the people's heights.

 

Example 1:

Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.
Example 2:

Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
Output: ["Bob","Alice","Bob"]
Explanation: The first Bob is the tallest, followed by Alice and the second Bob.
*/

import java.util.*;
public class Sort_people {

    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> map = new HashMap();

        for(int i=0; i<names.length; i++){
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        String ans[] = new String[names.length];
        int idx = 0;
        for(int i=heights.length-1; i>=0; i--){
            ans[idx] = map.get(heights[i]);
            idx++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Sort_people obj = new Sort_people();
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        System.out.println((obj.sortPeople(names, heights)));
    }
}