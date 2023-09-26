// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]

//idea -> recursive... base: if the length has been reached
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisRecursive(result, "", 0, 0, n);
        return result;
    }

    private void generateParenthesisRecursive(List<String> result, String current, int openCount, int closeCount, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (openCount < n) {
            generateParenthesisRecursive(result, current + "(", openCount + 1, closeCount, n);
        }
        if (closeCount < openCount) {
            generateParenthesisRecursive(result, current + ")", openCount, closeCount + 1, n);
        }
    }
}