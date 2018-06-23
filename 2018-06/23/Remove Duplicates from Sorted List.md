Given a sorted linked list, delete all duplicates such that each element appear only once.

**Example 1:**
```
Input: 1->1->2
Output: 1->2
```
**Example 2:**
```
Input: 1->1->2->3->3
Output: 1->2->3
```

**Solution:**
```python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        curr = head
        while curr != None and curr.next != None:
            if curr.val == curr.next.val:
                curr.next = curr.next.next
            else:
                curr = curr.next
        return head
```
