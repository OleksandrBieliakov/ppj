package ppj.e18;

public class ParenStack {

    private Node top;

    public void push(char p) {
        top = new Node(p, top);
    }

    public char pop() {
        char tmp = top.getBracket();
        top = top.getNext();
        return tmp;
    }

    public boolean empty(){
        return top == null;
    }

    public char removeLast() {
        Node tmp = top;
        if (tmp.getNext() == null){
            top = null;
            return tmp.getBracket();
        }

        while (tmp.getNext().getNext() != null) {
            tmp = tmp.getNext();
        }
        char br = tmp.getNext().getBracket();
        tmp.nextNull();
        return br;
    }

}
