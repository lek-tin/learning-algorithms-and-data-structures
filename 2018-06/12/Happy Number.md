Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

**Example:**
```
Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
```
**Solution:**
```python
class Solution:
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        triedNums = []
        currentNum = n
        while(currentNum not in triedNums):
            triedNums.append(currentNum)
            sum = 0
            sumOfDigits = 0
            for num in [int(d) for d in str(currentNum)]:
                sum += num**2
            for digit in [int(i) for i in str(sum)]:
                sumOfDigits += digit
            if (sumOfDigits == 1):
                return True
            else:
                currentNum = sum
            print(sum)
        return False
```
