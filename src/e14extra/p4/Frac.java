package e14extra.p4;

public class Frac {

    private int num;
    private int denom;

    public Frac (int num, int denom) {
        int gcd = gcd(num, denom);
        if(denom < 0){
            num *= -1;
            denom *= -1;
        }
        if(num == 0) denom = 1;
        this.num = num/gcd;
        this.denom = denom/gcd;
    }

    public Frac (int num) {
        this(num, 1);
    }

    public Frac () {
        this(0);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }

    public static Frac add(Frac a, Frac b) {
        return new Frac(a.num * b.denom + b.num * a.denom, a.denom * b.denom);
    }

    public Frac add(Frac other) {
        num = num * other.denom + other.num * denom;
        denom *= other.denom;
        return this;
    }

    public static Frac sub(Frac a, Frac b) {
        return new Frac(a.num * b.denom - b.num * a.denom, a.denom * b.denom);
    }

    public Frac sub(Frac other) {
        num = num * other.denom - other.num * denom;
        denom *= other.denom;
        return this;
    }

    public static Frac mul(Frac a, Frac b) {
        return new Frac(a.num * b.num, a.denom * b.denom);
    }

    public Frac mul(Frac other) {
        num *= other.num;
        denom *= other.denom;
        return this;
    }

    public static Frac div(Frac a, Frac b) {
        if(b.num == 0)
            throw new ArithmeticException("Cannot divide by zero.");
        return new Frac(a.num * b.denom, a.denom * b.num);
    }

    public Frac div(Frac other) {
        if(other.num == 0)
            throw new ArithmeticException("Cannot divide by zero.");
        num *= other.denom;
        denom *= other.num;
        return this;
    }

    @Override
    public int hashCode() {
        return num/denom + num%denom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return false;
    }

    @Override
    public String toString() {
        if(denom == 1) return num + "";
        return num + "/" + denom;
    }

}
