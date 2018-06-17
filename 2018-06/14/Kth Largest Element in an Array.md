Find the `kth` largest element in an unsorted array. Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.

**Example 1:**
```
Input: [3,2,1,5,6,4] and k = 2
Output: 5
```
**Example 2:**
```
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
```
**Note:**
You may assume `k` is always valid, `1 ≤ k ≤ array's length`.
**Solution:**
```ptyhon
class Solution:
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        def sort(array):
            less = []
            equal = []
            greater = []

            if len(array) > 1:
                pivot = array[0]
                for x in array:
                    if x < pivot:
                        less.append(x)
                    if x == pivot:
                        equal.append(x)
                    if x > pivot:
                        greater.append(x)
                # + operator joins lists
                return sort(less)+equal+sort(greater)  
            # Note that you want equal ^^^^^ not pivot
            # You need to handle the part at the end of the recursion - when you only have one element in your array, just return the array.    
            else:
                return array
        return sort(nums)[len(nums) - k]
```        
