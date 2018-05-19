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
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        unique = s
        while unique:
            if unique[0] in unique[1::]:
                unique = unique.replace(unique[0], "")
            else:
                return s.find(unique[0])
        return -1
```
