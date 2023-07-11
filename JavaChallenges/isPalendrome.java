*********************** is palendrom with all alph characters *****************

class Solution {
    public boolean isPalindrome(String s) {
         
        String r = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        int start = 0;
        int end = r.length()-1;
        
        while(start < end) {
            if(r.charAt(start) != r.charAt(end)) {
                return false;
            }
            
            start ++;
            end --;
        }
        return true;
    }
}