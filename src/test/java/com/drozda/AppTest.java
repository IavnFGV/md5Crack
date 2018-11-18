package com.drozda;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
@RunWith(Parameterized.class)
public class AppTest {
    @Parameterized.Parameters(name = "{index}: ({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"69c459dd76c6198f72f0c20ddd3c9447", "zebqz", "zebra"},
                {"4fd0101ea3d0f5abbe296ef97f47afec", "titkaa", "titkos"}
        });
    }

    String md5ToCrack;
    String passwordToStart;
    String correctPassword;

    public AppTest(String md5ToCrack, String passwordToStart, String correctPassword) {
        this.md5ToCrack = md5ToCrack;
        this.passwordToStart = passwordToStart;
        this.correctPassword = correctPassword;
    }

    @Test
    public void test() {
        Assert.assertEquals(correctPassword, MD5Cracker.crackPassword(md5ToCrack, new Password(passwordToStart.toCharArray())));
    }
}
