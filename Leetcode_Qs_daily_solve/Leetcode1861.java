
/*
1861. Rotating the Box
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an m x n matrix of characters boxGrid representing a side-view of a box. Each cell of the box is one of the following:

A stone '#'
A stationary obstacle '*'
Empty '.'
The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

It is guaranteed that each stone in boxGrid rests on an obstacle, another stone, or the bottom of the box.

Return an n x m matrix representing the box after the rotation described above.

 

Example 1:



Input: boxGrid = [["#",".","#"]]
Output: [["."],
         ["#"],
         ["#"]]
Example 2:



Input: boxGrid = [["#",".","*","."],
              ["#","#","*","."]]
Output: [["#","."],
         ["#","#"],
         ["*","*"],
         [".","."]]
Example 3:



Input: boxGrid = [["#","#","*",".","*","."],
              ["#","#","#","*",".","."],
              ["#","#","#",".","#","."]]
Output: [[".","#","#"],
         [".","#","#"],
         ["#","#","*"],
         ["#","*","."],
         ["#",".","*"],
         ["#",".","."]]
 
*/
public class Leetcode1861{
     public char[][] rotateTheBox(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Step 1: Gravity
        for (int i = 0; i < m; i++) {
            int empty = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '*') {
                    empty = j - 1;
                } else if (matrix[i][j] == '#') {
                    matrix[i][j] = '.';
                    matrix[i][empty] = '#';
                    empty--;
                }
            }
        }

        // Step 2: Rotation
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = matrix[i][j];
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Leetcode1861 solution = new Leetcode1861();
        char[][] matrix1 = {
            {'#', '.', '#'},
            {'#', '#', '.'},
            {'.', '.', '.'}
        };
        char[][] result1 = solution.rotateTheBox(matrix1);
        // Print result1

        char[][] matrix2 = {
            {'#', '#', '*', '.', '*'},
            {'#', '#', '#', '*', '.'},
            {'#', '#', '#', '.', '.'}
        };
        char[][] result2 = solution.rotateTheBox(matrix2);
        // Print result2
    }
}