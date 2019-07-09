package gui.calculator2;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Calculator extends JPanel {

    private JLabel output = new JLabel();

    Calculator() {
        output.setText("0");
        output.setPreferredSize(new Dimension(100, 30));
        output.setHorizontalAlignment(SwingConstants.RIGHT);
        setLayout(new BorderLayout());
        add(output);

        JPanel buttons = new JPanel(new GridLayout(5, 5));


        JButton clearB = new JButton("C");
        clearB.addActionListener(e -> {
            output.setText("0");
        });

        CalButton backspaceB = new CalButton("Del", this) {
            @Override
            void addListener() {
                addActionListener(e -> {
                    String str = cal.getOutput();
                    int len = str.length();
                    if (len == 1) {
                        cal.setOutput("0");
                        return;
                    }
                    cal.setOutput(str.substring(0, len - 1));
                });
            }
        };

        NumButton addB = new NumButton("(", this);
        OperButton removeB = new OperButton(")", this) {
            @Override
            void addListener() {
                addActionListener(e -> {
                    String str = cal.getOutput();
                    Pattern p = Pattern.compile("[)]");
                    Matcher m = p.matcher(str);
                    int countClose = 0;
                    while (m.find()) {
                        countClose += 1;
                    }
                    p = Pattern.compile("[(]");
                    m = p.matcher(str);
                    int countOpen = 0;
                    while (m.find()) {
                        countOpen += 1;
                    }
                    char last = str.charAt(str.length() - 1);
                    if (countClose + 1 > countOpen || last == '(' || last == '\u221A' || last == '-') return;
                    char[] curr = cal.getOutput().toCharArray();
                    if (chars.contains(last)) {
                        curr[curr.length - 1] = title.charAt(0);
                        cal.setOutput(new String(curr));
                    } else {
                        cal.setOutput(str + title);
                    }
                });
            }
        };

        JButton xB = new JButton("Poly");

        NumButton num7B = new NumButton("7", this);
        NumButton num8B = new NumButton("8", this);
        NumButton num9B = new NumButton("9", this);

        OperButton divisionB = new OperButton("/", this);
        OperButton xPowerB = new OperButton("^", this);

        NumButton num4B = new NumButton("4", this);
        NumButton num5B = new NumButton("5", this);
        NumButton num6B = new NumButton("6", this);

        OperButton multiplB = new OperButton("*", this);
        OperButton sqRootB = new OperButton("\u221A", this) {
            @Override
            void addListener() {
                addActionListener(e -> {
                    char[] curr = cal.getOutput().toCharArray();
                    int i = curr.length - 1;
                    if (curr[i] == '.') {
                        curr[i] = title.charAt(0);
                        cal.setOutput(new String(curr));
                    } else if (cal.getOutput().equals("0")) {
                        setOutput(title);
                    } else {
                        cal.setOutput(cal.getOutput() + title);
                    }
                });
            }
        };

        NumButton num1B = new NumButton("1", this);
        NumButton num2B = new NumButton("2", this);
        NumButton num3B = new NumButton("3", this);

        OperButton minusB = new OperButton("-", this) {
            @Override
            void addListener() {
                addActionListener(e -> {
                    char[] curr = cal.getOutput().toCharArray();
                    int i = curr.length - 1;
                    if (curr[i] == '\u221A') return;
                    if (chars.contains(curr[i])) {
                        curr[i] = title.charAt(0);
                        cal.setOutput(new String(curr));
                    } else {
                        cal.setOutput(cal.getOutput() + title);
                    }
                });
            }
        };
        OperButton percentB = new OperButton("%", this);

        JButton lettersB = new JButton("A-X");

        NumButton num0B = new NumButton("0", this);

        OperButton dotB = new OperButton(".", this) {
            @Override
            void addListener() {
                addActionListener(e -> {
                    String str = cal.getOutput();
                    int len = str.length() - 1;
                    if (str.charAt(len) == '.') return;
                    chars.remove('.');
                    chars.add('(');
                    chars.add(')');
                    chars.add('-');
                    chars.add('\u221A');
                    if (chars.contains(str.charAt(len))) {
                        cal.setOutput(str + "0.");
                        return;
                    }
                    String[] parts = str.split("[+\\-*/%^\\u221A()]");
                    Pattern p = Pattern.compile("[.]");
                    Matcher m = p.matcher(parts[parts.length - 1]);
                    if (!m.find()) cal.setOutput(str + ".");
                });
            }
        };

        OperButton plusB = new OperButton("+", this);

        EqualsButton equalsB = new EqualsButton("=", this);

        buttons.add(clearB);
        buttons.add(backspaceB);
        buttons.add(addB);
        buttons.add(removeB);
        buttons.add(xB);
        buttons.add(num7B);
        buttons.add(num8B);
        buttons.add(num9B);
        buttons.add(divisionB);
        buttons.add(xPowerB);
        buttons.add(num4B);
        buttons.add(num5B);
        buttons.add(num6B);
        buttons.add(multiplB);
        buttons.add(sqRootB);
        buttons.add(num1B);
        buttons.add(num2B);
        buttons.add(num3B);
        buttons.add(minusB);
        buttons.add(percentB);
        buttons.add(lettersB);
        buttons.add(num0B);
        buttons.add(dotB);
        buttons.add(plusB);
        buttons.add(equalsB);

        add(buttons, BorderLayout.SOUTH);
    }

    String getOutput() {
        return output.getText();
    }

    void setOutput(String s) {
        output.setText(s);
    }

}
