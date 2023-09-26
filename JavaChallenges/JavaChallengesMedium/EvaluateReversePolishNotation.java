// You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

// Evaluate the expression. Return an integer that represents the value of the expression.

// Note that:

// The valid operators are '+', '-', '*', and '/'.
// Each operand may be an integer or another expression.
// The division between two integers always truncates toward zero.
// There will not be any division by zero.
// The input represents a valid arithmetic expression in a reverse polish notation.
// The answer and all the intermediate calculations can be represented in a 32-bit integer.
 

// Example 1:

// Input: tokens = ["2","1","+","3","*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9
// Example 2:

// Input: tokens = ["4","13","5","/","+"]
// Output: 6
// Explanation: (4 + (13 / 5)) = 6
// Example 3:

// Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
// Output: 22
// Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
// = ((10 * (6 / (12 * -11))) + 17) + 5
// = ((10 * (6 / -132)) + 17) + 5
// = ((10 * 0) + 17) + 5
// = (0 + 17) + 5
// = 17 + 5
// = 22
//my solution
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> ogStack = new Stack<>();
        Stack<String> storeStack = new Stack<>();

        //fill
        for(int i = tokens.length-1; i >= 0; i--) {
            ogStack.push(tokens[i]);
        }

        //pop until find op
        //take the first two in new stack and perform the operator last op first
        while(!ogStack.isEmpty()) {
            //if num then add else(catch) and go back 2 performa op
            try {
                int num = Integer.parseInt(ogStack.peek());
                storeStack.push(ogStack.pop());
            } catch (Exception e) {
                String c = ogStack.pop();
                int st = Integer.parseInt(storeStack.pop());
                int ft = Integer.parseInt(storeStack.pop());
                if(c.equals("+")) {
                    int total = ft + st;
                    String stotal = String.valueOf(total);
                    storeStack.push(stotal);
                } else if(c.equals("-")) {
                    int total = ft - st;
                    String stotal = String.valueOf(total);
                    storeStack.push(stotal);
                } else if(c.equals("*")) {
                    int total = ft * st;
                    String stotal = String.valueOf(total);
                    storeStack.push(stotal);
                } else if(c.equals("/")) {
                    int total = ft / st;
                    String stotal = String.valueOf(total);
                    storeStack.push(stotal);
                }
            }
        }
        String finals = storeStack.pop();
        int ans = Integer.parseInt(finals);
        return ans;
    }
}



//also possable this way
 public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = evaluate(operand1, operand2, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    
    private int evaluate(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                return 0;
        }
    }
}