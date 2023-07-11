********** find longest common prefix in array of strings******************

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; ++i) {
            String thisString = strs[i];
            while (thisString.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        
        return prefix;
    
    }
}