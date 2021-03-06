You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
```
Input: [2,2,1]
Output: 1
Example 2:
```
```
Input: [4,1,2,1,2]
Output: 4
```
Solution:
```java
// Java
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
```
