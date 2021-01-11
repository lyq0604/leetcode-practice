package 链表;

/**
 * @author lyq on 2021-01-11 下午8:47
 * @desc
 */
public class 寻找环形链表中环的入口 {

    public static ListNode searchEnter(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode index1 = head;
                ListNode index2 = slow;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

}
