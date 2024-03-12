package example.binarysearch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BinarySearchFuzzyFindElement {
    /**
     * @param nums sorted array, may contains duplicates
     * @param target target number to find
     * @return the position of target, or the element that is closest to the target;
     */
    public int findExactOrClosestPosition(int[] nums, int target) {
        int closetPos = -1;
        if (nums.length <= 0){
            return closetPos;
        }

        int start = 0;
        int end = nums.length - 1;
        int minDiff = Integer.MAX_VALUE; // Initialize the minimum absolute difference

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int currentDiff = Math.abs(nums[mid] - target);
            
            // Update minDiff based on currentDiff
            if (currentDiff < minDiff) {
                closetPos = mid;
                minDiff = currentDiff;
            }

            // 3 scenarios
            if (nums[mid] == target) {
                return mid; // exact match found
            } else if (nums[mid] < target) {
                start = mid + 1; // this prevents infinite loop
            } else if (nums[mid] > target) {
                end = mid - 1; // this prevents infinite loop
            }
        }
        
        return closetPos;
    }

    /**
     * @param nums sorted array, may contains duplicates
     * @param target target number to find
     * @return the position of target, or the biggest element that is less than the target;
     */
    public int findExactOrBiggestLesserPosition(int[] nums, int target) {
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
                return mid; // exact match found
            } else if (nums[mid] < target) {
                pos = mid;
                start = mid + 1; // this prevents infinite loop
            } else if (nums[mid] > target) {
                end = mid - 1; // this prevents infinite loop
            }
        }
        
        return pos;
    }

    /**
     * @param nums sorted array, may contains duplicates
     * @param target target number to find
     * @return the position of target, or the smallest element that is greater than the target;
     */
    public int findExactOrSmallestGreaterPosition(int[] nums, int target) {
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
                return mid; // exact match found
            } else if (nums[mid] < target) {
                start = mid + 1; // this prevents infinite loop
            } else if (nums[mid] > target) {
                pos = mid;
                end = mid - 1; // this prevents infinite loop
            }
        }
        
        return pos;
    }

    /**
     * Test cases:
     * piles = [3,6,7,11], h = 8 => 4
     * piles = [30,11,23,4,20], h = 5 => 30
     * piles = [30,11,23,4,20], h = 6 => 23
     * piles = [805306368,805306368,805306368], h = 1000000000 => 3
     */
}