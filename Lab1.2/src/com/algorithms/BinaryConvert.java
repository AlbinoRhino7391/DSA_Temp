package com.algorithms;

public class BinaryConvert {

    public static void main(String[] args) {
        int value = convertFromBinary("100101");
        System.out.println("Decimal value of binary 100101 = " + value);
        // TODO-Lab1.2: Uncomment first 2 and/or last 2 lines of the following, for a simple check
        //  of octal or hexadecimal conversion.
        value = convertFromOctal("17");
        System.out.println("Decimal value of octal 17 = " + value);
        value = convertFromHexadecimal("2A");
        System.out.println("Decimal value of hexadecimal 2A = " + value);
    }

    public static int convertFromBinary(String binary) {
        int result = 0;
        int positionValue = 1;
        char[] digits = binary.toCharArray();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                result += positionValue;
            }
            positionValue *= 2;
        }
        return result;
    }

    public static int convertFromOctal(String octal) {
        // TODO-Lab1.2: Complete this method, to return calculated decimal value converted from
        //  octal String, or the following.
        // initialize decimal to 0.
        int decimal = 0;
        int l = octal.length() -1 ;
        // reverse the order of the octal string, ie right to left
        for (int i = l; i >= 0; i--) {
            //for each character in the string:
            //convert the character to its numeric value
            char octalChar = octal.charAt(i);

            if (octalChar >= '0' && octalChar <= '7') {
                int digitValue = octalChar - '0';
                //increment power
                int power = l - i;
                //multiply the numeric value by 8 raised to the power
                //add the results to the decimal variable
                decimal += digitValue * Math.pow(8, power);
            }
        }
        // return decimal
        return decimal;
    }

    public static int convertFromHexadecimal(String hexadecimal) {
        // Initialize a variable to store the calculated decimal value
        int decimal = 0;

        // Convert the hexadecimal string to uppercase (optional, for consistency)
        hexadecimal = hexadecimal.toUpperCase();

        // Define a mapping for hexadecimal characters to their corresponding decimal values
        // For example, 'A' corresponds to 10 in decimal, 'B' to 11, and so on.
        // We will use this mapping to convert each character to its decimal equivalent.
        String hexCharacters = "0123456789ABCDEF";

        // Start the conversion process by iterating over each character in the hexadecimal string
        for (int i = 0; i < hexadecimal.length(); i++) {
            // Get the current character from the string
            char ch = hexadecimal.charAt(i);

            // Find the decimal equivalent of the current character by looking it up in the hexCharacters mapping
            int decimalValue = hexCharacters.indexOf(ch);

            // If the character is not found in the mapping, it might be an invalid hexadecimal digit
            // You can add error handling here if you want to handle such cases.

            // Multiply the current decimal value by 16 raised to the power of its position in the string.
            // For example, the rightmost digit has a position of 0, the next one to the left has a position of 1, and so on.
            decimal += decimalValue * Math.pow(16, hexadecimal.length() - i - 1);
        }

        // After the loop, the 'decimal' variable will contain the calculated decimal value.
        // Return this value as the result of the conversion.
        return decimal;
    }


}
