Given a collection of **distinct** integers, return all possible permutations.

**Example**:
```
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```
**Solution:**
```python
class Solution:
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        def insertOneNum(baseList, single=[]):
            if len(baseList) == 0:
                result.append(single)
                return
            
            for i in range(len(baseList)):
                tempBaseList = list(baseList)
                tempBaseList.pop(i)
                tempSingle = list(single)
                tempSingle.append(baseList[i])
                insertOneNum(tempBaseList, tempSingle)
            
        insertOneNum(nums)    
        
        return result
```

