********** intersection of two arrays with duplicates *****************
-counter is a hash map where lets just say in “hello” h:1, e:1, l:2, …
-where it you ask count = counter[l] and it returns 2


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        count1 = Counter(nums1)
        count2 = Counter(nums2)
        newList = list((count1 & count2).elements())
        return newList