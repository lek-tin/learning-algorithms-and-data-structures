/**
Choosing k elements from a set of n elements is commonly known as generating combinations.

 */
import java.util.ArrayList;
import java.util.List;

public class ChooseKFromN {

    public static List<List<Integer>> chooseKFromN(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        generateCombinations(result, currentCombination, n, k, 1);
        return result;
    }

    /**
     * Time complexity: O(N! / (K!⋅(N−K)!))
     * Space complexity: O(K)
     * @param result
     * @param currentCombination
     * @param n
     * @param k
     * @param start
     */
    private static void generateCombinations(List<List<Integer>> result, List<Integer> currentCombination, int n, int k, int start) {
        if (k == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i <= n; i++) {
            // choose i'th number
            currentCombination.add(i);
            generateCombinations(result, currentCombination, n, k - 1, i + 1);
            // un-choose i'th number
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;

        List<List<Integer>> combinations = chooseKFromN(n, k);

        System.out.println("Combinations of choosing " + k + " from " + n + ":");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
