package LinkedList;

import java.util.HashMap;

/**
 * Created by piyush.bajaj on 15/03/17.
 */
public class LRUCache_Practice {
    private HashMap<Integer, Node> pageMap;
    private DoublyLinkedList pageList;
    private final int cache_size;


    LRUCache_Practice(int size){
        this.cache_size = size;
        pageMap = new HashMap<Integer, Node>();
        pageList = new DoublyLinkedList(size);
    }

    public void accessPage(int pageNum){
        Node pageNode = null;
        if (pageMap.containsKey(pageNum)){
            pageList.movePageToHead(pageNum);
        }
        else{
            if(pageMap.size() == this.cache_size){

                pageMap.remove(pageList.getTail().getPageNum());
            }
            pageNode =  pageList.addNewPages(pageNum);
            pageMap.put(pageNum, pageNode);
        }
    }

    public void printCacheState(){
        pageList.printList();

    }

    public static void main(String[] args) {
        LRUCache_Practice LRU = new LRUCache_Practice(4);
        LRU.accessPage(4);
        LRU.printCacheState();
        LRU.accessPage(2);
        LRU.printCacheState();
        LRU.accessPage(1);
        LRU.printCacheState();
        LRU.accessPage(1);
        LRU.printCacheState();
        LRU.accessPage(4);
        LRU.printCacheState();
        LRU.accessPage(3);
        LRU.printCacheState();
        LRU.accessPage(7);
        LRU.printCacheState();
        LRU.accessPage(8);
        LRU.printCacheState();
        LRU.accessPage(3);
        LRU.printCacheState();

    }

    class DoublyLinkedList{
        int size = 0;
        int currSize = 0;
        Node head, tail;

        DoublyLinkedList(int dll_size){
            this.size = dll_size;
            this.currSize = 0;

        }

        public void printList(){
            Node temp = this.head;

            while (temp!=null){
                System.out.print(temp);
                temp = temp.next;
            }
            System.out.println();

        }



        public Node getHead(){
            return this.head;
        }

        public Node getTail(){
            return this.tail;
        }

        public Node movePageToHead(int PageNum){
            Node pageNode = new Node(PageNum);

            Node temp = this.head;

            if(head.getPageNum() == PageNum){
                return head;
            }
            if(tail.getPageNum() == PageNum){
                tail = tail.getPrev();
                tail.setNext(null);
                pageNode.setPrev(null);
                pageNode.setNext(head);
                head.setPrev(pageNode);

                head = pageNode;

                return pageNode;

            }
            while (temp.getPageNum() != PageNum){
                temp = temp.getNext();
            }

            Node prevNode = temp.getPrev();
            Node nextNode = temp.getNext();

            //if(prevNode!=null)
                prevNode.setNext(nextNode);
            //if(nextNode!=null)
                nextNode.setPrev(prevNode);

            pageNode.setPrev(null);
            pageNode.setNext(head);
            head.setPrev(pageNode);

            head = pageNode;

            String str = "abc";
            str.charAt(1);

            return pageNode;
        }

        public Node addNewPages(int PageNum){
            Node pageNode = new Node(PageNum);

            if(this.size == this.currSize){
                //LinkedList.Node temp = this
                tail = tail.getPrev();
                tail.setNext(null);

                pageNode.setNext(head);
                head.setPrev(pageNode);
                head = pageNode;

                //this.currSize++;

                return pageNode;

            }
            else {
                if(head == null){
                    head = pageNode;
                    tail = pageNode;
                    this.currSize++;

                    return pageNode;
                }
                else {
                    pageNode.setNext(head);
                    head.setPrev(pageNode);
                    head = pageNode;

                    this.currSize++;
                    return pageNode;
                }

            }
            //return pageNode;
        }


    }

    class Node{
        private int pageNum;
        private Node next, prev;

        Node(int pageNum){
            this.pageNum = pageNum;
            this.next = null;
            this.prev = null;
        }

        public int getPageNum(){
            return this.pageNum;
        }

        public Node getNext(){
            return this.next;
        }

        public void setNext(Node Nd){
            this.next = Nd;
        }

        public Node getPrev(){
            return this.prev;
        }

        public void setPrev(Node Nd){
            this.prev = Nd;
        }

        @Override
        public String toString(){
            return this.pageNum + " ";
        }




    }
}
