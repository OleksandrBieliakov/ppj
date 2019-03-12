package ppj.werner.e18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ParenStack stack = new ParenStack();
        StringBuilder str = new StringBuilder();
        ErrorList errors = new ErrorList();
        int read;
        int lineCount = 1;
        int erLoc = 0;
        char expected;
        boolean ok = true;

        try {
            FileInputStream fis = new FileInputStream("data/e18data");
            while ((read = fis.read()) != -1) {
                if (read == '\n') {
                    while (!errors.empty()) {
                        System.out.println(str.toString());
                        for (int i = 0; i < errors.getTail().getLocation() - 1; ++i) {
                            System.out.print(" ");
                        }
                        System.out.println('^');
                        System.out.println("ERROR in line " + lineCount + ". \'" +
                                errors.getTail().getFound() + "\' found, but \'" +
                                errors.getTail().getExpected() + "\' expected.\n");
                        errors.removeLast();
                        ok = false;
                    }
                    lineCount++;
                    erLoc = 0;
                    str = new StringBuilder();
                } else {
                    str.append((char) read);
                    erLoc++;
                    switch (read) {
                        case '(':
                        case '[':
                        case '{':
                            stack.push((char) read);
                            break;
                        case ')':
                            if (!stack.empty() && ((expected = stack.pop()) != '(')) {
                                errors.push(erLoc, (char) read, (char) (expected + 2));
                            }
                            break;
                        case ']':
                            if (!stack.empty() && ((expected = stack.pop()) != '[')) {
                                if (expected == '(') expected++;
                                else expected += 2;
                                errors.push(erLoc, (char) read, expected);
                            }
                            break;
                        case '}':
                            if (!stack.empty() && ((expected = stack.pop()) != '{')) {
                                if (expected == '(') expected++;
                                else expected += 2;
                                errors.push(erLoc, (char) read, expected);
                            }
                            break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!stack.empty()) {
            System.out.print("There are some open brackets left: ");
            while (!stack.empty()) {
                System.out.print(stack.removeLast() + ", ");
            }
        }
        else if (ok) System.out.println("OK");

    }

}
