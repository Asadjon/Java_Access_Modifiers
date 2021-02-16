package com.company;

import java.util.Objects;
import java.util.Scanner;

class InputClass {


    public enum TypeVariable { Int, Float, Double, String, Char, Bool }
    private static final char minus = '-';
    private static final char point = '.';

    static Object input(TypeVariable typeVariable){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        boolean isTrue;
        switch (typeVariable){
            case Int: {
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
                return Integer.valueOf(text);
            }

            case Float: {
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
                return Float.valueOf(text);
            }

            case Double: {
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
                return Double.valueOf(text);
            }

            case String: { return text; }

            case Char:{
                do {
                    isTrue = false;
                    if (text.length() > 1){
                        isTrue = true;
                        System.out.print("qaytadan kiriting: ");
                        text = scanner.next();
                    }
                } while (isTrue);
                return text.charAt(0);
            }

            case Bool: {
                do {
                    isTrue = false;
                    if (text.length() > 1 || !Character.isDigit(text.charAt(0)) || Integer.parseInt(text) > 1){
                        isTrue = true;
                        System.out.print("qaytadan kiriting: ");
                        text = scanner.next();
                    }
                } while (isTrue);
                return Integer.parseInt(text) > 0;
            }

            default: return null;
        }
    }

    private static int getPointIndex(String text){
        int point = -1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 46 && (point < 0)){
                point = i;
            }
        }
        return point;
    }
}
