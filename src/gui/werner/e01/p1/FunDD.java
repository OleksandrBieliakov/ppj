package gui.werner.e01.p1;

@FunctionalInterface
interface FunDD {
    double fun(double x);

    static double xminim(FunDD f, double a, double b) {
        double minX = a;
        double minY = f.fun(a);
        for(double i = a + 1e-5; i <= b; i += 1e-5) {
            if(f.fun(i) < minY)
                minX = i;
                minY = f.fun(i);
        }
        return minX;
    }
}
