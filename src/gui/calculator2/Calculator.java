package gui.calculator2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Calculator extends JPanel {

    private JLabel output = new JLabel();
    private JTextPane history = new JTextPane();
    private CalButton systems = new CalButton("DEC", this) {
        @Override
        void addListener() {
        }
    };
    private DecListener decL = new DecListener(this);
    private HexListener hexL = new HexListener(this);
    private OctListener octL = new OctListener(this);
    private BinListener binL = new BinListener(this);
    private LettersPanel lettersPanel = new LettersPanel(this);
    private NumSyst numSyst = NumSyst.DECIMAL;
    private OperButton dotB;
    private NumButton num1B = new NumButton("1", this);
    private NumButton num2B = new NumButton("2", this);
    private NumButton num3B = new NumButton("3", this);
    private NumButton num4B = new NumButton("4", this);
    private NumButton num5B = new NumButton("5", this);
    private NumButton num6B = new NumButton("6", this);
    private NumButton num7B = new NumButton("7", this);
    private NumButton num8B = new NumButton("8", this);
    private NumButton num9B = new NumButton("9", this);
    private NumButton num0B = new NumButton("0", this);

    Calculator() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_RIGHT);
        history.setParagraphAttributes(attribs, true);
        history.setPreferredSize(new Dimension(100, 100));
        history.setEditable(false);
        history.setText("HISTORY");
        history.setBackground(Color.LIGHT_GRAY);
        JScrollPane scr = new JScrollPane(history);
        add(scr);


        output.setText("0");
        output.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setMaximumSize(new Dimension(2000, 30));
        output.setBorder(new EmptyBorder(5, 5, 5, 5));
        output.setFont(new Font(getFont().getName(), Font.BOLD, 20));
        panel.add(output);
        add(panel);


        JPanel buttons = new JPanel(new GridLayout(5, 5));

        CalButton clearB = new CalButton("C", this) {
            @Override
            void addListener() {
                addActionListener(e -> {
                    output.setText("0");
                });
            }
        };
        clearB.setBackground(Color.ORANGE);
        clearB.setForeground(Color.BLACK);

        CalButton backspaceB = new CalButton("DEL", this) {
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

        CalButton xB = new CalButton("POLY", this) {
            @Override
            void addListener() {

            }
        };
        xB.setBackground(Color.ORANGE);
        xB.setForeground(Color.BLACK);

        OperButton divisionB = new OperButton("/", this);
        OperButton xPowerB = new OperButton("^", this);

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

        systems.setBackground(Color.ORANGE);
        systems.setForeground(Color.BLACK);

        OperButton percentB = new OperButton("%", this);

        systems.addActionListener(decL);

        dotB = new OperButton(".", this) {
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
        buttons.add(systems);
        buttons.add(num0B);
        buttons.add(dotB);
        buttons.add(plusB);
        buttons.add(equalsB);

        add(buttons);
    }

    void toHex() {
        systems.setText("HEX");
        add(lettersPanel);
        systems.removeActionListener(decL);
        systems.addActionListener(hexL);
        numSyst = NumSyst.HEXADECIMAL;
        output.setText("0");
        dotB.setEnabled(false);
        dotB.setBackground(Color.GRAY);
    }

    void toOct() {
        systems.setText("OCT");
        remove(lettersPanel);
        systems.removeActionListener(hexL);
        systems.addActionListener(octL);
        numSyst = NumSyst.OCTAL;
        output.setText("0");
        num8B.setEnabled(false);
        num8B.setBackground(Color.GRAY);
        num9B.setEnabled(false);
        num9B.setBackground(Color.GRAY);
    }

    void toBin() {
        systems.setText("BIN");
        systems.removeActionListener(octL);
        systems.addActionListener(binL);
        numSyst = NumSyst.BINARY;
        output.setText("0");
        num2B.setEnabled(false);
        num2B.setBackground(Color.GRAY);
        num3B.setEnabled(false);
        num3B.setBackground(Color.GRAY);
        num4B.setEnabled(false);
        num4B.setBackground(Color.GRAY);
        num5B.setEnabled(false);
        num5B.setBackground(Color.GRAY);
        num6B.setEnabled(false);
        num6B.setBackground(Color.GRAY);
        num7B.setEnabled(false);
        num7B.setBackground(Color.GRAY);
    }

    void toDec() {
        systems.setText("DEC");
        systems.removeActionListener(binL);
        systems.addActionListener(decL);
        numSyst = NumSyst.DECIMAL;
        output.setText("0");
        dotB.setEnabled(true);
        dotB.setBackground(Color.DARK_GRAY);
        num2B.setEnabled(true);
        num2B.setBackground(Color.DARK_GRAY);
        num3B.setEnabled(true);
        num3B.setBackground(Color.DARK_GRAY);
        num4B.setEnabled(true);
        num4B.setBackground(Color.DARK_GRAY);
        num5B.setEnabled(true);
        num5B.setBackground(Color.DARK_GRAY);
        num6B.setEnabled(true);
        num6B.setBackground(Color.DARK_GRAY);
        num7B.setEnabled(true);
        num7B.setBackground(Color.DARK_GRAY);
        num8B.setEnabled(true);
        num8B.setBackground(Color.DARK_GRAY);
        num9B.setEnabled(true);
        num9B.setBackground(Color.DARK_GRAY);
    }

    String getOutput() {
        return output.getText();
    }

    void setOutput(String s) {
        output.setText(s);
    }

    void updateHistory(String s) {
        history.setText(history.getText() + "\n" + s);
    }

    NumSyst getSystem() {
        return numSyst;
    }

}
