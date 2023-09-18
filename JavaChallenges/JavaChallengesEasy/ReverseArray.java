******************** reverse array **************************************
class Solution {
    public void reverseString(char[] s) {
        List<Character> l = new ArrayList<>();
        
        for(int i = s.length-1; i >= 0; i--) {
            l.add(s[i]);
        }
        
        for(int i = 0; i < s.length; i++) {
            s[i] = l.get(i);
        }
    }
}