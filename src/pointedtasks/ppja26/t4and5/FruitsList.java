package pointedtasks.ppja26.t4and5;

public class FruitsList {
    private Fruit head;

    public void push (String s, int seeds) {
        if(head == null) head = new Fruit(s, seeds);
        else {
            head = new Fruit(s, seeds, head);
        }
    }

    public Fruit pop() {
        Fruit tmp = head;
        head = head.getNext();
        return tmp;
    }

    public boolean empty(){
        return head == null;
    }

}
