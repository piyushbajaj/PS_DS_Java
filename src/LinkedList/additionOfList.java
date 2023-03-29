package LinkedList;

/**
 * Created by piyush.bajaj on 09/02/17.
 */
public class additionOfList {
    Node head;

    public static void main(String[] args) {
        additionOfList ad1 = new additionOfList();
        ad1.head = new Node(5);
        ad1.insert(6);
        ad1.insert(3);

        System.out.println("First Array is: ");
        ad1.printList(ad1.head);

        additionOfList ad2 = new additionOfList();
        ad2.head = new Node(8);
        ad2.insert(4);
        ad2.insert(2);

        System.out.println("Second Array is: ");
        ad2.printList(ad2.head);

        additionOfList ad3 = new additionOfList();

        ad3.head = ad3.additionOfLinkedList(ad1.head, ad2.head);

        ad3.printList(ad3.head);

        String abc = "";


//        int[] array1 = {1,2,3};
//        int[] array2 = {4,5,6};
//        //int[] array1and2 = array1 + array2;
//
//        int[] array1and2 = new int[array1.length + array2.length];
//        System.arraycopy(array1, 0, array1and2, 0, array1.length);
//        System.arraycopy(array2, 0, array1and2, array1.length, array2.length);

    }

    public void insert(int key) {
        if (head == null) {
            head = new Node(key);
            return;
        }

        Node Nd = head;
        while (Nd.next != null) {
            Nd = Nd.next;
        }
        Nd.next = new Node(key);
        return;

    }

    public void printList(Node key) {
        while (key != null) {
            System.out.print(key.data + " ");
            key = key.next;
        }
        System.out.println();
    }

    public int sizeOfLL(Node key) {
        int count = 0;
        while (key != null) {
            count++;
            key = key.next;
        }
        return count;
    }

//    public LinkedList.Node additionOfLinkedList(LinkedList.Node key1, LinkedList.Node key2, int carry){
//        if(key1 == null)
//            return null;
//        LinkedList.Node res = key1;
//        res.next = additionOfLinkedList(key1.next, key2.next, carry);
//
//        int sum = key1.data + key2.data + carry;
//        carry = sum/10;
//        res.data = sum % 10;
//
//        return res;
//
//    }
//        int[] i1 =new int[sizeOfLL(key1)];
//        int a = 0;
//        //String str ="";
//        while (key1!=null){
//            i1[a] = key1.data;
//            key1 = key1.next;
//            //str = String.valueOf(i1[a]);
//            //str += Character.toString(i1[a]).concat();
//            a++;
//        }
//
//
//        int[] i2 =new int[sizeOfLL(key2)];
//        int b = 0;
//        //String str ="";
//        while (key2!=null){
//            i2[b] = key2.data;
//            key2 = key2.next;
//            //str = String.valueOf(i1[a]);
//            //str += Character.toString(i1[a]).concat();
//            b++;
//        }

    //int[] i3 = i1 + i2;

    //System.out.println(str.charAt(0));

    //String str = Character.toString(i1);


    //System.out.println(str);
    //int l1 = (int)i1;


    //T.C: O(N), if n > m, or O(M), if m > n
    //S.C:
    public Node additionOfLinkedList(Node key1, Node key2) {
        Node res = null;
        Node temp = null, prev = null;
        int carry = 0, sum;

        while (key1 != null || key2 != null) {
            sum = carry + (key1 != null ? key1.data : 0) + (key2 != null ? key2.data : 0);

            carry = sum / 10;

            sum = sum % 10;

            temp = new Node(sum);

            if (res == null) {
                res = temp;
            } else {
                prev.next = temp;
            }

            prev = temp;

            if (key1 != null) {
                key1 = key1.next;
            }
            if (key2 != null) {
                key2 = key2.next;
            }
        }
        if (carry > 0) {
            temp.next = new Node(carry);
        }
        return res;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
}
