package com.example.permutation;

import java.util.ArrayList;
import java.util.List;

/**
Compute all permutations of a string.
 */
public class AllPermutationsOfString {
    public static List<String> getPermutations(String input) {
        List<String> permutations = new ArrayList<>();
        generatePermutations("", input, permutations);
        return permutations;
    }

    /**
     * N is the length of the input string 
     * Time complexity: O(N!)
     * Space Complexity: O(N)
     */
    private static void generatePermutations(String prefix, String remaining, List<String> permutations) {
        int length = remaining.length();
        if (length == 0) {
            permutations.add(prefix);
            return;
        }

        for (int i = 0; i < length; i++) {
            char currentChar = remaining.charAt(i);
            String newPrefix = prefix + currentChar;
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generatePermutations(newPrefix, newRemaining, permutations);
        }
    }

    private static void generatePermutationsStringBuilder(StringBuilder prefix, StringBuilder remaining, List<String> permutations) {
        int length = remaining.length();
        if (length == 0) {
            permutations.add(prefix.toString());
            return;
        }

        for (int i = 0; i < length; i++) {
            char currentChar = remaining.charAt(i);
            prefix.append(currentChar);
            remaining.deleteCharAt(i);
            
            generatePermutationsStringBuilder(prefix, remaining, permutations);

            prefix.deleteCharAt(prefix.length() - 1);
            remaining.insert(i, currentChar);
        }
    }

    public static void main(String[] args) {
        String input = "abc";
        List<String> permutations = getPermutations(input);

        System.out.println("Permutations of " + input + ":");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
