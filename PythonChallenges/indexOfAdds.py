find index of 2 numbers in the array that add up to be target
**************************************************************************
-slow (brute force)

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        total = 0
        for i in range(len(nums)):
            for j in range(len(nums)-1,0,-1):
                total = nums[i] + nums[j]
                if(total == target and i != j):
                    sL = sorted((i,j))
                    return sL

-fast (hash map)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        memo = {}

        for i in range(0, len(nums)):
            x = target - nums[i]
            if nums[i] in memo:
                return [memo[nums[i]], i]
            memo[x] = i