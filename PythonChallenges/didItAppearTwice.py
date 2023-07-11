************ return true if any element appears twice *******************
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        
        tempSet = len(set(nums))
        if(tempSet == len(nums)):
            return False
        else:
            return True