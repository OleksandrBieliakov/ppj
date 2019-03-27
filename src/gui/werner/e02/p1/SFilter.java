package gui.werner.e02.p1;

@FunctionalInterface
public interface SFilter {

    boolean test(String s);

    static String[] filter(String[] arr, SFilter filt) {
        int count = 0;
        for (String st : arr) {
            if (filt.test(st))
                ++count;
        }
        String[] filtered = new String[count];
        count = 0;
        for (String st : arr) {
            if (filt.test(st))
                filtered[count++] = st;
        }
        return filtered;
    }

}
