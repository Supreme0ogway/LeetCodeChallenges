// Given an integer n, return a string array answer (1-indexed) where:

// answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
// answer[i] == "Fizz" if i is divisible by 3.
// answer[i] == "Buzz" if i is divisible by 5.
// answer[i] == i (as a string) if none of the above conditions are true.

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> s = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {//1 indexed
            if(i % 3 == 0 && i % 5 == 0) {
                s.add("FizzBuzz");
            } else if(i % 3 == 0) {
                s.add("Fizz");
            } else if(i % 5 == 0) {
                s.add("Buzz");
            } else {
                s.add(String.valueOf(i));
            }
        }
        return s;
    }
}