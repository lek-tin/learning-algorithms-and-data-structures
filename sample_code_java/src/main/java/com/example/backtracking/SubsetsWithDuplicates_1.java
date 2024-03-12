import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time: O(N * 2^N), N denotes the number of nums
// Space: O(N * 2^N)
public class SubsetsWithoutDuplicates_1 {
    /**
     * @param nums: A set of numbers, with duplicates
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        
        Arrays.sort(nums);
        dfs(nums, 0, -1, new ArrayList<>(), subsets);
        
        return subsets;
    }
    
    private void dfs(int[] nums,
                     int startIndex,
                     int lastSelectedIndex,
                     List<Integer> subset,
                     List<List<Integer>> subsets) {
        if (startIndex == nums.length) {
            subsets.add(new ArrayList<Integer>(subset));
            return;
        }
        
        dfs(nums, startIndex + 1, lastSelectedIndex, subset, subsets);
        
        if (startIndex > 0 && nums[startIndex] == nums[startIndex - 1] && startIndex - 1 != lastSelectedIndex) {
            return;
        }
        
        subset.add(nums[index]);
        dfs(nums, startIndex + 1, startIndex, subset, subsets);
        subset.remove(subset.size() - 1);
    }
}