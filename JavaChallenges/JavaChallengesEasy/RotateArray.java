************************* rotate 2d array by 90 degreese********************
class Solution {
    public void rotate(int[][] matrix) {
        
        Map<Integer, List<Integer>> numbers = new HashMap<>();
        
        for(int i = matrix.length-1; i >= 0; i--) {
            
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j < matrix[i].length; j++) {
                l.add(matrix[i][j]);
            }
            numbers.put(i, l);
        }
        
        for(int j = 0; j < matrix.length; j++) {
            for(int i : numbers.keySet()) {
                matrix[j][i] = numbers.get(i).get(j);
            }
        }
        
        int start = 0;
        int end = matrix.length - 1;
        
        for(int i = 0; i < matrix.length; i++) {
            start = 0;
            end = matrix.length - 1;
            while(start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                
                start++;
                end--;
            }
        }
    }
}