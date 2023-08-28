




//first attempt answer not sorted but correct (wont say correct) 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                for(int k = 0; k < nums.length; k++) {
                    if(nums[i] != nums[j] && nums[i] != nums[k] && nums[k] != nums[j]) {
                        if(Math.abs(nums[i]) == Math.abs(nums[k] + nums[j])) {
                            if(i != j && i != k && j != k) {
                                List<Integer> nl = new ArrayList<>();
                                nl.add(nums[i]);
                                nl.add(nums[j]);
                                nl.add(nums[k]);
                                Collections.sort(nl);
                                if(!l.contains(nl)) {
                                    l.add(nl);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return l;
    }
}