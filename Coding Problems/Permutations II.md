Given a collection of numbers that might contain duplicates, return all possible unique permutations.

**Example:**
```
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
```
**Solution:**
```python
class Solution:
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = {}
        def insertOneNum(baseList, single=''):
            if len(baseList) == 0:
                result[single] = True
                return
            
            for i in range(len(baseList)):
                tempBaseList = list(baseList)
                tempBaseList.pop(i)
                if i == len(nums) - 1 or single == '':
                    tempSingle = single + str(baseList[i])
                else: 
                    tempSingle = single + '_' + str(baseList[i])
                insertOneNum(tempBaseList, tempSingle)
            
        insertOneNum(nums)    
        result = [[int(num) for num in key.split('_')] for key in list(result.keys())]
        return result
```
