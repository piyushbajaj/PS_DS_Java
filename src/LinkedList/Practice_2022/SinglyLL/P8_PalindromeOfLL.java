package LinkedList.Practice_2022.SinglyLL;

/**
 * Created by bajajp on 29 May, 2022
 */
public class P8_PalindromeOfLL extends CommonUtils {

    public boolean isPalindrome(Node head) {

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow);
        while (slow != null && (slow.data == head.data)) {
            head = head.next;
            slow = slow.next;
        }
        return slow == null;
    }

    private Node reverse(Node head) {
        if (head == null) return null;
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        P8_PalindromeOfLL p8PalindromeOfLL = new P8_PalindromeOfLL();
        p8PalindromeOfLL.insert(10, 0);
        p8PalindromeOfLL.insert(20, 1);
        p8PalindromeOfLL.insert(30, 2);
        p8PalindromeOfLL.insert(20, 3);
        p8PalindromeOfLL.insert(10, 4);
        p8PalindromeOfLL.printLL();

        System.out.println(p8PalindromeOfLL.isPalindrome(p8PalindromeOfLL.head));

    }
}
