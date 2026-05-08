
/*
* 3629. Minimum Jumps to Reach End via Prime Teleportation

You are given an integer array nums of length n.

You start at index 0, and your goal is to reach index n - 1.

From any index i, you may perform one of the following operations:

Adjacent Step: Jump to index i + 1 or i - 1, if the index is within bounds.
Prime Teleportation: If nums[i] is a prime number p, you may instantly jump to any index j != i such that nums[j] % p == 0.
Return the minimum number of jumps required to reach index n - 1.

 

Example 1:

Input: nums = [1,2,4,6]

Output: 2

Explanation:

One optimal sequence of jumps is:

Start at index i = 0. Take an adjacent step to index 1.
At index i = 1, nums[1] = 2 is a prime number. Therefore, we teleport to index i = 3 as nums[3] = 6 is divisible by 2.
Thus, the answer is 2.

Example 2:

Input: nums = [2,3,4,7,9]

Output: 2

Explanation:

One optimal sequence of jumps is:

Start at index i = 0. Take an adjacent step to index i = 1.
At index i = 1, nums[1] = 3 is a prime number. Therefore, we teleport to index i = 4 since nums[4] = 9 is divisible by 3.
Thus, the answer is 2.

Example 3:

Input: nums = [4,6,5,8]

Output: 3

Explanation:

Since no teleportation is possible, we move through 0 → 1 → 2 → 3. Thus, the answer is 3.
*/
import java.util.*;
public class Leetcode3629 {
     public int minJumps(int[] nums) {

        int n = nums.length;

        if (n == 1) return 0;

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // SPF sieve
        int[] spf = new int[max + 1];

        for (int i = 2; i <= max; i++) {
            if (spf[i] == 0) {

                spf[i] = i;

                if ((long) i * i <= max) {

                    for (int j = i * i; j <= max; j += i) {
                        if (spf[j] == 0) {
                            spf[j] = i;
                        }
                    }
                }
            }
        }

        // prime -> indices divisible by prime
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int x = nums[i];

            while (x > 1) {

                int p = spf[x];

                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);

                while (x % p == 0) {
                    x /= p;
                }
            }
        }

        boolean[] vis = new boolean[n];

        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.offer(0);
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int i = q.poll();

                if (i == n - 1) {
                    return steps;
                }

                // left
                int left = i - 1;

                if (left >= 0 && !vis[left]) {
                    vis[left] = true;
                    q.offer(left);
                }

                // right
                int right = i + 1;

                if (right < n && !vis[right]) {
                    vis[right] = true;
                    q.offer(right);
                }

                // teleport only if nums[i] itself is prime
                int val = nums[i];

                if (val > 1 && spf[val] == val) {

                    ArrayList<Integer> nexts = map.get(val);

                    if (nexts != null) {

                        for (int idx : nexts) {

                            if (!vis[idx]) {
                                vis[idx] = true;
                                q.offer(idx);
                            }
                        }

                        // critical optimization
                        map.remove(val);
                    }
                }
            }

            steps++;
        }

        return -1;
    }
    public static void main(String[] args) {
        Leetcode3629 solution = new Leetcode3629();
        int[] nums1 = {2, 3, 4, 5, 6};
        System.out.println(solution.minJumps(nums1)); // Output: 2

        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(solution.minJumps(nums2)); // Output: 3
    }
}