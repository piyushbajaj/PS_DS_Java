package LinkedList.Practice_2022.SinglyLL;

public class ReversalKBlocks extends P1_ReversalOfLL {

    public static void main(String[] args) {
        ReversalKBlocks reversalKBlocks = new ReversalKBlocks();
        reversalKBlocks.insertInEnd(1);
        reversalKBlocks.insertInEnd(2);
        reversalKBlocks.insertInEnd(3);
        reversalKBlocks.insertInEnd(4);
        reversalKBlocks.insertInEnd(5);
        reversalKBlocks.insertInEnd(6);
//        reversalKBlocks.insertInEnd(7);
        System.out.println("Linked list before: ");
        reversalKBlocks.printLL();

        reversalKBlocks.printLL(reversalKBlocks.reverseKBlocks(2));
    }

    // TC: O(N)
    /*
    Algorithm:
    1. Initialize ptr with Head, basically to move as per the k blocks
    2. Reverse the LL for k blocks and assign the head of the reversed part to revHead
    2. newHead will be the new Head ptr of the whole reverse LL
    3. kTail is the last node of reversed block after every reversal
    4. revHead will s
     */
    public Node reverseKBlocks(int k) {
        if (head == null) {
            return null;
        }

        Node ptr = head;
        Node newHead = null, kTail = null;

        while (ptr != null) {
            int count = 0;

            while (ptr != null && count < k) {
                ptr = ptr.next;
                count++;
            }

            if (count == k) {
                Node reverseHead = reverseLinkedList(head, k);

                if (newHead == null) {
                    newHead = reverseHead;
                }

                if (kTail != null) {
                    kTail.next = reverseHead;
                }

                kTail = head;
                head = ptr;
            }
        }

        // Stick the last odd node from kTail to head
        if (kTail != null) {
            kTail.next = head;
        }

        return newHead;
    }
}
