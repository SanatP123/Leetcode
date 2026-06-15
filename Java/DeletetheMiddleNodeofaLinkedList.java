


public class DeletetheMiddleNodeofaLinkedList {
    //  Definition for singly-linked list.
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move slow by 1 and fast by 2
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
        slow.next = null;

        return head;

        
    }

    public static void main(String[] args) {
        DeletetheMiddleNodeofaLinkedList solution = new DeletetheMiddleNodeofaLinkedList();
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(3);
        head.next.next = solution.new ListNode(4);
        head.next.next.next = solution.new ListNode(7);
        head.next.next.next.next = solution.new ListNode(1);
        head.next.next.next.next.next = solution.new ListNode(2);
        head.next.next.next.next.next.next = solution.new ListNode(6);
        ListNode result = solution.deleteMiddle(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
        // Output: 1,3,4,1,2,6

        DeletetheMiddleNodeofaLinkedList solution2 = new DeletetheMiddleNodeofaLinkedList();
        ListNode head2 = solution2.new ListNode(1);
        head2.next = solution2.new ListNode(2);
        head2.next.next = solution2.new ListNode(3);    
        head2.next.next.next = solution2.new ListNode(4);
        ListNode result2 = solution2.deleteMiddle(head2);
        while (result2 != null) {
            System.out.print(result2.val + " ");
            result2 = result2.next;
            
        }
        System.out.println();
        // Output: 1,2,4

        DeletetheMiddleNodeofaLinkedList solution3 = new DeletetheMiddleNodeofaLinkedList();
        ListNode head3 = solution3.new ListNode(2);
        head3.next = solution3.new ListNode(1);
        ListNode result3 = solution3.deleteMiddle(head3);
        while (result3 != null) {
            System.out.print(result3.val + " ");
            result3 = result3.next;
        }

        // Output: 2
    }
    
}
