package Session.Util;

/**
 * Project: DSAlgo
 * Package: Session.Util
 * <p>
 * User: piyushbajaj
 * Date: 22/12/24
 * Time: 1:03 pm
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
