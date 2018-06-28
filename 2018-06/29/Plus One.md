Given a `non-empty` array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

**Example 1:**
```
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
```
**Example 2:**
```
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
```
**Solution:**
```python
class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        pos = len(digits) - 1
        
        if digits == []:
            return [1]
    
        while pos > -1:
            # iterate backwards
		    # if the current digit is less than 9, plus one then exit
            if digits[pos] != 9:
                digits[pos] += 1
                break    
			# if the current digit is equal to 9, set the value to 0, and continue
            else:
                digits[pos] = 0
            pos -= 1
        # check if the first element in the list is 0, if yes, insert 1 to the beginning of the list.
        if digits[0] == 0:
            digits.insert(0, 1)
            
        return digits
```
