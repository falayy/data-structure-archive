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

/**
 * Find two numbers in array that add up to target using hash map.
 *
 * Approach:
 * - Use Map to store seen numbers and their indices
 * - For each number, calculate complement = target - current number
 * - Check if complement exists in map
 * - If yes, return current index and complement's index
 * - If no, add current number and index to map
 *
 * @param {number[]} nums - Array of integers
 * @param {number} target - Target sum to find
 * @return {number[]} - Array containing two indices [i, j] where nums[i] + nums[j] === target
 *
 * @example
 * twoSum([2, 7, 11, 15], 9) // returns [0, 1]
 * twoSum([3, 2, 4], 6)      // returns [1, 2]
 * twoSum([3, 3], 6)         // returns [0, 1]
 */
function twoSum(nums, target) {
    // Map to store {value: index}
    const seen = new Map();

    // Iterate through array with index
    for (let i = 0; i < nums.length; i++) {
        // Calculate what number we need to reach target
        const complement = target - nums[i];

        // Check if we've seen the complement before
        if (seen.has(complement)) {
            // Found the pair! Return indices
            return [seen.get(complement), i];
        }

        // Haven't found pair yet, store current number and index
        seen.set(nums[i], i);
    }

    // According to problem constraints, solution always exists
    // This should never be reached
    return [];
}

/**
 * Brute force approach using nested loops.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 *
 * @param {number[]} nums - Array of integers
 * @param {number} target - Target sum
 * @return {number[]} - Indices of the two numbers
 */
function twoSumBruteForce(nums, target) {
    const n = nums.length;

    // Check every possible pair
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) { // Start from i+1 to avoid same element
            if (nums[i] + nums[j] === target) {
                return [i, j];
            }
        }
    }

    return [];
}

/**
 * Two pointers approach for sorted array.
 *
 * Time Complexity: O(n log n) for sorting + O(n) for two pointers = O(n log n)
 * Space Complexity: O(n) to store indices
 *
 * @param {number[]} nums - Array of integers
 * @param {number} target - Target sum
 * @return {number[]} - Indices of the two numbers
 */
function twoSumSorted(nums, target) {
    // Create array of [value, originalIndex] pairs
    const indexedNums = nums.map((num, index) => [num, index]);

    // Sort by value
    indexedNums.sort((a, b) => a[0] - b[0]);

    // Two pointers
    let left = 0;
    let right = indexedNums.length - 1;

    while (left < right) {
        const currentSum = indexedNums[left][0] + indexedNums[right][0];

        if (currentSum === target) {
            // Return original indices (sorted)
            return [indexedNums[left][1], indexedNums[right][1]].sort((a, b) => a - b);
        } else if (currentSum < target) {
            left++;
        } else {
            right--;
        }
    }

    return [];
}

// Test cases
if (require.main === module) {
    const testCases = [
        [[2, 7, 11, 15], 9, [0, 1]],
        [[3, 2, 4], 6, [1, 2]],
        [[3, 3], 6, [0, 1]],
        [[-1, -2, -3, -4, -5], -8, [2, 4]],
        [[0, 4, 3, 0], 0, [0, 3]]
    ];

    console.log('Testing Two Sum Solutions:\n');

    testCases.forEach((testCase, index) => {
        const [nums, target, expected] = testCase;
        const result = twoSum(nums, target);
        const passed = JSON.stringify(result) === JSON.stringify(expected);
        const status = passed ? '✓' : '✗';

        console.log(`Test Case ${index + 1}: ${status}`);
        console.log(`  Input: nums = [${nums}], target = ${target}`);
        console.log(`  Output: [${result}]`);
        console.log(`  Expected: [${expected}]`);
        console.log();
    });

    // Performance comparison
    console.log('='.repeat(50));
    console.log('Performance Comparison:');
    console.log('='.repeat(50));

    const largeNums = Array.from({ length: 10000 }, (_, i) => i);
    const target = 19997;

    // Hash Map approach
    let startTime = performance.now();
    twoSum(largeNums, target);
    const hashTime = performance.now() - startTime;

    // Brute Force approach
    startTime = performance.now();
    twoSumBruteForce(largeNums, target);
    const bruteTime = performance.now() - startTime;

    console.log(`Hash Map Approach: ${hashTime.toFixed(6)} ms`);
    console.log(`Brute Force Approach: ${bruteTime.toFixed(6)} ms`);
    console.log(`Speedup: ${(bruteTime / hashTime).toFixed(2)}x faster`);
}

// Export for use in other modules
module.exports = { twoSum, twoSumBruteForce, twoSumSorted };
