package example.binarysearch;

public class BinarySearchFindFirstExactElement {
    /**
     * @param nums sorted array, may contains duplicates
     * @param target target number to find
     * @return first position of target, -1 if target doesn't exist in nums
     */
    public int findPosition1(int[] nums, int target) {
        int pos = -1;
        if (nums.length <= 0){
            return pos;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            // 3 scenarios
            if (nums[mid] == target) {
                pos = mid; // save result, but continue searching
                end = mid - 1; // this prevents infinite loop
            } else if (nums[mid] < target) {
                start = mid + 1; // this prevents infinite loop
            } else if (nums[mid] > target) {
                end = mid - 1; // this prevents infinite loop
            }
        }
        
        return pos;
    }

    public int findPosition2(int[] nums, int target) {
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

        // start needs to be checked first, because we wanted first element.
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        
        return -1;
    }
}

/**
 * Test cases
 * nums = [1,1], target = 1
 * 
 */