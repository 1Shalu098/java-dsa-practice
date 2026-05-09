
/*
* 1914. Cyclically Rotating a Grid
You are given an m x n integer matrix grid​​​, where m and n are both even integers, and an integer k.

The matrix is composed of several layers, which is shown in the below image, where each color is its own layer:



A cyclic rotation of the matrix is done by cyclically rotating each layer in the matrix. To cyclically rotate a layer once, each element in the layer will take the place of the adjacent element in the counter-clockwise direction. An example rotation is shown below:


Return the matrix after applying k cyclic rotations to it.

 

Example 1:


Input: grid = [[40,10],[30,20]], k = 1
Output: [[10,20],[40,30]]
Explanation: The figures above represent the grid at every state.
Example 2:


Input: grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
Output: [[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
Explanation: The figures above represent the grid at every state.
 
*/
import java.util.ArrayList;
import java.util.List;

public class Leetcode1914 {

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elems = new ArrayList<>();

            // top row
            for (int j = layer; j < n - layer; j++) {
                elems.add(grid[layer][j]);
            }

            // right column
            for (int i = layer + 1; i < m - layer - 1; i++) {
                elems.add(grid[i][n - layer - 1]);
            }

            // bottom row
            for (int j = n - layer - 1; j >= layer; j--) {
                elems.add(grid[m - layer - 1][j]);
            }

            // left column
            for (int i = m - layer - 2; i > layer; i--) {
                elems.add(grid[i][layer]);
            }

            int len = elems.size();
            int shift = k % len;

            List<Integer> rotated = new ArrayList<>();

            // counterclockwise rotation
            for (int i = shift; i < len; i++) {
                rotated.add(elems.get(i));
            }

            for (int i = 0; i < shift; i++) {
                rotated.add(elems.get(i));
            }

            int idx = 0;

            // fill top row
            for (int j = layer; j < n - layer; j++) {
                grid[layer][j] = rotated.get(idx++);
            }

            // fill right column
            for (int i = layer + 1; i < m - layer - 1; i++) {
                grid[i][n - layer - 1] = rotated.get(idx++);
            }

            // fill bottom row
            for (int j = n - layer - 1; j >= layer; j--) {
                grid[m - layer - 1][j] = rotated.get(idx++);
            }

            // fill left column
            for (int i = m - layer - 2; i > layer; i--) {
                grid[i][layer] = rotated.get(idx++);
            }
        }

        return grid;
    }
    public static void main(String[] args) {
        Leetcode1914 solution = new Leetcode1914();
        int[][] grid1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k1 = 1;
        int[][] result1 = solution.rotateGrid(grid1, k1);
        printGrid(result1); // Output: [[4, 1, 2], [7, 5, 3], [8, 9, 6]]

        int[][] grid2 = {{40, 10}, {30, 20}};
        int k2 = 2;
        int[][] result2 = solution.rotateGrid(grid2, k2);
        printGrid(result2); // Output: [[30, 40], [20, 10]]
    }
}
