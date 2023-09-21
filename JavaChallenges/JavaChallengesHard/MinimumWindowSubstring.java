// Given two strings s and t of lengths m and n respectively, return the minimum window 
// substring
//  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

 

// Example 1:

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
// Example 2:

// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.
// Example 3:

// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.

class Solution {
    public String minWindow(String s, String t) {
        //define it 128 ascii characters
        int[] arr = new int[128];

        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        //increment by 1 in t
        for(char c : t_arr) {
            arr[c]++;
        }
        //pointers
        int L = 0, R = 0;
        //minLen
        int minLen = Integer.MAX_VALUE;
        //ans
        String ans = "";
        int counter = 0;
        //min win
        while(R < s_arr.length) {
            //expand window
            char curChar = s_arr[R];
            if(--arr[curChar] >= 0) {
                counter++;
            }
            //shrink window
            while(counter == t_arr.length) {
                int curWindow = R - L + 1;
                if(curWindow < minLen) {
                    minLen = curWindow;
                    ans = s.substring(L, R + 1);
                }
                char leftChar = s_arr[L];
                if(++arr[leftChar] > 0) {
                    counter--;
                }
                L++;
            }
            R++;
        }
        return ans;
    }
}