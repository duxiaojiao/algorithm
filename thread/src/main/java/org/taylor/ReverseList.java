package org.taylor;

/**
 * @author taylor
 * @date 2019/12/23 23:13
 */
public class ReverseList {


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.list();
        ListNode listNode = linkedList.reverseList(linkedList.getHead());
        linkedList.setHead(listNode);
        linkedList.list();

    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class LinkedList {
    private ListNode head;
    private ListNode current;

    void add(int val) {
        if (head == null) {
            head = new ListNode(val);
            current = head;
        } else {
            current.next = new ListNode(val);
            current = current.next;
        }
    }

    void list() {
        ListNode cur = head;
        if (cur == null) {
            System.out.print("链表中没有数据" + "\n");
        }
        while (cur != null) {
            System.out.print(cur.val + "\n");
            cur = cur.next;
        }
    }

    ListNode getHead() {
        return head;
    }

    void setHead(ListNode head) {
        this.head = head;
    }

    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
