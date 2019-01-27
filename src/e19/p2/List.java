package e19.p2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
        int place = 0;
        Node tmp = head;
        while (tmp != null) {
            if(tmp.st.equals(st)) return;
            if (st.compareToIgnoreCase(tmp.st) > 0)
                place++;
            tmp = tmp.next;
        }

        if(place == 0) {
            head = new Node(st, head);
            return;
        }
        Node tmp2 = head;
        while ((place - 1 ) > 0){
            tmp2 = tmp2.next;
            place--;
        }
        tmp2.next = new Node(st, tmp2.next);
    }

    public void toFile(String fileName) {
        try (PrintWriter pw = new PrintWriter(fileName + " strings")) {
            while (head != null) {
                pw.println(head.st);
                head = head.next;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
