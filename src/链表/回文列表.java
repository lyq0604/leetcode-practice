package 链表;

/**
 * @author lyq on 2020-12-19 下午9:27
 * @desc 判断一个链表是否为回文链表。
 */
public class 回文列表 {

    public static boolean isPalindrome(ListNode head) {
        // 寻找中间位置节点(slow)
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 链表长度为奇数
        if (fast != null) {
            slow = slow.next;
        }
        // 反转后半部分节点
        slow = reverse(slow);
        fast = head;
        // 遍历比较
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
