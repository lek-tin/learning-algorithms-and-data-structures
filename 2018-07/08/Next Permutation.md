Implement **next permutation**, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
`1,2,3` → `1,3,2`
`3,2,1` → `1,2,3`
`1,1,5` → `1,5,1`
**Solution:**
```python
def swap(nums, i, j):
  if nums[i] < nums[j]:
      temp = nums[j]
      nums[j] = nums[i]
      nums[i] = temp

def nextPermutation(nums):
  pos = 0
  while pos < len(nums)-1:
    if nums[pos] > nums[pos-1]:
      swap(nums, pos-1, pos)
      return nums
    pos += 1

  return list(reversed(nums))

print(nextPermutation([10, 9, 7, 8 , 6, 5]))
```
