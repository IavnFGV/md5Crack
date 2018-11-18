package com.drozda;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Password {

    private char[] chars;


    public char[] getChars() {
        return chars;
    }

    public static Password start() {
        return new Password(new char[]{'a'});
    }

    public Password(char[] chars) {
        this.chars = chars;
    }

    public static Password inc(Password from) {
        return new Password(inc(from.chars));
    }

    private static char[] inc(char[] chars) {
        return allElementsAreZ(chars) ? enlargeArray(chars) : incrementArray(chars);
    }

    private static char[] incrementArray(char[] chars) {
        char[] newChars = Arrays.copyOf(chars, chars.length);
        int indexOfCharToChange = findFirstNonZ(newChars);
        for (int i = indexOfCharToChange + 1; i < chars.length; i++) {
            newChars[i] = 'a';
        }
        newChars[indexOfCharToChange]++;
        return newChars;
    }

    private static char[] enlargeArray(char[] chars) {
        char[] newChars;
        newChars = new char[chars.length + 1];
        Arrays.fill(newChars, 'a');
        return newChars;
    }

    private static char inc(char charToInc) {
        return 0;
    }

    private static int findFirstNonZ(char[] newChars) {
        return reverseIndexesStream(newChars)
                .filter(isElementZ(newChars).negate())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("All elements are Z" + Arrays.toString(newChars)));
    }

    private static IntStream reverseIndexesStream(char[] newChars) {
        return IntStream.iterate(newChars.length - 1, operand -> operand - 1)
                .limit(newChars.length);
    }

    private static IntPredicate isElementZ(char[] newChars) {
        return i -> Objects.equals(newChars[i], 'z');
    }

    private static boolean allElementsAreZ(char[] chars) {
        return reverseIndexesStream(chars)
                .filter(isElementZ(chars))
                .count() == chars.length;
    }

    public String asString() {
        return String.valueOf(chars).trim();
    }
}
