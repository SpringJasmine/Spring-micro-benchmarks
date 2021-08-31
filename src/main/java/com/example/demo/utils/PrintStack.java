package com.example.demo.utils;


public class PrintStack {
    public static void printStack() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        for (int i = stack.length - 1; i >= 0; i--) {
            System.out.println(stack[i].getClassName()
                    + "." + stack[i].getMethodName()
                    + "(" + stack[i].getFileName() + ":" + stack[i].getLineNumber() + ")");
        }
    }


}
