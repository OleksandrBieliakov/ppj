package e16.p3;

import java.util.Arrays;

public class MainUsingArgs {

    private static void operate(String[] args, RPNStack stack) {

        for (String arg : args) {

            switch (arg) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-": {
                    double pop1 = stack.pop();
                    double pop2 = stack.pop();
                    stack.push(pop1 - pop2);
                    break;
                }
                case "/": {
                    double pop1 = stack.pop();
                    double pop2 = stack.pop();
                    stack.push(pop1 / pop2);
                    break;
                }
                default:
                    double val = Double.parseDouble(arg);
                    stack.push(val);
                    break;
            }
        }

        System.out.println(Arrays.toString(args) + " = " + stack.pop());
        if (!stack.empty()) {
            System.out.println("The stack is not empty.");
            stack.clearStack();
            System.out.println("The stack has been cleared.");
        }

    }

    //provide command line arguments
    //e.g. 2 7 5 + * 20 - 1 4 / /
    public static void main(String[] args) throws Exception {

        RPNStack stack = new RPNStack();

        operate(args, stack);

    }

}
