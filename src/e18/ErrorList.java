package e18;

public class ErrorList {
    private Error top;
    private Error tail;

    public void push(int l, char f, char e) {
        top = new Error(l, f, e, top);
        if(tail == null)
            tail = top;
    }

    public boolean empty() {
        return top == null;
    }

    public Error getTail() {
        return tail;
    }

    public void removeLast() {
        if(top != tail) {
            Error tmp = top;
            while (tmp.getNext() != tail)
                tmp = tmp.getNext();
            tail = tmp;
            tail.setNull();
        }
        else top = tail = null;
    }

}
