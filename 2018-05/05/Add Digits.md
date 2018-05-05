Given a non-negative integer `num`, repeatedly add all its digits until the result has only one digit.

For example:

Given `num = 38`, the process is like: `3 + 8 = 11`, `1 + 1 = 2`. Since `2` has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in `O(1)` runtime?

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.



**Explanation**
| Number| Result |
| ------------- |:-------------:|
| 0  | 0 |
| 1, 10, 19, 28 ...  | 1 |
| 2, 11, 20, 29 ...  | 2 |
| 3, 12, 21, 30 ...  | 3 |
| 4, 13, 22, 31 ...  | 4 |
| 5, 14, 23, 32 ...  | 5 |
| 6, 15, 24, 33 ...  | 6 |
| 7, 16, 25, 34 ...  | 7 |
| 8, 17, 26, 35 ...  | 8 |
| 9, 18, 27, 36 ...  | 9 |

**Solution**
```c++
class Solution {
public:
    int addDigits(int num) {
        return num == 0 ? 0 : (num % 9 == 0 ? 9 : num % 9);
    }
};
```