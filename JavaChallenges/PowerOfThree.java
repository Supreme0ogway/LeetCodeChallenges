// Given an integer n, return true if it is a power of three. Otherwise, return false.

// An integer n is a power of three, if there exists an integer x such that n == 3x.

class Solution {
    public boolean isPowerOfThree(double n) {
        if(n <= 0) {
            return false;
        } else if(n == 1) {
            return true;
        }
        
        return check(n);
    }
     
    public boolean check(double n) {
        boolean is = false;
        if(n == 3.0) {
            is = true;
        } else if(n < 1) {
            System.out.println(n);
            return false;
        } else {
            is = isPowerOfThree(n / 3);
        }
        return is;
    }
}