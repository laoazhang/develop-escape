package com.java.escape;

/**
 * Java 异常处理
 */
public class ExceptionProcess {

    private static class User {
    }

    /**
     * Java 异常本质 -- 抛出异常
     */
    private void throwException() {
        User user = null;
        // ...
        if (user == null) {
            throw new NullPointerException();
        }
    }

    private void canNotCatchNpeException() {
        try {
            throwException();
        } catch (ClassCastException cce) {
            System.out.println(cce.getMessage());
            System.out.println(cce.getClass().getName());
        }
    }

    /**
     * 能够捕获空指针异常
     */
    private void canCatchNpeException() {
        try {
            throwException();
        } catch (ClassCastException cce) {
            System.out.println(cce.getMessage());
            System.out.println(cce.getClass().getName());
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
            System.out.println(npe.getClass().getName());
        }
    }

    public static void main(String[] args) {
        ExceptionProcess process = new ExceptionProcess();

        process.canCatchNpeException();
        process.canNotCatchNpeException();
    }
}
