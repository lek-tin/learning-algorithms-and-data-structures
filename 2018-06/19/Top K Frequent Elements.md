Given a non-empty array of integers, return the `k` most frequent elements.

For example,
Given `[1,1,1,2,2,3]` and `k = 2`, return `[1,2]`.
**Note**: 
You may assume k is always valid, `1 ≤ k ≤ number` of unique elements.
Your algorithm's time complexity **must be better** than `O(n log n)`, where `n` is the array's size.
**Solution:**
```python
class Solution:
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        freqMap = dict()
        for num in nums:
            if freqMap.get(num) == None:
                freqMap[num] = 1
            else:
                freqMap[num] = freqMap.get(num) + 1
        bucket = []
        topKCounts = sorted(list(freqMap.values()), reverse=True)[:k]
            
        for key, value in freqMap.items():
            if value in topKCounts:
                bucket.append(key)
        return bucket
```
