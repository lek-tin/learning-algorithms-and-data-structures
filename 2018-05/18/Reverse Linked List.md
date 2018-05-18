Reverse a singly linked list.

**Example:**
```
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```
**Follow up:**

A linked list can be reversed either iteratively or recursively. Could you implement both?

**Solution:**
```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head, prev = None):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if (head == None):
            return
        if (prev == None):
            head.next = None
        else:
            head.next = prev
        self.reverseList(head.next, head)
```
