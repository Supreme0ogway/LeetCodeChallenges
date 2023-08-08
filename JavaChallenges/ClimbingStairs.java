// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//n = 1 2 3 .... if <= 2 return
//otherwise
// use the for loop as a calculation

class Solution {
    public int climbStairs(int n) {
        if(n <=2) {//same pattern to 3
            return n;
        }
        
        //first 2 but no need for index 0
        int[] s = new int[n + 1];
        s[1] = 1;
        s[2] = 2;
        
        //f(x) = i-1 + i-2
        for(int i = 3; i <= n; i++) {
            s[i] = s[i-1] + s[i-2];
        }
        
        //returning the last one (n+1 is size for overflow starting at 1)
        return s[n];
    }
}