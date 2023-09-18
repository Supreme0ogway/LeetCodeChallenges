// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

// Example 1:

// Input: x = 123
// Output: 321
// Example 2:

// Input: x = -123
// Output: -321
// Example 3:

// Input: x = 120
// Output: 21

class Solution {
    public int reverse(int x) {
        char[] b = Integer.toString(x).toCharArray();
        char[] c;
        boolean isNeg = false;
        if(b[0] == '-') {
            c = new char[b.length-1];
            for(int i = 1; i < b.length; i++) {
                c[i-1] = b[i];
            }
            isNeg = true;
        } else {
            c = Integer.toString(x).toCharArray();
        }
        
        char temp;
        int start = 0;
        int end = c.length-1;
        
        while(start < end) {
            temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < c.length; i++) {
            sb.append(c[i]);
        }
        
        if(isNeg) {
            sb.insert(0, '-');
        }
        
        try {
            int fullInt = Integer.parseInt(sb.toString());
            return fullInt;
        } catch(Exception e) {
            return 0;
        }
    }
}