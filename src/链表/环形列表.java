package 链表;

/**
 * @author lyq on 2020-12-19 下午9:16
 * @desc 判断链表中是否有环
 */
public class 环形列表 {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

}
