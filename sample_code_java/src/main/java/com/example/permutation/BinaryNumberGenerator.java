package com.example.permutation;

import java.util.ArrayList;
import java.util.List;

public class BinaryNumberGenerator {

    public static List<String> generateBinaryNumbers(int N) {
        List<String> binaryNumbers = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            StringBuilder binary = new StringBuilder();
            int num = i;

            while (num > 0) {
                int bit = num % 2;
                binary.insert(0, bit);
                num /= 2;
            }

            binaryNumbers.add(binary.toString());
        }

        return binaryNumbers;
    }

    public static void main(String[] args) {
        int N = 10; // Set N to the desired range

        List<String> binaryNumbers = generateBinaryNumbers(N);

        System.out.println("Binary Numbers from 1 to " + N + ":");
        for (String binary : binaryNumbers) {
            System.out.println(binary);
        }
    }
}
