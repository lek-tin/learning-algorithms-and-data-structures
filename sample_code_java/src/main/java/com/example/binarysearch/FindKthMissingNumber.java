package main.java.com.example.binarysearch;

public class MissingNumber {

    /**
     * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
        Return the kth positive integer that is missing from this array.
        
        Example 1:
        Input: arr = [2,3,4,7,11], k = 5
        Output: 9
        Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
        
        Example 2:
        Input: arr = [1,2,3,4], k = 2
        Output: 6
        Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
     */
    public static int findKthMissingPositivePoNumber(int[] nums, int k) {
        int left = 0, right = arr.length - 1;
        // 3 4 5 9 12 13 14
        // k = 3
        // 9 - 3 - 1 = 
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // If number of positive integers
            // which are missing before arr[mid]
            // is less than k -->
            // continue to search on the right.
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            // Otherwise, go left.
            } else {
                right = mid - 1;
            }
        }

        // At the end of the loop, left = right + 1,
        // and the kth missing is in-between arr[right] and arr[left].
        // The number of integers missing before arr[right] is
        // arr[right] - right - 1 -->
        // the number to return is
        // arr[right] + k - (arr[right] - right - 1) = k + left
        return left + k;
    }


    /**
     * given an array of sorted number numbers, find the kth missing number, starting from the leftmost number.
     * For example, the 2nd missing number for array [2,4,5,6,8 13] is 7.
     * Give me a binary search solution in java 
     */
    public static int findKthMissingNumber(int[] nums, int k) {
        // Sort the input array in ascending order
        Arrays.sort(nums);

        // Initialize left and right pointers for binary search
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // Calculate the middle index
            int mid = left + (right - left) / 2;

            // Calculate the number of missing elements before the middle element
            int missingBeforeMid = nums[mid] - (mid + nums[0]);

            if (missingBeforeMid < k) {
                // If missing elements before mid are less than k, search on the right side
                left = mid + 1;
            } else {
                // If missing elements before mid are greater than or equal to k, search on the left side
                right = mid;
            }
        }

        // Calculate the missing number based on the number of missing elements before left
        // nums[left - 1] represents the element at the left index before the current position
        // k - (nums[left - 1] - (left - 1 + nums[0])) represents the difference needed to find the kth missing number
        return nums[left - 1] + k - (nums[left - 1] - (left - 1 + nums[0]));
    }

    public static void main(String[] args) {
        int[] input = {2, 4, 5, 6, 8, 13};
        int k = 2;

        int result = findKthMissingNumber(input, k);
        System.out.println("The " + k + "th missing number is: " + result);
    }
}
