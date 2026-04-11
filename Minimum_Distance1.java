
/*
3740. Minimum Distance Between Three Equal Elements I { solve leetcode problem )}

You are given an integer array nums.

A tuple (i, j, k) of 3 distinct indices is good if nums[i] == nums[j] == nums[k].

The distance of a good tuple is abs(i - j) + abs(j - k) + abs(k - i), where abs(x) denotes the absolute value of x.

Return an integer denoting the minimum possible distance of a good tuple. If no good tuples exist, return -1.

 

Example 1:

Input: nums = [1,2,1,1,3]

Output: 6

Explanation:

The minimum distance is achieved by the good tuple (0, 2, 3).

(0, 2, 3) is a good tuple because nums[0] == nums[2] == nums[3] == 1. Its distance is abs(0 - 2) + abs(2 - 3) + abs(3 - 0) = 2 + 1 + 3 = 6.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimum_Distance1 {
     public int minimumDistance(int[] nums) {

        // Map to store value -> list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        
        for (List<Integer> list : map.values()) {

            // Need at least 3 indices to form a valid triplet
            if (list.size() < 3) continue;

            
            for (int i = 0; i + 2 < list.size(); i++) {

                int firstIndex = list.get(i);
                int thirdIndex = list.get(i + 2);

                // distance = |i-j| + |j-k| + |k-i| = 2*(k - i)
                int distance = 2 * (thirdIndex - firstIndex);

                ans = Math.min(ans, distance);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public static void main(String[] args) {
        Minimum_Distance1 obj = new Minimum_Distance1();
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(obj.minimumDistance(nums));
    }
    
}
