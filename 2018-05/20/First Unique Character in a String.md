Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

**Examples:**
```
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
```
**Note:** You may assume the string contain only lowercase letters.

**Solution:**
```python
class Solution(object):
    def firstUniqChar_1(self, s):
        """
        :type s: str
        :rtype: int
        """
        letters='abcdefghijklmnopqrstuvwxyz'
        index=[s.index(l) for l in letters if s.count(l) == 1]
        print(index)
        return min(index) if len(index) > 0 else -1
    def firstUniqChar_2(self, s):
        """
        :type s: str
        :rtype: int
        """
        unique = s
        counter = 0
        while unique:
            if len(s) == 1:
                return 0
            elif unique[0] in unique[1::]:
                unique = unique.replace(unique[0], "")
            else:
                return s.find(unique[0])
        return -1
```
