You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.
// Example 2:

// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achive this answer too.
class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int maxCount = 0; // to keep track of the maximum repeating character count
        int maxLength = 0; // to keep track of the maximum substring length

        int[] charCount = new int[26]; // Count of each uppercase English character

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            charCount[currentChar - 'A']++; // Increment the count of the current character
            maxCount = Math.max(maxCount, charCount[currentChar - 'A']); // Update maxCount

            // If the number of characters to change (k) is less than the current window size, shrink the window
            if (end - start + 1 - maxCount > k) {
                char startChar = s.charAt(start);
                charCount[startChar - 'A']--; // Decrement the count of the character at the start of the window
                start++; // Move the start pointer to the right
            }

            // Update the maxLength
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
