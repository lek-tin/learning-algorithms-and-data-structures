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
        # https://www.youtube.com/watch?v=f45_eF1gmn8
        root = ListNode(0)
        root.next = head
        pre = root
        # while new start is not None
        while pre.next:
            # the new following element being exists
            if pre.next.next:
                # reference: when pre changes, temp changes TOO
                # e.g.,[1,2,3,4]
                # temp = 1
                temp = pre.next
                # exchange 3 nodes
                # pre -> 2
                pre.next = temp.next
                # temp.next is 2, 1 -> 3
                temp.next = temp.next.next
                # 2 -> 1
                pre.next.next = temp
                # pre = 3
                print(temp.val)
                pre = temp
            else:
                break
        return root.next
```
