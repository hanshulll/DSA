class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        my_map = {}
        for i, num in enumerate(nums):
            a=target-num
            if a in my_map:
                return [i,my_map.get(a)]
            my_map[num]=i
