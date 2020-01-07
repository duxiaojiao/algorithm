package org.taylor;

/**
 * @author taylor
 * @date 2019/12/23 23:13
 */
public class ReverseList {


    public static void main(String[] args) {
//        LinkedList linkedList = new LinkedList();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.add(4);
//
//        linkedList.list();
//        ListNode listNode = linkedList.reverseList(linkedList.getHead());
//        linkedList.setHead(listNode);
//        linkedList.list();
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.add(2);
        list1.add(4);
        list1.add(3);

        list2.add(5);
        list2.add(6);
        list2.add(4);

        ListNode listNode = list1.addTwoNumbers(list1.getHead(), list2.getHead());
        System.out.println(listNode);

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
        ListNode preNode = null;
        ListNode nextNode = null;
        while (head != null) {
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;
    }

    /**
     * 两个链表相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode  listNode= new ListNode(0);
        ListNode p = listNode;
        int sum = 0;

        while (l1 != null || l2 != null || sum != 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum % 10);
            sum = sum / 10;
            p = p.next;
        }
        return listNode.next;
    }
}
