class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        my_map={}
        for i in strs:
            a="".join(sorted(i))
            if a in my_map:
                my_map.get(a).append(i)
            else:
                my_map[a]=[i]
        ans=[]
        for i in my_map:
            ans.append(my_map.get(i))
        return ans