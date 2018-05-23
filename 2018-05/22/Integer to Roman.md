Roman numerals are represented by seven different symbols: `I`, `V`, `X`, `L`, `C`, `D` and `M`.
```
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```
For example, two is written as `II` in Roman numeral, just two one's added together. Twelve is written as, `XII`, which is simply `X + II`. The number twenty seven is written as XXVII, which is `XX + V + II`.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not `IIII`. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

`I` can be placed before `V (5)` and `X (10)` to make `4 and 9`. 
`X` can be placed before `L (50)` and `C (100)` to make `40 and 90`. 
`C` can be placed before `D (500)` and `M (1000)` to make `400 and 900`.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from `1` to `3999`.

Example 1:
```
Input: 3
Output: "III"
```
Example 2:
```
Input: 4
Output: "IV"
```
Example 3:
```
Input: 9
Output: "IX"
```
Example 4:
```
Input: 58
Output: "LVIII"
Explanation: C = 100, L = 50, XXX = 30 and III = 3.
```
Example 5:
```
Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```
**Solution:**
```python
class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        # s = ""
        # while (num > 10):
        #     if (num > 1000):
        #         num = 1000
        #         s = "M" * 
        s = "M" * (num // 1000)
        print(s)
        s += "CM" if num % 1000 >= 900 else "D" *((num % 1000) // 500)
        print(s)
        s += "CD" if num % 500 >= 400 and s[-2:] != "CM" else "C" * ((num % 500) // 100)  if num % 500 < 400 else ""
        print(s)
        s += "XC" if num % 100 >= 90 else "L" * ((num % 100) // 50)
        print(s)
        s += "XL" if num % 50 >= 40 and s[-2:] != "XC" else "X" * ((num % 50) // 10)  if num % 50 < 40 else ""
        print(s)
        s += "IX" if num % 10 >= 9 else "V" * ((num % 10) // 5)
        print(s)
        s += "IV" if num % 5 >= 4 and s[-2:] != "IX" else "I" * ((num % 5) // 1) if num % 5 < 4 else ""
        print(s)
        return s
```
