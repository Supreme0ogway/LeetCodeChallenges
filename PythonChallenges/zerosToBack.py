put all zeros in the array to the back keeping the order of the numbers
***************************************************************************

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        temp = 0
        posOfNoInt = 0
        for i in range(len(nums)):
            if(nums[i] != 0):
                temp = nums[posOfNoInt]
                nums[posOfNoInt] = nums[i]
                nums[i] = temp
                posOfNoInt += 1