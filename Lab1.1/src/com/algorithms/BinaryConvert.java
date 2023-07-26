package com.algorithms;

public class BinaryConvert {

    public static void main(String[] args) {
        int number = convertFromBinary("10100101");
        System.out.println("Number for binary 10100101: " + number);
    }

    public static int convertFromBinary(String binary) {
        // TODO-Lab1.1: return calculated decimal value converted from String binary
        //Initialize a variable decimal to 0.
        int decimal = 0;
        int l = binary.length();
        //Iterate through the binary string from right to left (from the least significant bit to the most significant bit).
        //For each bit in the binary string:
        for (int i = l -1; i >= 0; i--){
            char bit = binary.charAt(i);
            //a. If the bit is '1', add 2 raised to the power of the current position (0-based index) to the decimal variable.
            if ( bit == '1') {
                int power = l - 1 - i;
                System.out.println("this is the bit "+ bit);
                System.out.println("this is the power "+power);
                decimal += Math.pow(2,power);
            }
            //b. If the bit is '0', continue to the next bit without making any changes to decimal.
            //After iterating through all the bits, the decimal variable will hold the converted decimal value.
        }
        // Return the decimal value.
        return decimal;
    }
}
