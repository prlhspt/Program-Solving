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
    def swapParis(self, head: ListNode) -> ListNode:
        cur = head

        while cur and cur.next:
            cur.val, cur.next.val = cur.next.val, cur.val
            cur = cur.next.next

        return head

    def swapParis2(self, head: ListNode) -> ListNode:
        root = prev = ListNode(None)
        prev = head
        while head and head.next:
            b = head.next
            head.next = b.next
            b.next = head

            prev = b

            head = head.next
            prev = prev.next.next
        return root.next


if __name__ == "__main__":
    list1 = ListNode(1)
    list1.next = ListNode(2)
    list1.next.next = ListNode(3)
    list1.next.next.next = ListNode(4)
    list1.next.next.next.next = ListNode(5)
    list1.next.next.next.next.next = ListNode(6)
    list1.next.next.next.next.next.next = ListNode(7)
    list1.next.next.next.next.next.next.next = ListNode(8)

    Solution().swapParis2(list1).print_all()
