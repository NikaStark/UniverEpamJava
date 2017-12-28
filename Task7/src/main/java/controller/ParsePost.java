package controller;

import model.StackX;

/**
 * @author Alex Volochai
 */
public class ParsePost {

    private StackX theStack;
    private String input;

    public ParsePost(String s) {
        input = s;
    }

    public double doParse() {
        theStack = new StackX(20);
        char ch;
        int j;
        double num1, num2, interAns;
        for (j = 0; j < input.length(); j++) {
            ch = input.charAt(j);
            theStack.displayStack("" + ch + " ");
            if (ch >= '0' && ch <= '9')
                theStack.push(ch - '0');
            else {
                if (ch == 's') {
                    num1 = theStack.pop();
                    interAns = Math.sin(num1);
                } else if (ch == 'c') {
                    num1 = theStack.pop();
                    interAns = Math.cos(num1);
                } else {
                    num2 = theStack.pop();
                    num1 = theStack.pop();
                    switch (ch) {
                        case '+':
                            interAns = num1 + num2;
                            break;
                        case '-':
                            interAns = num1 - num2;
                            break;
                        case '*':
                            interAns = num1 * num2;
                            break;
                        case '/':
                            interAns = num1 / num2;
                            break;
                        default:
                            interAns = 0;
                    }
                }
                theStack.push(interAns);
            }
        }
        interAns = theStack.pop();
        return interAns;
    }

}
