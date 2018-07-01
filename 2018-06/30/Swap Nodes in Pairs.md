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
        
        if head == None or head.next == None:
            return head

        prev = None
        p1 = head
        p2 = head.next
        p3 = head.next.next
        head = p2
        while p1 and p1.next:
            p2.next = p1
            p1.next = p3
            if prev:
                prev.next = p2
            prev = p1
            p1 = p3
            if p3:
                p2 = p3.next
            if p2:
                p3 = p2.next

        return head
```
