// You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0s.

// Increment the large integer by one and return the resulting array of digits.
// Example 1:

// Input: digits = [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Incrementing by one gives 123 + 1 = 124.
// Thus, the result should be [1,2,4].
// Example 2:

// Input: digits = [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.
// Incrementing by one gives 4321 + 1 = 4322.
// Thus, the result should be [4,3,2,2].
// Example 3:

// Input: digits = [9]
// Output: [1,0]
// Explanation: The array represents the integer 9.
// Incrementing by one gives 9 + 1 = 10.
// Thus, the result should be [1,0].


class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1; // Start with a carry of 1 since we want to add 1 to the number

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10; // Update the current digit
            carry = sum / 10; // Calculate the carry for the next iteration
        }

        // If there is still a carry left after the loop, it means we need to add an additional digit
        if (carry > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = carry; // Set the first digit to the carry
            // Copy the original digits to the result array starting from index 1
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }

        return digits;
    }
}