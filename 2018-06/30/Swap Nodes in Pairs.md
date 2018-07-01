Given a linked list, swap every two adjacent nodes and return its head.

**Example:**
```
Given 1->2->3->4, you should return the list as 2->1->4->3.
```
**Note:**
- Your algorithm should use only constant extra space.
- You may not modify the values in the list's nodes, only nodes itself may be changed.
**Solution:**
```python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        
        root = ListNode(0)
        root.next = head
        nextNode = root
        # while new start is not None
        while nextNode.next:
            print(nextNode.next.val)
            # the new latter element being swapped
            if nextNode.next.next:
                # reference: when nextNode changes, temp changes TOO
                temp = nextNode.next
                # exchange 3 node
                nextNode.next = nextNode.next.next
                temp.next = temp.next.next
                nextNode.next.next = temp
                nextNode = temp
            else:
                break
        return root.next
```
