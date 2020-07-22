/**
 * @author lyq on 2020-07-22 11:38 下午
 * @desc 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class 删除列表的倒数第n个节点 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode firstNode = node;
        ListNode secondNode = node;
        //第一个节点走n+1步
        for (int first = 1;first <= n + 1;first++) {
            firstNode = firstNode.next;
        }
        while (firstNode != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        secondNode.next = secondNode.next.next;
        return node.next;
    }

}
