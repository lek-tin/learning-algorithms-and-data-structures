Say you have an array for which the `ith` element is the price of a given stock on day `i`.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

**Example 1:**
```python
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
```
**Example 2:**
```python
Input: [7,6,4,3,1]
Output: 0
```
**Explanation:** In this case, no transaction is done, i.e. max profit = 0.

**Solution:**
```python
class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        timeRange = len(prices)
        profit = 0
        buyDay, sellDay = 0, 0
        def makeProfit(pirceList, profit):
            for i in range(timeRange):
                for j in range(timeRange):
                    newSellDay = timeRange - j - 1
                    if (newSellDay > i):
                        newProfit = prices[newSellDay] - prices[i]
                        if (newProfit > profit):
                            profit = newProfit
            return profit              
                    
        return makeProfit(prices, profit)
```
