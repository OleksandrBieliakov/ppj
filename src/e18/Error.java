package e18;

public class Error {
    private int location;
    private char found;
    private char expected;
    private Error next;

    public Error(int l, char f, char e, Error n) {
        location = l;
        found = f;
        expected = e;
        next = n;
    }

    public Error getNext() {
        return next;
    }

    public int getLocation() {
        return location;
    }

    public char getFound() {
        return found;
    }

    public char getExpected() {
        return expected;
    }

    public void setNull(){
        next = null;
    }

}
