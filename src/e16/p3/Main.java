package e16.p3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

    private static void  operate(String s, RPNStack stack) {

        for (String m : s.split(" ")) {
            char[] arr = m.toCharArray();

            if (arr[0] == '+') {
                stack.push(stack.pop() + stack.pop());
            } else if (arr[0] == '*') {
                stack.push(stack.pop() * stack.pop());
            } else if (arr[0] == '-') {
                double pop1 = stack.pop();
                double pop2 = stack.pop();
                stack.push(pop2 - pop1);
            } else if (arr[0] == '/') {
                double pop1 = stack.pop();
                double pop2 = stack.pop();
                stack.push(pop2 / pop1);
            } else {
                int al = arr.length;
                double val = 0;
                for (int i = 0; i < al; ++i) {
                    val += Math.pow(10, i) * (arr[al - 1 - i] - '0');
                }
                stack.push(val);
            }
        }

        System.out.println(s + " = " + stack.pop());
        if(!stack.empty()) {
            System.out.println("The stack is not empty.");
            stack.clearStack();
            System.out.println("The stack has been cleared.");
        }

    }

    public static void main (String[] args) throws Exception {

        RPNStack stack = new RPNStack();

        File file = new File("data/e16p3.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null)
            operate(st, stack);

    }

}
