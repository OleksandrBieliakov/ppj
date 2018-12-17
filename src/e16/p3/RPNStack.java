package e16.p3;

public class RPNStack {

    private Node top;

    public RPNStack() {
        top = null;
    }

    public void push (double d) {
        top = new Node(d, top);
    }

    public double pop() {
        double old = top.getVal();
        top = top.getNext();
        return old;
    }

    public boolean empty() {
        return top == null;
    }

    public void clearStack() {
        this.top = null;
    }

}
