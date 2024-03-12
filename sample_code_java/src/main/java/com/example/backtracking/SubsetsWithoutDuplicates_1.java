import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 使用组合类搜索的专用深度优先搜索算法。 一层一层的决策每个数要不要放到最后的集合里。
// Time: O(N * 2^N), N denotes the number of nums
// Space: O(N * 2^N)
public class SubsetsWithoutDuplicates_1 {
    /**
     * @param nums: A set of unique numbers, 
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    
    // 1. 递归的定义
    // 以 subset 开头的，配上 nums 以 index 开始的数所有组合放到 results 里
    private void dfs(int[] nums,
                     int index,
                     List<Integer> subset,
                     List<List<Integer>> results) {
        // 3. 递归的出口
        if (index == nums.length) {
            results.add(new ArrayList<Integer>(subset));
            return;
        }
        
        // 2. 递归的拆解
        // (如何进入下一层)
        
        // 选了 nums[index]
        subset.add(nums[index]);
        dfs(nums, index + 1, subset, results);
        
        // 不选 nums[index]
        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, subset, results);
    }
}