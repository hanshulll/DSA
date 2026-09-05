class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        num_set = set()
        for item in nums:
            if item in num_set:
                return True
            num_set.add(item)
        return False