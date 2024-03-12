package example.binarysearch;

public class BinarySearchFindExactElement {
    /**
     * @param nums sorted array, unique numbers
     * @param target target number to find
     * @return the position of targer, -1 if target doesn't exist in nums
     */
    public int findPosition(int[] nums, int target) {
        if (nums.length <= 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            // 3 scenarios
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            }
        }

        // result
        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }
        
        return -1;
    }
}
