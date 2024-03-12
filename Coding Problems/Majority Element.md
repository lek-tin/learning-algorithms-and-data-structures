Given an array of size `n`, find the majority element. The majority element is the element that appears **more than** `⌊ n/2 ⌋` times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
```
Input: [3,2,3]
Output: 3
```
Example 2:
```
Input: [2,2,1,1,1,2,2]
Output: 2
```

**Solution**:
```python
class Solution:
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def countNumbers(list, counter, LIST_LENGTH):
            if (len(list) == 0):
                return
            val = list.pop()
            if (counter.get(val) == None):
                counter[val] = 1
            else:
                counter[val] = counter.get(val) +1
            if (counter[val] > (LIST_LENGTH / 2)):
                print(val)
                return val
            else:
                return countNumbers(list, counter, LIST_LENGTH)
        return countNumbers(nums, {}, len(nums))
            
```
