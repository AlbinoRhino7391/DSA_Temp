package com.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryConvertTest {

    @Test
    public void testConvertFromBinary() {
        // Test case 1: Binary number "1010" should be equal to decimal 10
        String binary1 = "1010";
        int expectedDecimal1 = 10;
        int actualDecimal1 = BinaryConvert.convertFromBinary(binary1);
        assertEquals(expectedDecimal1, actualDecimal1);

        // Test case 2: Binary number "110010" should be equal to decimal 50
        String binary2 = "110010";
        int expectedDecimal2 = 50;
        int actualDecimal2 = BinaryConvert.convertFromBinary(binary2);
        assertEquals(expectedDecimal2, actualDecimal2);

        // Add more test cases as needed to cover different scenarios and edge cases.
    }

    @Test
    public void testConvertFromOctal() {
        // Test case 1: Octal number "34" should be equal to decimal 28
        String octal1 = "34";
        int expectedDecimal1 = 28;
        int actualDecimal1 = BinaryConvert.convertFromOctal(octal1);
        assertEquals(expectedDecimal1, actualDecimal1);

        // Test case 2: Octal number "777" should be equal to decimal 511
        String octal2 = "777";
        int expectedDecimal2 = 511;
        int actualDecimal2 = BinaryConvert.convertFromOctal(octal2);
        assertEquals(expectedDecimal2, actualDecimal2);

        // Add more test cases as needed to cover different scenarios and edge cases.
    }
}

