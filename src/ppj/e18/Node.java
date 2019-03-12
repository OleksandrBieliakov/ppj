package ppj.e18;

public class Node {

    private char bracket;
    private Node next;

    public Node(char p, Node next) {
        bracket = p;
        this.next = next;
    }

    public char getBracket(){
        return bracket;
    }

    public Node getNext(){
        return next;
    }

    public void nextNull() {
        next = null;
    }

}
