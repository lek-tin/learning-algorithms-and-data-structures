package com.example.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Find all instances of the substring p within the string s
 * 
### Time Complexity:
- The time complexity is O(N * M), where N is the length of the main string `s`, and M is the length of the substring `p`.
- In the worst case, the method may need to iterate through each character in the main string `s`, and for each character, it checks for a substring match of length M using `indexOf`. The worst-case time complexity for a single `indexOf` operation is O(M).

### Space Complexity:
- The space complexity is O(K), where K is the number of occurrences of the substring in the main string.
- The `occurrences` list stores the indices of substring occurrences. In the worst case, if the substring appears at multiple positions, the list could contain K indices.

It's worth noting that the space complexity of the `indexOf` method itself is typically O(1), as it operates on the existing strings without requiring additional space proportional to the length of the strings. The space complexity of the algorithm is dominated by the `occurrences` list.

Keep in mind that these are worst-case complexities, and the actual performance may vary based on factors like the input data and the efficiency of the `indexOf` implementation.

 * 
 */
public class SubstringFinder {
    public static List<Integer> findAllOccurrences(String s, String p) {
        List<Integer> occurrences = new ArrayList<>();
        int index = s.indexOf(p);

        while (index != -1) {
            occurrences.add(index);
            index = s.indexOf(p, index + 1);
        }

        return occurrences;
    }

    public static List<Integer> findAllOccurrences2(String s, String p) {
        List<Integer> occurrences = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        for (int i = 0; i <= n - m; i++) {
            boolean found = true;

            for (int j = 0; j < m; j++) {
                if (s.charAt(i + j) != p.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                occurrences.add(i);
            }
        }

        return occurrences;
    }

    public static void main(String[] args) {
        String s = "abracadabra";
        String p = "ra";

        List<Integer> occurrences = findAllOccurrences(s, p);

        System.out.println("Occurrences of '" + p + "' in '" + s + "': " + occurrences);
    }
}
