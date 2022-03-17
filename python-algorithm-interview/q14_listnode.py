# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def print_all(self):
        while self:
            print(self.val, end=' ')
            self = self.next
        print()


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if (not l1) or (l2 and l1.val > l2.val):
            l1, l2 = l2, l1
        if l1:
            l1.next = self.mergeTwoLists(l1.next, l2)
        return l1


if __name__ == '__main__':
    list1 = ListNode(2)
    list1.next = ListNode(6)
    list1.next.next = ListNode(7)

    list2 = ListNode(1)
    list2.next = ListNode(3)
    list2.next.next = ListNode(9)

    result = Solution().mergeTwoLists(list1, list2)
    while result:
        print(result.val)
        result = result.next
