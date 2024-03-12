Given an array of n integers where `n > 1`, `nums`, return an array output such that `output[i]` is equal to the product of all the elements of nums except `nums[i]`.

Solve it without division and in `O(n)`.

For example, given `[1,2,3,4]`, return `[24,12,8,6]`.

**Follow up**:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

**Solution**
```c++
class Solution {
public:
  vector<int> productExceptSelf(vector<int>& nums) {
    int vectSize = nums.size();
    vector<int> result(vectSize, 1);
    for (int i = 1; i < vectSize; ++i) {
      result[i] = result[i - 1] * nums[i - 1];
    };
    for (int i = vectSize - 1, right=1; i>=0; --i) { // to exclude the last element in the vector
      result[i] *= right; 
      right *= nums[i]; 
    };
    return result;
  }
};
```