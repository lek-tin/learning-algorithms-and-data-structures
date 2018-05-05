## Representation of negative number
+5 = 0000000000000101  
        V  
        V flip  
        V  
-5 = 1111111111111011  

A two's complement is a very efficient way of storing negatives, as it follows all the rules that a negative of a number should have:

1. Taking negative of a number twice gives the original, similarly, if you take 2's complement twice, you get the original number.
2. A number added to its negative gives zero. The same is true for two's complement
3. +0 and -0 are equal.

## Get rightmost set bit
say the kth bit from right side is the first set bit in number 'x'. (x-1) will toggle every bit upto kth bit from right side. ~(x-1) will toggle every bit in (x-1).
eventually every bit right of the k will become 0 and every bit left of k will become different which is in x and the number remained would be a power of 2 which will have only one set bit.

for example :
`x = 12 (1100)`
`(x-1) = 11 (1011)`     [It will toggle every bit upto kth bit. here k = 3 (from right.)]
`~ (x-1) = 4 (0100)`    [every bit right of the k is 0. So &ing it with x will set every bit to it's right to 0, Also every bit to it's left is either 0 or 1, but different from x, so &ing this will make them as 0]

eventually x & ~(x-1) = 4. (power of 2, only 1 set bit.)   
--> quicker way: x &= -x
