package com.example.gueszybackend.util;

import java.util.concurrent.ThreadLocalRandom;

public class GueszyCode {
    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final String PREFIX = "GUESZY";

    public static String generate() {
        StringBuilder sb = new StringBuilder(PREFIX);
        while(sb.length() < 12) {
            sb.append(HEX_DIGITS[ThreadLocalRandom.current().nextInt(10)]);
        }
        return sb.toString();
    }
}
