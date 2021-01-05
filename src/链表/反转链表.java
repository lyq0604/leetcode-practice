package 链表;

/**
 * @author lyq on 2020-09-14 8:50 下午
 * @desc 单列表反转
 */
public class 反转链表 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1 = reverse2(node1);
    }

    /**
     * 迭代法: 迭代过程中将当前节点的next指针指向该节点之前的节点，因此需要创建pre节点用于记录当前节点的前一个节点。
     * @param head
     * @return
     */
    public static ListNode reverse1(ListNode head) {
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

    /**
     * 递归法：递归至链表结尾时，假设当cur之后的部分都已经翻转完毕时，要将cur.next节点的next指针指向cur。
     * @param head
     * @return
     */
    public static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
