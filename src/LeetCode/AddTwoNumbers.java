package LeetCode;

import java.util.Arrays;

public class AddTwoNumbers {
    /// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    ///
    /// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    ///
    ///
    ///
    /// Example 1:
    ///
    ///
    /// Input: l1 = [2,4,3], l2 = [5,6,4]
    /// Output: [7,0,8]
    /// Explanation: 342 + 465 = 807.
    /// Example 2:
    ///
    /// Input: l1 = [0], l2 = [0]
    /// Output: [0]
    /// Example 3:
    ///
    /// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    /// Output: [8,9,9,9,0,0,0,1]
    ///
    ///
    /// Constraints:
    ///
    /// The number of nodes in each linked list is in the range [1, 100].
    /// 0 <= Node.val <= 9
    /// It is guaranteed that the list represents a number that does not have leading zeros.
    ///
    /// /**
    ///  * Definition for singly-linked list.
    ///  * public class ListNode {
    ///  *     int val;
    ///  *     ListNode next;
    ///  *     ListNode() {}
    ///  *     ListNode(int val) { this.val = val; }
    ///  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ///  * }
    ///  */
    ///

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public AddTwoNumbers(){

        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int []{5, 6, 4});

        System.out.println("ListNode 1: " + printList(l1));
        System.out.println("ListNode 2: " + printList(l2));
        System.out.println("Added list: " + printList(addLists(l1, l2, 0)));

    }

    private ListNode addLists(ListNode l1, ListNode l2, int remainder){

        int thisNumber = l1.val + l2.val + remainder;
        int newRemainder = 0;
        if(thisNumber > 9)
        {
            thisNumber -= 10;
            newRemainder++;
        }
        ListNode nextL1 = l1.next;
        ListNode nextL2 = l2.next;

        if(null == nextL1 && null == nextL2 && newRemainder == 0)
        {
            return new ListNode(thisNumber);
        }
        else {
            return new ListNode(thisNumber, addLists(null == nextL1? new ListNode(0): nextL1, null == nextL2? new ListNode(0): nextL2, newRemainder));
        }
    }

    private ListNode createList(int[] list){
        if(list.length == 1)
        {
            return new ListNode(list[0]);
        }
        else{
            return new ListNode(list[0], createList(Arrays.copyOfRange(list, 1, list.length)));
        }
    }

    private String printList(ListNode listNode)
    {

        return listNode.val + (null == listNode.next ? "" : ", " + printList(listNode.next));
    }
}
