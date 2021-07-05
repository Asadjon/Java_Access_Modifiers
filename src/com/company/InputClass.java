package com.company;

import java.util.Objects;
import java.util.Scanner;

class InputClass {

    private static final char minus = '-';
    private static final char point = '.';
    private static Scanner scanner = new Scanner(System.in);

    static <T> T input(Class<T> clazz){
        String text = scanner.next();
        T result = null;
        boolean isTrue;

        if (clazz == Integer.class){
            do {
                isTrue = false;
                for (int i = 0; i < text.length(); i++) {
                    if (!Character.isDigit(text.charAt(i)) && !Objects.equals(text.charAt(0), minus) || Objects.equals(text.charAt(i), point)) {
                        isTrue = true;
                        System.out.print("qaytadan kiriting: ");
                        text = scanner.next();
                        break;
                    }
                }
            } while (isTrue);
            result = (T) Integer.valueOf(text);
        }

        else if(clazz == Float.class){
            do {
                isTrue = false;
                int point = getPointIndex(text);
                for (int i = 0; i < text.length(); i++) {
                    if (!Character.isDigit(text.charAt(i == point ? ++i : i))
                            && !Objects.equals(text.charAt(0), '-'))  {
                        isTrue = true;
                        System.out.print("qaytadan kiriting: ");
                        text = scanner.next();
                        break;
                    }
                }
            } while (isTrue);
            result = (T) Float.valueOf(text);
        }

        else if(clazz == Double.class){
            do {
                isTrue = false;
                int point = getPointIndex(text);
                for (int i = 0; i < text.length(); i++) {
                    if (!Character.isDigit(text.charAt(i == point ? ++i : i))
                            && !Objects.equals(text.charAt(0), '-'))  {
                        isTrue = true;
                        System.out.print("qaytadan kiriting: ");
                        text = scanner.next();
                        break;
                    }
                }
            } while (isTrue);
            result = (T) Double.valueOf(text);
        }

        else if(clazz == String.class){
            result = (T) text;
        }

        else if(clazz == Character.class){
            do {
                isTrue = false;
                if (text.length() > 1){
                    isTrue = true;
                    System.out.print("qaytadan kiriting: ");
                    text = scanner.next();
                }
            } while (isTrue);
            result = (T) Character.valueOf(text.charAt(0));
        }

        else if(clazz == Boolean.class){
            do {
                isTrue = false;
                if (text.length() > 1 || !Character.isDigit(text.charAt(0)) || Integer.parseInt(text) > 1){
                    isTrue = true;
                    System.out.print("qaytadan kiriting: ");
                    text = scanner.next();
                }
            } while (isTrue);
            result = (T) new Boolean(Integer.parseInt(text) > 0);
        }

        return result;
    }

    private static int getPointIndex(String text){
        int point = -1;
        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) == 46 && (point < 0))
                point = i;
        return point;
    }
}
