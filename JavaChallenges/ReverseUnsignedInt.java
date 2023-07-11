********************* reverse unsigned int ******************************
class Solution {
    public int reverse(int x) {
        List<Character> l = new ArrayList<>();
        
        String num = String.valueOf(x);
        char[] charArray = num.toCharArray();
        int len = charArray.length;
        
        boolean isNeg = false;
        for(int i = len - 1; i >= 0; i--) {
            if(charArray[i] == '-') {
                isNeg = true;
            } else {
                l.add(charArray[i]);
            }
        }
        
        if(isNeg) {
            //l.remove(l.size() - 1);
            l.add(0, '-');
        }
        
        StringBuilder str = new StringBuilder();
        for(char c : l) {
            str.append(c);
        }
        
        try {
            int reversed = Integer.parseInt(str.toString());
            return reversed;
        } catch (NumberFormatException e) {
            // Handle integer overflow
            return 0;
        }
    }
}