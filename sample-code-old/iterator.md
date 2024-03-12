# Iterator

## Flatten Nested List Iterator
```java
// Leetcode: https://leetcode.com/problems/flatten-nested-list-iterator/
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 *
 * Solution: recursion, stack
 * Time: O(n + L) for the constructor, and O(L/N) for makeStackTopAnInteger
 * Space: O(n + L);
 * L be the total number of lists within the nested list
 */
import java.util.NoSuchElementException;

public class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque(nestedList);
    }

    @Override
    public Integer next() {
        // As per java specs, throw an exception if there's no elements left.
        if (!hasNext()) throw new NoSuchElementException();
        
        // hasNext ensures the stack top is now an integer. Pop and return
        // this integer.
        return stack.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        // Check if there are integers left by getting one onto the top of stack.
        makeStackTopAnInteger();
        // If there are any integers remaining, one will be on the top of the stack,
        // and therefore the stack can't possibly be empty.
        return !stack.isEmpty();
    }
    
    private void makeStackTopAnInteger() {
        // While there are items remaining on the stack and the front of 
        // stack is a list (i.e. not integer), keep unpacking.
        while (!stack.isEmpty() && !stack.peekFirst().isInteger()) {
            List<NestedInteger> nestedList = stack.pollFirst().getList();
            // Reverse order, very important!
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.addFirst(nestedList.get(i));
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
```

## Nested list -> round robin iterator

```java
// Interator
// --> List<List<String>>

// next: String
// hasNext: boolean
// inner lists elements in round robin fashion
// Input: [[a,b,c][d,e,f][g,h,i]]
// Output: a,d,g,b,e,h,c,f,i
// ---------------------------------
// Input: [[a,b,c][d,e][g,h,i]]
// Output: a,d,g,b,e,h,c,i
// ---------------------------------
// Input: [[], [abc, asda, biwe], [asdf],[]]
// Output: abc, asdf, asda, biwe
```

1. Flatten list: too costly and it doesn't work for infinite size input
2. Two pointers: outter_ptr, inner_ptr, cache outter_ptr in while loop
```java
// Not complete, this solution is tricky in terms of moving the two pointers.
class RoundRobinNestedIterator {
  
  private List<List<String>> input;
  private int outter_ptr = 0, inner_ptr = 0;
  
  public Iterator(List<List<String>> input) {
    this.input = input;
  }
  
  public String next() {
    if (!hasNext()) return null;
    
    return input.get(outter_ptr).get(inner_ptr);
  }
  
  public boolean hasNext() {
    if (outter_ptr >= input.size()) return false;
    
    //                 3
    int outter_start = outter_ptr;
    int inner_start = inner_ptr
    
    int outterLoopsSoFar = 0;
    while (outter_ptr < input.size()) {
      if (inner_ptr < input.get(outter_ptr).size()) {
        curr_outter = outter_ptr;
        curr_inner = inner_ptr;
        outter_ptr = ++outter_ptr % input.size();
        return true;
      } else {
        if (outter_ptr == input.size() - 1)
      }

      if (outter_ptr == starting) break;
    }
    
    return false;
  }
  
}
```

4. multi iterator: List<List<String>> -> List<Iterator> iterator

Reference:
  - [filosganga/RoundRobinIterable.java](https://gist.github.com/filosganga/7134943)
  - [Implementing a MultiIterator in Java](https://dzone.com/articles/implementing-a-multiiterator-in-java)

## Aggregating Iterator

```java
// Input: a, a, a, b, b, c, c, a
// Output: a, 3), (b, 2), c, 2), (a, 1)
```
