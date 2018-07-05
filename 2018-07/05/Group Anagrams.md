Given an array of strings, group anagrams together.

**Example:**
```
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```
**Note:**
- All inputs will be in lowercase.
- The order of your output does not matter.
**Solution:**
```python
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        primeNums = {
          "a": 2,
          "b": 3,
          "c": 5,
          "d": 7,
          "e": 11,
          "f": 13,
          "g": 17,
          "h": 19,
          "i": 23,
          "j": 29,
          "k": 31,
          "m": 37,
          "l": 41,
          "n": 43,
          "o": 47,
          "p": 53,
          "q": 59,
          "r": 61,
          "s": 67,
          "t": 71,
          "u": 73,
          "v": 79,
          "w": 83,
          "x": 89,
          "y": 97,
          "z": 101
        }
        
        def encode(string):
            res = 1
            for s in list(string):
                res *= primeNums[s]
            return res
        
        anagrams = {}
        
        for string in strs:
            code = encode(string)
            if anagrams.get(code, None) is None:
                anagrams[code] = [string]
            else:
                anagrams.get(code).append(string)
        
        return list(anagrams.values())
```
