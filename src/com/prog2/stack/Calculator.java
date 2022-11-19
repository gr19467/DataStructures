package com.prog2.stack;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.nio.charset.StandardCharsets;

public class Calculator extends GraphicsProgram {

    private GLabel display = new GLabel("");

    @Override
    public void init(){


        // 1 2 3 +
        // 4 5 6 -
        // 7 8 9 *
        // ( 0 ) /
        // C < = .


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new acm.gui.TableLayout(5, 4));

        String[] labels = { "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "*",
                "(", "0", ")", "/",
                "C", "<", "=", "." };

        for (int i = 0; i < 20; i++) {
            JButton button = new JButton(labels[i]);
            buttonPanel.add(button);
        }

        add(buttonPanel, CENTER);

        addActionListeners();

        display.setFont("Times-bold-24");
        add(display,0,18);
    }

    public void actionPerformed(ActionEvent ae){
        switch(ae.getActionCommand()){

            case "=": //cause an evaluation

                System.out.flush();

                int response = evaluate(display.getLabel());

                display.setLabel("" + response);

                StringBuilder ops = new StringBuilder();
                ops.append(response);

                String output = ops.toString();
                display.setLabel(output);

                break;

            case "C": //clear the display

                display.setLabel("");
                break;

            case "<": //delete a single character from the display IF a character exists to be deleted

                if(display.getLabel().length() > 0){
                    StringBuilder sb = new StringBuilder(display.getLabel());
                    sb = sb.deleteCharAt(display.getLabel().length() - 1);
                    display.setLabel(sb.toString());
                }

                break;

            default:
                display.setLabel(display.getLabel() + ae.getActionCommand());
        }

    }

    private int evaluate(String input){
        int strlen = input.length();

        //number stack: the operands of your math
        Stack<Integer> ns = new Stack<>();

        //operator stack: the operators of your math
        Stack<Character> op = new Stack<>();

        int i = 0; //an iteration marker for the first while loop
        char ch;

        StringBuffer s;

        if(!input.isEmpty()){ //ensure there is actually some input to process

            postMessage("Beginning evaluation...", 100);

            //loop across the input String
            while(i <= strlen - 1) {

                //store the character found at a given point(i)
                
                //skip over blank spaces (this shouldn't happen)

                //Processing the input String should take the following steps:

                    /*
                    1) Check for numbers. Question to ask yourself: how do I handle multi-digit numbers?
                        ch <= '9' && ch >= '0'
                        */

                //  2) Check for a ( which indicates the start of a block which must be evaluated before all others

                //  3) Check for a ) which indicates the end of a block that must be evaluated before all others

                    /*
                        4) Check for any non-parenthesis operator, and determine if it has a higher precedence than the
                       operator that is currently on the top of the op stack. When we find an op that has precedence
                       ('*' or '/' vs '+' or '-') we should calculate the result of the current operator immediately,
                       and push the result onto the number stack.
                    */

                    /*
                        5) As the primary loop reaches the end of an iteration, don't forget to increment
                    */

                postMessage("Searching for symbols...");
            }

        }else{
            return 0;
        }

    }

    private boolean precedence(char peek, char ch){
        if((peek == '*' || peek == '/') && (ch == '+' || ch == '-')){
            return true;
        }

        if(peek != ch && peek != '('){
            return true;
        }

        return false;
    }

    private int calculate(char op, int a, int b){
        if(op == '*'){
            return a * b;
        }

        if(op == '/'){
            return a / b;
        }

        if(op == '+'){
            return a + b;
        }

        if(op == '-'){
            return a - b;
        }

        return 0;
    }

    private void postMessage(String s, int time){
        System.out.println(s);
        pause(time);
    }

    private void postMessage(String s){
        System.out.println(s);
        pause(250);
    }

}
