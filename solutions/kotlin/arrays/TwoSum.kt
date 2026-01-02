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

package arrays

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
 * @param nums Array of integers
 * @param target Target sum to find
 * @return IntArray containing two indices [i, j] where nums[i] + nums[j] == target
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    // Hash map to store {value: index}
    val seen = mutableMapOf<Int, Int>()

    // Iterate through array with index
    nums.forEachIndexed { index, num ->
        // Calculate what number we need to reach target
        val complement = target - num

        // Check if we've seen the complement before
        seen[complement]?.let {
            // Found the pair! Return indices
            return intArrayOf(it, index)
        }

        // Haven't found pair yet, store current number and index
        seen[num] = index
    }

    // According to problem constraints, solution always exists
    // This should never be reached
    return intArrayOf()
}

/**
 * Brute force approach using nested loops.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 *
 * @param nums Array of integers
 * @param target Target sum
 * @return IntArray containing indices of the two numbers
 */
fun twoSumBruteForce(nums: IntArray, target: Int): IntArray {
    val n = nums.size

    // Check every possible pair
    for (i in 0 until n) {
        for (j in i + 1 until n) { // Start from i+1 to avoid same element
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }

    return intArrayOf()
}

/**
 * Two pointers approach for sorted array.
 *
 * Time Complexity: O(n log n) for sorting + O(n) for two pointers = O(n log n)
 * Space Complexity: O(n) to store indices
 *
 * @param nums Array of integers
 * @param target Target sum
 * @return IntArray containing indices of the two numbers
 */
fun twoSumSorted(nums: IntArray, target: Int): IntArray {
    // Create list of Pair(value, originalIndex)
    val indexedNums = nums.mapIndexed { index, num -> num to index }

    // Sort by value
    val sortedNums = indexedNums.sortedBy { it.first }

    // Two pointers
    var left = 0
    var right = sortedNums.size - 1

    while (left < right) {
        val currentSum = sortedNums[left].first + sortedNums[right].first

        when {
            currentSum == target -> {
                // Return original indices (sorted)
                val indices = intArrayOf(sortedNums[left].second, sortedNums[right].second)
                indices.sort()
                return indices
            }
            currentSum < target -> left++
            else -> right--
        }
    }

    return intArrayOf()
}

/**
 * Main function with test cases.
 */
fun main() {
    // Test cases
    val testCases = listOf(
        Triple(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1)),
        Triple(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2)),
        Triple(intArrayOf(3, 3), 6, intArrayOf(0, 1)),
        Triple(intArrayOf(-1, -2, -3, -4, -5), -8, intArrayOf(2, 4)),
        Triple(intArrayOf(0, 4, 3, 0), 0, intArrayOf(0, 3))
    )

    println("Testing Two Sum Solutions:\n")

    testCases.forEachIndexed { index, (nums, target, expected) ->
        val result = twoSum(nums, target)
        val passed = result.contentEquals(expected)
        val status = if (passed) "✓" else "✗"

        println("Test Case ${index + 1}: $status")
        println("  Input: nums = ${nums.contentToString()}, target = $target")
        println("  Output: ${result.contentToString()}")
        println("  Expected: ${expected.contentToString()}")
        println()
    }

    // Performance comparison
    println("=".repeat(50))
    println("Performance Comparison:")
    println("=".repeat(50))

    val largeNums = IntArray(10000) { it }
    val target = 19997

    // Hash Map approach
    var startTime = System.nanoTime()
    twoSum(largeNums, target)
    val hashTime = System.nanoTime() - startTime

    // Brute Force approach
    startTime = System.nanoTime()
    twoSumBruteForce(largeNums, target)
    val bruteTime = System.nanoTime() - startTime

    println("Hash Map Approach: ${hashTime / 1_000_000_000.0} seconds")
    println("Brute Force Approach: ${bruteTime / 1_000_000_000.0} seconds")
    println("Speedup: ${"%.2f".format(bruteTime.toDouble() / hashTime)}x faster")
}
