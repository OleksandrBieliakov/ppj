package ppj.e14extra.p4;

public class Test {

    public static void main (String[] args) {
        /*
        Frac a = new Frac(20,4), b = new Frac(1,-2),
                c = new Frac(-14,-4), d = new Frac(-8,-4),
                f = new Frac(4), m = new Frac(-1);
        */
        Frac a = new Frac(20,4), b = new Frac(1,-2),
                c = new Frac(-14,-4), d = new Frac(-8,-4),
                f = new Frac(4), m = new Frac(-1);

        System.out.println(a + " " + b + " " + c + " " + d + " " + f + " " + m);

        try {
            Frac f2 = Frac.add(Frac.mul(d, c),
                    new Frac(10).mul(b));
            Frac f4 = Frac.add(Frac.mul(Frac.mul(a, b),
                    new Frac(-2)), m);
            Frac zz = d.add(a).add(f.mul(Frac.mul(b, c)));
            Frac ww = Frac.div(f2, f4).sub(b).sub(c);
            System.out.println(f2 + " " + f4 + " " +
                    zz + " " + ww);
        } catch (ArithmeticException ex) {
            System.out.println(ex);
        }

    }

}
