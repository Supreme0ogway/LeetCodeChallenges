********** find unique letter otherwise return -1 *****************************
class Solution {
    public int firstUniqChar(String s) {
        int count;
        int uniqueIndex = -1;
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                uniqueIndex = i;
                break;
            }
        }
        return uniqueIndex;
    }
}