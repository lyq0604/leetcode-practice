/**
 * @author lyq on 2020-07-23 8:18 下午
 * @desc 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class 合并两个有序链表 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode res = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                preHead.next = l1;
                l1 = l1.next;
            } else {
                preHead.next = l2;
                l2 = l2.next;
            }
            preHead = preHead.next;
        }
        if (l1 != null) {
            while (l1 != null) {
                preHead.next = l1;
                l1 = l1.next;
                preHead = preHead.next;
            }
        } else {
            while (l2 != null) {
                preHead.next = l2;
                l2 = l2.next;
                preHead = preHead.next;
            }
        }
        return res.next;
    }

}
