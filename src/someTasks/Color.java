package someTasks;

public class Color {

    public static void main(String[] args) {

        int argb = 293274;
        System.out.println("argb to hex = " + Integer.toHexString(argb));

        argb >>>= 8;

        int g = argb & 255;

        System.out.println("  g  to hex =  " + Integer.toHexString(g));
        System.out.println("g = " + g);
    }

}
