package com.drozda;

import java.math.BigInteger;
import java.util.stream.Collectors;

public class BigIntegerToStringConverter {
    public static String convertToPassword(BigInteger bigInteger){

        String s = bigInteger.toString(26);

        String result = s.chars().mapToObj(i -> (char) i)
                .map(BigIntegerToStringConverter::convert)
                .map(String::valueOf)
                .collect(Collectors.joining());
        return result;
    }

    public static char convert(char s){
        switch (s){
            case '1': return 'a';
            case '2': return 'b';
            case '3': return 'c';
            case '4': return 'd';
            case '5': return 'e';
            case '6': return 'f';
            case '7': return 'g';
            case '8': return 'h';
            case '9': return 'i';
            case '0': return 'j';
            case 'a': return 'k';
            case 'b': return 'l';
            case 'c': return 'm';
            case 'd': return 'n';
            case 'e': return 'o';
            case 'f': return 'p';
            case 'g': return 'q';
            case 'h': return 'r';
            case 'i': return 's';
            case 'j': return 't';
            case 'k': return 'u';
            case 'l': return 'v';
            case 'm': return 'w';
            case 'n': return 'x';
            case 'o': return 'y';
            case 'p': return 'z';
        }
        throw new RuntimeException("sdsadasdas");
    }
}
