package com.yunjin.lec7;

import org.jetbrains.annotations.NotNull;

public class JavaException {

    private int parseIntOrThrow(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("주어진 %s는 숫자가 아닙니다."));
        }
    }

    public static void main(String[] args) {
        JavaException javaException = new JavaException();
        int result = javaException.parseIntOrThrow("3");
        int exceptionResult = javaException.parseIntOrThrow("a");

        System.out.println(result);
    }

}


