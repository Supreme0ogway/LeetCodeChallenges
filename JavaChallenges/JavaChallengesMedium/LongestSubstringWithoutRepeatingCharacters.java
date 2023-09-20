// Given a string s, find the length of the longest 
// substring
//  without repeating characters.
// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            
            if (charIndexMap.containsKey(currentChar)) {
                start = Math.max(start, charIndexMap.get(currentChar) + 1);
            }
            
            charIndexMap.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}