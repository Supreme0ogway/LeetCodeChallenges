************ increment list number by 1 ********************************
-my way

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        combinedNumberStr = "".join(str(num) for num in digits)
        combinedNumberInt = int(combinedNumberStr) + 1
        listNewNum = [int(d) for d in str(combinedNumberInt)]
        return listNewNum

-found way

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        for i in range(len(digits)-1, -1, -1):
            if digits[i] < 9:
                digits[i] += 1
                return digits
            else:
                digits[i] = 0
        return [1] + digits