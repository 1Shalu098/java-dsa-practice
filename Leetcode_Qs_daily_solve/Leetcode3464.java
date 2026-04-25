/*
3464. Maximize the Distance Between Points on a Square (hard question on leetcode)

You are given an integer side, representing the edge length of a square with corners at (0, 0), (0, side), (side, 0), and (side, side) on a Cartesian plane.

You are also given a positive integer k and a 2D integer array points, where points[i] = [xi, yi] represents the coordinate of a point lying on the boundary of the square.

You need to select k elements among points such that the minimum Manhattan distance between any two points is maximized.

Return the maximum possible minimum Manhattan distance between the selected k points.

The Manhattan Distance between two cells (xi, yi) and (xj, yj) is |xi - xj| + |yi - yj|.

 

Example 1:

Input: side = 2, points = [[0,2],[2,0],[2,2],[0,0]], k = 4

Output: 2

Explanation:



Select all four points.

Example 2:

Input: side = 2, points = [[0,0],[1,2],[2,0],[2,2],[2,1]], k = 4

Output: 1

Explanation:



Select the points (0, 0), (2, 0), (2, 2), and (2, 1).
*/

import java.util.*;
public class Leetcode3464{
  public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] pos = new long[n];

        for (int i = 0; i < n; i++) {
            pos[i] = toPerimeter(points[i][0], points[i][1], side);
        }
        Arrays.sort(pos);

        long perimeter = 4L * side;

       
        long[] ext = new long[2 * n];
        for (int i = 0; i < n; i++) {
            ext[i]     = pos[i];
            ext[i + n] = pos[i] + perimeter;
        }

        long lo = 1, hi = 2L * side;
        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;
            if (canPlace(ext, n, k, mid, perimeter)) lo = mid;
            else hi = mid - 1;
        }
        return (int) lo;
    }

    private boolean canPlace(long[] ext, int n, int k, long minDist, long perimeter) {
        for (int start = 0; start < n; start++) {
            long first = ext[start];
            
            long ceiling = first + perimeter - minDist;

            long cur = first;
            int count = 1;
            int searchLo = start + 1;

            boolean valid = true;
            while (count < k) {
                long target = cur + minDist;
                // Binary search in ext[searchLo .. start + n - 1]
                int lo = searchLo, hi = start + n - 1, found = -1;
                while (lo <= hi) {
                    int mid = (lo + hi) >>> 1;
                    if (ext[mid] >= target) { found = mid; hi = mid - 1; }
                    else lo = mid + 1;
                }
                if (found == -1 || ext[found] > ceiling) { valid = false; break; }
                cur = ext[found];
                searchLo = found + 1; // next search starts after current pick
                count++;
            }

            if (valid) return true;
        }
        return false;
    }

    private long toPerimeter(int x, int y, int side) {
        if (y == 0)    return x;
        if (x == side) return (long) side + y;
        if (y == side) return 2L * side + (side - x);
        return 3L * side + (side - y);
    }
    public static void main(String[] args) {
        Leetcode3464 solution = new Leetcode3464();
        int side1 = 5;
        int[][] points1 = {{0, 0}, {5, 0}, {5, 5}, {0, 5}};
        int k1 = 3;
        System.out.println(solution.maxDistance(side1, points1, k1)); // Output: 10

        int side2 = 4;
        int[][] points2 = {{0, 0}, {4, 0}, {4, 4}, {0, 4}};
        int k2 = 2;
        System.out.println(solution.maxDistance(side2, points2, k2)); // Output: 8
    }
}