import java.util.HashSet;

public class LinkedListCycle {

    public static void main(String[] args) {

        System.out.println("Module: " + (0 % 2));

        // Test case 1: No cycle
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println("Test case 1: " + hasCycleNotOptimized(head1)); // Expected output: false

        // Test case 2: Cycle exists
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = head2; // Creating a cycle
        System.out.println("Test case 2: " + hasCycleNotOptimized(head2)); // Expected output: true

    }

    public static boolean hasCycle(ListNode head) {

        if (head == null) // Check if the list is empty or has only one node
            return false;

        ListNode temp = head.next, tempSlower = head;

        for (int i = 0; temp != null; i++) {
            if (i % 2 !=  0)
                tempSlower = tempSlower.next; // Move forward temSlower on odd i
            if (tempSlower == temp) // Check if the pointers are equal
                return true; // There's a cycle
            temp = temp.next;
            // Check if the pointers cycle (Means there's a cycle)
        }


        return false;
    }

    public static boolean hasCycleNotOptimized(ListNode head) {
        if (head == null) // Check if the list is empty or has only one node
            return false;

        ListNode temp = head;
        HashSet<ListNode> set = new HashSet<ListNode>();

        while (temp!= null) {
            if (set.add(temp))
                temp = temp.next; // Move forward
            else
                return true; // There's a cycle
        }

        return false;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

}
