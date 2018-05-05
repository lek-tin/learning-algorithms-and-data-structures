Given an array of numbers `nums`, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:
Given `nums = [1, 2, 1, 3, 2, 5]`, return `[3, 5]`.
**Note**:

1. The order of the result is not important. So in the above example, `[5, 3]` is also correct.
2. Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

**Credits:**
Special thanks to [@jianchao.li.fighter](https://leetcode.com/discuss/user/jianchao.li.fighter) for adding this problem and creating all test cases.

**solution**
```c++
class Solution {
public:
  vector<int> singleNumber(vector<int>& nums) {
    // Pass 1 : 
    // Get the XOR of the two numbers we need to find
    int twoSinglesXORed = accumulate(nums.begin(), nums.end(), 0, bit_xor<int>());
    // Get its last set bit
    twoSinglesXORed &= ~(twoSinglesXORed-1);

    // Pass 2 :
    vector<int> singles = {0, 0}; // this vector stores the two numbers we will return
    for (int num : nums)
    {
        if ((num & twoSinglesXORed) == 0) // the bit is not set
        {
            singles[0] ^= num;
        }
        else // the bit is set
        {
            singles[1] ^= num;
        }
    }
    return singles;
  }
};
```

**Thought**
How come 
`twoSinglesXORed &= ~(twoSinglesXORed-1);`
equals
`twoSinglesXORed &= -twoSinglesXORed-1`

**Explanation**
1. [https://leetcode.com/problems/single-number-iii/discuss/68901/Sharing-explanation-of-the-solution](https://leetcode.com/problems/single-number-iii/discuss/68901/Sharing-explanation-of-the-solution)
2. [https://leetcode.com/problems/single-number-iii/discuss/68900/Accepted-C++Java-O(n)-time-O(1)-space-Easy-Solution-with-Detail-Explanations]("https://leetcode.com/problems/single-number-iii/discuss/68900/Accepted-C++Java-O(n)-time-O(1)-space-Easy-Solution-with-Detail-Explanations")