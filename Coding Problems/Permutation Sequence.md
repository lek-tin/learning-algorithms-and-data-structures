The set `[1,2,3,...,n]` contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

1. `"123"`
2. `"132"`
3. `"213"`
4. `"231"`
5. `"312"`
6. `"321"`
Given n and k, return the kth permutation sequence.

**Note:**
- Given n will be between 1 and 9 inclusive.
- Given k will be between 1 and n! inclusive.   
**Example 1:**
```
Input: n = 3, k = 3
Output: "213"
```
**Example 2:**
```
Input: n = 4, k = 9
Output: "2314"
```
**Solution:**
```python
class Solution:
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        # Time: O(n)
        # Space: O(n)
        
        # create an inclusive list of strings ['1', '2', '3', ... , 'n']
        ls = list(str(num) for num in range(1, n+1))
        
        # Create a list of factorial values
        # E.g., if n = 5, fact = [1, 1, 2, 6, 24]
        #                index -> 0, 1, 2, 3, 4
        # index 0 -> 1 
        fact = [1]
        for i in range(1, n):
            fact.append(i * fact[i-1])
        print(fact)
        
        # Because the list begins with 1, so we need to offset it by 1
        k = k - 1
        
        # initiate the result
        result = ''
        
        # n = 4, k = 17
        # i = 4, index = 17 // 6 = 2, k = 17 % 6 = 5
        # i = 3, index = 5 // 2 = 2, k = 5 % 2 = 1
        # i = 2, index = 1 // 1 = 1, k = 1 % 1 = 0
        j = n
        while j > 0:
            index = k // fact[j-1]
            k = k % fact[j-1]
            result += ls[index]
            ls.pop(index)
            j -= 1
        
        return result
```
