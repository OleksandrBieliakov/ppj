package ppj.werner.e12;

public class StringMisc {

    public static String norm(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(name.substring(0,1).toUpperCase())
           .append(name.substring(1, name.length()).toLowerCase());
        return sb.toString();
    }

    public static String init(String name) {
        StringBuilder sb = new StringBuilder();
        String[] parts = name.split(" ");
        for(int i = 0; i < parts.length - 1; ++i) {
            sb.append(parts[i].substring(0,1).toUpperCase())
               .append(". ");
        }
        sb.append(parts[parts.length - 1].substring(0,1).toUpperCase())
           .append(parts[parts.length - 1].substring(1, parts[parts.length - 1].length()).toLowerCase());
        return sb.toString();
    }

    public static String tr(String s, String from, String to) {
        StringBuilder sb = new StringBuilder();
        char[] charsS = s.toCharArray();
        char[] charsFrom = from.toCharArray();
        char[] charsTo = to.toCharArray();

        MAIN_LOOP: for (int i = 0; i < charsS.length; ++i) {
                       for (int j = 0; j < charsFrom.length; ++j) {
                            if(charsS[i] == charsFrom[j]) {
                                sb.append(charsTo[j]);
                                continue MAIN_LOOP;
                            }
                        }
                        sb.append(charsS[i]);
                    }

        return sb.toString();
    }

    public static void main (String[] args) {
        System.out.println(norm("caravaggio"));
        System.out.println(norm("VERMEER"));
        System.out.println(init("johann sebastian bach"));
        System.out.println(init("i. babeL"));
        System.out.println(init("jorge LUIS BORGES"));
        System.out.println(init("WOLFGANG a. mozart"));
        System.out.println(tr("November 2016",
                "abcdefghijklmnopqrstuvwyz",
                "ABCDEFGHIJKLMNOPQRSTUVWYZ"));
        System.out.println(tr("abcXYZ","aZcX","||Cx"));
    }

}