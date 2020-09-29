package utils;

import java.util.Random;

public class Generators {

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // function to generate a random int of length n - used for unique email generations
    public static int randomIntegerGenerator(int upperBound) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(upperBound);
    }

    // function to generate a random alphaNumericString of length n
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    // function to generate a random string of length n
    public static String getAlphaString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
//                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

}
