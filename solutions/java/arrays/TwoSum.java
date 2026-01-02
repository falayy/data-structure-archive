/**
 * Problem: Two Sum
 * Source: https://leetcode.com/problems/two-sum/
 * Difficulty: Easy
 * Category: Arrays, Hash Table
 *
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 *
 * Time Complexity: O(n) - Single pass through the array
 * Space Complexity: O(n) - Hash map stores up to n elements
 */

package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum {

    /**
     * Find two numbers in array that add up to target using hash map.
     *
     * Approach:
     * - Use hash map to store seen numbers and their indices
     * - For each number, calculate complement = target - current number
     * - Check if complement exists in hash map
     * - If yes, return current index and complement's index
     * - If no, add current number and index to hash map
     *
     * @param nums   Array of integers
     * @param target Target sum to find
     * @return Array containing two indices [i, j] where nums[i] + nums[j] == target
     */
    public int[] twoSum(int[] nums, int target) {
        // Hash map to store {value: index}
        Map<Integer, Integer> seen = new HashMap<>();

        // Iterate through array with index
        for (int i = 0; i < nums.length; i++) {
            // Calculate what number we need to reach target
            int complement = target - nums[i];

            // Check if we've seen the complement before
            if (seen.containsKey(complement)) {
                // Found the pair! Return indices
                return new int[] { seen.get(complement), i };
            }

            // Haven't found pair yet, store current number and index
            seen.put(nums[i], i);
        }

        // According to problem constraints, solution always exists
        // This should never be reached
        return new int[] {};
    }

    /**
     * Brute force approach using nested loops.
     *
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     *
     * @param nums   Array of integers
     * @param target Target sum
     * @return Array containing indices of the two numbers
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        int n = nums.length;

        // Check every possible pair
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // Start from i+1 to avoid same element
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] {};
    }

    /**
     * Main method with test cases.
     */
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Test cases: {input array, target, expected output}
        Object[][] testCases = {
                { new int[] { 2, 7, 11, 15 }, 9, new int[] { 0, 1 } },
                { new int[] { 3, 2, 4 }, 6, new int[] { 1, 2 } },
                { new int[] { 3, 3 }, 6, new int[] { 0, 1 } },
                { new int[] { -1, -2, -3, -4, -5 }, -8, new int[] { 2, 4 } },
                { new int[] { 0, 4, 3, 0 }, 0, new int[] { 0, 3 } }
        };

        System.out.println("Testing Two Sum Solutions:\n");

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = (int[]) testCases[i][0];
            int target = (int) testCases[i][1];
            int[] expected = (int[]) testCases[i][2];

            int[] result = solution.twoSum(nums, target);
            boolean passed = Arrays.equals(result, expected);
            String status = passed ? "✓" : "✗";

            System.out.println("Test Case " + (i + 1) + ": " + status);
            System.out.println("  Input: nums = " + Arrays.toString(nums) +
                    ", target = " + target);
            System.out.println("  Output: " + Arrays.toString(result));
            System.out.println("  Expected: " + Arrays.toString(expected));
            System.out.println();
        }

        // Performance comparison
        System.out.println("=" + "=".repeat(50));
        System.out.println("Performance Comparison:");
        System.out.println("=" + "=".repeat(50));

        int[] largeNums = new int[10000];
        for (int i = 0; i < largeNums.length; i++) {
            largeNums[i] = i;
        }
        int target = 19997;

        // Hash Map approach
        long startTime = System.nanoTime();
        solution.twoSum(largeNums, target);
        long hashTime = System.nanoTime() - startTime;

        // Brute Force approach
        startTime = System.nanoTime();
        solution.twoSumBruteForce(largeNums, target);
        long bruteTime = System.nanoTime() - startTime;

        System.out.printf("Hash Map Approach: %.6f seconds%n", hashTime / 1_000_000_000.0);
        System.out.printf("Brute Force Approach: %.6f seconds%n", bruteTime / 1_000_000_000.0);
        System.out.printf("Speedup: %.2fx faster%n", (double) bruteTime / hashTime);
    }
}
