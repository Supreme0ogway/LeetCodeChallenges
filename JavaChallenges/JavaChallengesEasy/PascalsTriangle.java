// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
// Example 1:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> map = new ArrayList<>();
        
        for(int i = 0; i < numRows; i++) {
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    l.add(1);//add 1 if j is the edge
                } else {
                    //2 nums above
                    int v = map.get(i-1).get(j-1) + map.get(i-1).get(j);
                    l.add(v);
                }
            }
            map.add(l);
        }
        
        return map;
    }
}