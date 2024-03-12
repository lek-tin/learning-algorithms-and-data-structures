
import java.util.*;

public class WordsPermutationDup {

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "apple"};
        List<List<String>> permutations = permute(words);
        
        for (List<String> permutation : permutations) {
            System.out.println(permutation);
        }
    }

    /**
     * Time complexity: O(N!), N denotes the number of words
     * Space complexity: O(N)
     * @param words input words, containing duplicates
     * @return
    */
    public static List<List<String>> permute(String[] words) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> wordCount = new HashMap<>();
        
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        permuteHelper(words, wordCount, new ArrayList<>(), result);
        return result;
    }

    private static void permuteHelper(String[] words, Map<String, Integer> wordCount,
                                      List<String> currentPermutation, List<List<String>> result) {
        if (currentPermutation.size() == words.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (count > 0) {
                currentPermutation.add(word);
                wordCount.put(word, count - 1);

                permuteHelper(words, wordCount, currentPermutation, result);

                currentPermutation.remove(currentPermutation.size() - 1);
                wordCount.put(word, count);
            }
        }
    }
}
