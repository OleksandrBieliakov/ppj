package e14extra.p4;
import java.util.Objects;

public class Frac {

    private int num;
    private int denom;

    public Frac (int num, int denom) {
        this.num = numFormat(num, denom);
        this.denom = denomFormat(num, denom);
    }

    public Frac (int num) {
        this(num, 1);
    }

    public Frac () {
        this(0);
    }

    private int numFormat (int num, int denom) {
        if(num == 0) return 0;
        int gcd = gcd(num, denom);
        if (denom/gcd < 0) return num / gcd * -1;
        return num / gcd;
    }

    private int denomFormat (int num, int denom) {
        if(num == 0) return 1;
        int gcd = gcd(num, denom);
        if (denom/gcd < 0) return denom / gcd * -1;
        return denom / gcd;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }

    public static Frac add(Frac a, Frac b) {
        return new Frac(a.num * b.denom + b.num * a.denom, a.denom * b.denom);
    }

    public Frac add(Frac other) {
        int newNum = num * other.denom + other.num * denom;
        int newDenom = denom * other.denom;
        num = numFormat(newNum, newDenom);
        denom = denomFormat(newNum, newDenom);
        return this;
    }

    public static Frac sub(Frac a, Frac b) {
        return new Frac(a.num * b.denom - b.num * a.denom, a.denom * b.denom);
    }

    public Frac sub(Frac other) {
        int newNum = num * other.denom - other.num * denom;
        int newDenom = denom * other.denom;
        num = numFormat(newNum, newDenom);
        denom = denomFormat(newNum, newDenom);
        return this;
    }

    public static Frac mul(Frac a, Frac b) {
        return new Frac(a.num * b.num, a.denom * b.denom);
    }

    public Frac mul(Frac other) {
        int newNum = num * other.num;
        int newDenom = denom * other.denom;
        num = numFormat(newNum, newDenom);
        denom = denomFormat(newNum, newDenom);
        return this;
    }

    public static Frac div(Frac a, Frac b) throws ArithmeticException{
        if(b.num == 0)
            throw new ArithmeticException ("Cannot divide by zero.");
        return new Frac(a.num * b.denom, a.denom * b.num);
    }

    public Frac div(Frac other) throws ArithmeticException {
        if(other.num == 0)
            throw new ArithmeticException("Cannot divide by zero.");
        int newNum = num * other.denom;
        int newDenom = denom * other.num;
        num = numFormat(newNum, newDenom);
        denom = denomFormat(newNum, newDenom);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, denom);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frac frac = (Frac) o;
        return num == frac.num && denom == frac.denom;
    }

    @Override
    public String toString() {
        if(denom == 1) return num + "";
        return num + "/" + denom;
    }

}
