/*
2833. Furthest Point From Origin (leetcode daily solve)

You are given a string moves of length n consisting only of characters 'L', 'R', and '_'. The string represents your movement on a number line starting from the origin 0.

In the ith move, you can choose one of the following directions:

move to the left if moves[i] = 'L' or moves[i] = '_'
move to the right if moves[i] = 'R' or moves[i] = '_'
Return the distance from the origin of the furthest point you can get to after n moves.

 

Example 1:

Input: moves = "L_RL__R"
Output: 3
Explanation: The furthest point we can reach from the origin 0 is point -3 through the following sequence of moves "LLRLLLR".
Example 2:

Input: moves = "_R__LL_"
Output: 5
Explanation: The furthest point we can reach from the origin 0 is point -5 through the following sequence of moves "LRLLLLL".
Example 3:

Input: moves = "_______"
Output: 7
Explanation: The furthest point we can reach from the origin 0 is point 7 through the following sequence of moves "RRRRRRR".
*/

public class Leetcode2833 {
     public int furthestDistanceFromOrigin(String moves) 
    {
        int n = moves.length();
        int ans = 0;
        int blank = 0;

        for (int i = 0; i < n; i++)
        {
            if (moves.charAt(i) == 'L')
            {
                ans--;
            }
            else if (moves.charAt(i) == 'R')
            {
                ans++;
            }
            else
            {
                blank++; // count '_'
            }
        } 

        return Math.abs(ans) + blank;
    }
    public static void main(String[] args) {
        Leetcode2833 solution = new Leetcode2833();
        String moves1 = "L_RL__R";
        System.out.println(solution.furthestDistanceFromOrigin(moves1)); // Output: 5

        String moves2 = "RLRRRLLRLL";
        System.out.println(solution.furthestDistanceFromOrigin(moves2)); // Output: 2
    }
}
