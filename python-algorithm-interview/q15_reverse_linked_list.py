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
    def reverseList(self, head: ListNode) -> ListNode:
        def reverse(node: ListNode, prev: ListNode = None):
            if not node:
                return prev
            test, node.next = node.next, prev
            return reverse(test, node)

        return reverse(head)

    def reverseList2(self, head: ListNode) -> ListNode:
        node, prev = head, None

        while node:

            next, node.next = node.next, prev

            prev, node = node, next

        return prev


if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    a = Solution().reverseList(head)

    a.print_all()
