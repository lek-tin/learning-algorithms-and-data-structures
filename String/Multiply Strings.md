Given two non-negative integers `num1` and `num2` represented as strings, return the product of `num1` and `num2`, also represented as a string.

**Example 1:**
```
Input: num1 = "2", num2 = "3"
Output: "6"
```
**Example 2:**
```
Input: num1 = "123", num2 = "456"
Output: "56088"
```
**Note:**
- The length of both `num1` and `num2` is < 110.
- Both `num1` and `num2` contain only digits 0-9.
- Both `num1` and `num2` do not contain any leading zero, except the number 0 itself.
- You **must not use any built-in BigInteger library** or **convert the inputs to integer** directly.
**Solution:**
#1
```python
class Solution:
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        if not num1 or not num2:
            return "0"
        if num1 == '0' or num2 == '0':
            return "0"
        
        product = 0
        
        num1Len = len(num1)
        num2Len = len(num2)
        print(num1Len, num2Len)
        for i in range(num1Len):
            num_1 = ord(num1[num1Len-1-i]) - ord('0')
            for j in range(num2Len):
                num_2 = ord(num2[num2Len-1-j]) - ord('0')
                product = product + (num_1 * 10**i * num_2 * 10**j)
                
        return str(product)
```
#2: second method
no * operation. Create an array with the correct length and calculate each item, iteratively.
``` 
   👇
[x, x, x, x, x, x]
```
