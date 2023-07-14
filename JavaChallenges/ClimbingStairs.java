// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

class Solution {
    public int climbStairs(int n) {
        if(n <=2) {
            return n;
        }
        
        int[] s = new int[n + 1];
        s[1] = 1;
        s[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            s[i] = s[i-1] + s[i-2];
        }
        
        return s[n];
    }
}