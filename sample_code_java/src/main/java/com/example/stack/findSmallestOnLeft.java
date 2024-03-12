package main.java.com.example.stack;

import java.util.Stack;

/**
 * monotonic stack guestion. return the cloest smaller number from the left
 */
public class SmallestNumberOnLeft {
    public static int[] findSmallestOnLeft(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {3, 4, 2, 7, 4, 5};
        int[] output = findSmallestOnLeft(input);

        // Print the result
        for (int num : output) {
            System.out.print(num + " ");
        }
    }
}
