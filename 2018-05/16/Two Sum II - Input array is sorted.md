Given an array of integers that is already ***sorted in ascending order***, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

**Note:**

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
**Example:**
```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
```
**Solution:**
```python
class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        def iterate(index_1 = None, index_2 = None):
            if (index_1 == None and index_2 == None):
                return iterate(0, 1)
            else:
                print(numbers[index_1], numbers[index_2])
                if ((numbers[index_1] + numbers[index_2]) == target):
                    """Indices are not zero-based"""
                    return [index_1 + 1, index_2 + 1]
                elif (index_2 != (len(numbers) -1)):
                    return iterate(index_1, index_2 + 1)
                else:
                    return iterate(index_1 + 1, index_1 + 2)
        return iterate()
```
