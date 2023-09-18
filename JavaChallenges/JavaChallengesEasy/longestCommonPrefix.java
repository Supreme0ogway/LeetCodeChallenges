********** find longest common prefix in array of strings******************

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];//choose first
        
        //search
        for (int i = 0; i < strs.length; i++) {
            String thisString = strs[i];//gets the string
            while (thisString.indexOf(prefix) != 0) {//makes sure its at the start and shrinks the strings
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        
        return prefix;//returns whats left
    
    }
}