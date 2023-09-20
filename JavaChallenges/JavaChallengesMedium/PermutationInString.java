// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

// In other words, return true if one of s1's permutations is the substring of s2.

 

// Example 1:

// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").
// Example 2:

// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false
 

// Constraints:

// 1 <= s1.length, s2.length <= 104
// s1 and s2 consist of lowercase English letters.
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // Create a frequency map for characters in s1
        Map<Character, Integer> s1FreqMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1FreqMap.put(c, s1FreqMap.getOrDefault(c, 0) + 1);
        }

        // Initialize left and right pointers for the sliding window
        int left = 0;
        int right = 0;

        // Create a frequency map for the current window in s2
        Map<Character, Integer> windowFreqMap = new HashMap<>();

        while (right < s2.length()) {
            char currentChar = s2.charAt(right);
            
            // Expand the window by adding the right character
            windowFreqMap.put(currentChar, windowFreqMap.getOrDefault(currentChar, 0) + 1);
            right++;

            // If the window size is equal to s1's length, check for permutation
            if (right - left == s1.length()) {
                // Compare the frequency maps of s1 and the current window
                if (windowFreqMap.equals(s1FreqMap)) {
                    return true;
                }
                
                // Move the left pointer to shrink the window
                char leftChar = s2.charAt(left);
                windowFreqMap.put(leftChar, windowFreqMap.get(leftChar) - 1);
                if (windowFreqMap.get(leftChar) == 0) {
                    windowFreqMap.remove(leftChar);
                }
                left++;
            }
        }

        return false;
    }
}
