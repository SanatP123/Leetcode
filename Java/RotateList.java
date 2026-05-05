public class RotateList {
    
// Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }



    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0){
            return head;
        }

        // Find length and tail
        int n = 1;
        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
            n++;
        }

        // Reduce k

        k = k % n;

        if (k == 0){
            return head;
        }

        // Make circular
        tail.next = head;

        // Find new tail
        int steps = n - k;
        ListNode newTail = head;
        for (int i = 1; i < steps; i++){
            newTail = newTail.next;
        }

        // break
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;


        
    }

    public static void main(String[] args) {
        RotateList sol = new RotateList();
        ListNode head = sol.new ListNode(1);
        head.next = sol.new ListNode(2);
        head.next.next = sol.new ListNode(3);
        head.next.next.next = sol.new ListNode(4);
        head.next.next.next.next = sol.new ListNode(5);
        int k = 2;
        ListNode ans = sol.rotateRight(head, k);
        while (ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
        System.out.println();

        RotateList sol2 = new RotateList();
        ListNode head2 = sol2.new ListNode(0);
        head2.next = sol2.new ListNode(1);
        head2.next.next = sol2.new ListNode(2);
        int k2 = 4;
        ListNode ans2 = sol2.rotateRight(head2, k2);
        while (ans2 != null){
            System.out.print(ans2.val + " ");
            ans2 = ans2.next;
        }
        System.out.println();
    }

    
}
