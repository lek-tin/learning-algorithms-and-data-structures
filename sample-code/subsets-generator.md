# Subsets Generator

## Subsets (unique elements)

```java
import java.util.ArrayList;
import java.util.List;

public class SubsetGenerator {

    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void dfs(int[] nums, int start, List<Integer> current subset, List<List<Integer>> subsets) {
        // Add the current subset to the result
        subsets.add(new ArrayList<>(currentSubset));

        // Explore all possible subsets by including or excluding the current element
        for (int i = start; i < nums.length; i++) {
            // Include the current element in the subset
            currentSubset.add(nums[i]);

            // Recursively generate subsets starting from the next index
            dfs(nums, i + 1, currentSubset, subsets);

            // Exclude the current element to backtrack and explore other possibilities
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(nums);

        System.out.println("All subsets of the array:");

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
```
