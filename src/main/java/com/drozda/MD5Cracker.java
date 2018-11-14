package com.drozda;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class MD5Cracker {

    public static String crackPassword(String md5Tofind) {
        long start = System.currentTimeMillis();

        String found = Stream.iterate(BigInteger.ZERO, bigInteger -> bigInteger.add(BigInteger.ONE))
                .parallel()
                .map(BigIntegerToStringConverter::convertToPassword)
                .filter(s -> filter(s, md5Tofind))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Collision was not found"));
        long stop = System.currentTimeMillis();

        System.out.println((stop - start) + " msec");

        return found;
    }

    private static boolean filter(String password, String md5ToFind) {
        return md5ToFind.equals(hash(password));
    }

    public static String hash(String toHash) {
        Hasher hasher = Hashing.md5().newHasher();
        hasher.putString(toHash, StandardCharsets.UTF_8);
        return hasher.hash().toString();
    }
}
