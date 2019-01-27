package e19.p2;

public class List {

    private class Node {
        private String st;
        private Node next;

        public Node(String st, Node next) {
            this.st = st;
            this.next = next;
        }

        public Node(String st) {
            this.st = st;
            next = null;
        }
    }

    private Node head;

    public void add(String st) {
        if(head == null) {
            head = new Node(st);
            return;
        }
        Node tmp = head;
        while (tmp != null) {
            if(tmp.st.equals(st))
                return;
            tmp = tmp.next;
        }
        head = new Node(st, head);
    }

    public void show() {
        while (head != null) {
            System.out.println(head.st);
            head = head.next;
        }
    }
}
