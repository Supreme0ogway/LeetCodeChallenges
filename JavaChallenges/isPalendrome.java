//*********************** is palendrom with all alph characters *****************

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

//another way
class Solution {
    public boolean isPalindrome(String s) {
        String fs = s.replaceAll("[^a-zA-Z0-9]", "");
        
        int mid;
        String firstHalf;
        String secondHalf;
        if(fs.length() % 2 == 0) {
            mid = fs.length()/2;
            firstHalf = fs.substring(0, mid);
            secondHalf = fs.substring(mid);
        } else {
            mid = fs.length()/2;
            firstHalf = fs.substring(0, mid);
            secondHalf = fs.substring(mid+1);
        }
        
        StringBuilder sb = new StringBuilder(secondHalf);
        sb.reverse();
        String reversedSecondHalf = sb.toString();
        firstHalf = firstHalf.toUpperCase();
        reversedSecondHalf = reversedSecondHalf.toUpperCase();
        
        if(firstHalf.equals(reversedSecondHalf)) {
            return true;
        } else {
            return false;
        }
    }
}