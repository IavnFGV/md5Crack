package com.drozda;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;


@RunWith(Parameterized.class)
public class PasswordTest {
    @Parameterized.Parameters(name = "{index}: ({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new char[]{'a'}, "b"},
                {new char[]{'y'}, "z"},
                {new char[]{'z'}, "aa"},
                {new char[]{'a','a'}, "ab"},
                {new char[]{'a','z'}, "ba"},
                {new char[]{'z','z'}, "aaa"},
                {new char[]{'a','a','z'}, "aba"},
                {new char[]{'z','a','b'}, "zac"}
        });
    }


    char[] oldState;
    String newState;

    public PasswordTest(char[] oldState, String newState) {
        this.oldState = oldState;
        this.newState = newState;
    }

    @Test
    public void shouldReturnB() {
        Password password = new Password(oldState);
        Assert.assertEquals(newState, Password.inc(password).asString());
    }


}