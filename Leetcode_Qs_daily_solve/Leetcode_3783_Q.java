
/*
3783. Mirror Distance of an Integer (solve daily leetcode problem contest)

You are given an integer n.

Define its mirror distance as: abs(n - reverse(n))​​​​​​​ where reverse(n) is the integer formed by reversing the digits of n.

Return an integer denoting the mirror distance of n​​​​​​​.

abs(x) denotes the absolute value of x.

 

Example 1:

Input: n = 25

Output: 27

Explanation:

reverse(25) = 52.
Thus, the answer is abs(25 - 52) = 27.
Example 2:

Input: n = 10

Output: 9

Explanation:

reverse(10) = 01 which is 1.
Thus, the answer is abs(10 - 1) = 9.
*/
public class Leetcode_3783_Q{
    public int mirrorDistance(int n) {
        int dist = Math.abs(n- reverse(n));
        return dist;
        
    }
    public int reverse(int num){
        int reversed =0;
        while(num != 0){
            int digt = num % 10;
            reversed = reversed * 10 + digt;
            num /= 10;
        }
        return reversed;
    }
    public static void main(String[] args) {
        Leetcode_3783_Q obj = new Leetcode_3783_Q();
        int n = 123;
        System.out.println(obj.mirrorDistance(n));
    }
}