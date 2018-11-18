package com.drozda;

public class App {
    private static String MD5_TO_FIND =
            "4fd0101ea3d0f5abbe296ef97f47afec";// titkos
//    "69c459dd76c6198f72f0c20ddd3c9447";// zebra


    public static void main(String[] args) {
        System.out.println("Founded collision = " + MD5Cracker.crackPassword(MD5_TO_FIND));
    }
}
