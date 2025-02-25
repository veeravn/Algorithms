package com.vnaidu;

import java.util.Stack;

public class ReverseNotation extends Base {

    public int evalRPN(String[] tokens) {
        int num1 = 0, num2 = 0;
        int total = 0;
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    num2 = st.pop();
                    num1 = st.pop();
                    st.push(num1 + num2);
                    break;
                case "-":
                    num2 = st.pop();
                    num1 = st.pop();
                    st.push(num1 - num2);
                    break;
                case "*":
                    num2 = st.pop();
                    num1 = st.pop();
                    st.push(num1 * num2);
                    break;
                case "/":
                    num2 = st.pop();
                    num1 = st.pop();
                    st.push(num1 / num2);
                    break;
                default:
                    st.push(Integer.parseInt(token));
                    break;
            }
        }
        return st.pop();
    }
}
