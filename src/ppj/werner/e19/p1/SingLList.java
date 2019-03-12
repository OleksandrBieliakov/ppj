package ppj.werner.e19.p1;

public class SingLList {

    private class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;

    public boolean empty(){
        return head == null;
    }

    public void addFront(int d) {
        if(empty()) {
            head = new Node(d);
            return;
        }
        head = new Node(d, head);
    }

    public void addBack(int d) {
        if(empty()) {
            head = new Node(d);
            return;
        }
        Node tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = new Node(d);
    }

    public static SingLList arrayToList(int[] arr) {
        SingLList list = new SingLList();
        for(int i = arr.length - 1; i >= 0; --i){
            list.addFront(arr[i]);
        }
        return list;
    }

    public void removeOddRecursive() {
        if(empty()) return;
        if(head.data%2 != 0) {
            head = head.next;
            removeOddRecursive();
            return;
        }
        Node tmp = head;
        Node tmpNext = tmp.next;
        while (tmpNext != null){
            if(tmpNext.data%2 != 0)
                tmp.next = tmpNext.next;
            else
                tmp = tmpNext;
            tmpNext = tmpNext.next;
        }
    }

    public void removeOdd() {
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            if (cur.data % 2 != 0)
                if (prev != null)
                    prev.next = next;
                else
                    head = next;
            else
                prev = cur;
            cur = next;
        }
    }

    public boolean contains(int d) {
        Node tmp = head;
        while(tmp != null) {
            if(tmp.data == d)
                return true;
            tmp = tmp.next;
        }
        return false;
    }

    public void showList() {
        if(empty()) {
            System.out.println("Empty list");
            return;
        }
        Node tmp = head;
        while(tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void clear() {
        head = null;
    }

}
