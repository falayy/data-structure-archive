/*
Problem: Two Sum
Source: https://leetcode.com/problems/two-sum/
Difficulty: Easy
Category: Arrays, Hash Table

Given an array of integers nums and an integer target, return indices of the
two numbers such that they add up to target.

Time Complexity: O(n) - Single pass through the array
Space Complexity: O(n) - Hash map stores up to n elements
*/

package arrays

import (
	"fmt"
	"time"
)

// TwoSum finds two numbers in array that add up to target using hash map.
//
// Approach:
// - Use map to store seen numbers and their indices
// - For each number, calculate complement = target - current number
// - Check if complement exists in map
// - If yes, return current index and complement's index
// - If no, add current number and index to map
//
// Parameters:
//   - nums: Slice of integers
//   - target: Target sum to find
//
// Returns:
//   - Slice containing two indices [i, j] where nums[i] + nums[j] == target
func TwoSum(nums []int, target int) []int {
	// Map to store {value: index}
	seen := make(map[int]int)

	// Iterate through array with index
	for i, num := range nums {
		// Calculate what number we need to reach target
		complement := target - num

		// Check if we've seen the complement before
		if j, found := seen[complement]; found {
			// Found the pair! Return indices
			return []int{j, i}
		}

		// Haven't found pair yet, store current number and index
		seen[num] = i
	}

	// According to problem constraints, solution always exists
	// This should never be reached
	return []int{}
}

// TwoSumBruteForce is a brute force approach using nested loops.
//
// Time Complexity: O(n²)
// Space Complexity: O(1)
func TwoSumBruteForce(nums []int, target int) []int {
	n := len(nums)

	// Check every possible pair
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ { // Start from i+1 to avoid same element
			if nums[i]+nums[j] == target {
				return []int{i, j}
			}
		}
	}

	return []int{}
}

// TwoSumSorted uses two pointers approach for sorted array.
//
// Time Complexity: O(n log n) for sorting + O(n) for two pointers = O(n log n)
// Space Complexity: O(n) to store indices
//
// Note: This creates a copy to preserve original indices after sorting
func TwoSumSorted(nums []int, target int) []int {
	// Create slice of structs to track original indices
	type numWithIndex struct {
		value int
		index int
	}

	indexed := make([]numWithIndex, len(nums))
	for i, num := range nums {
		indexed[i] = numWithIndex{num, i}
	}

	// Sort by value (simple bubble sort for demonstration)
	for i := 0; i < len(indexed); i++ {
		for j := i + 1; j < len(indexed); j++ {
			if indexed[i].value > indexed[j].value {
				indexed[i], indexed[j] = indexed[j], indexed[i]
			}
		}
	}

	// Two pointers
	left, right := 0, len(indexed)-1

	for left < right {
		currentSum := indexed[left].value + indexed[right].value

		if currentSum == target {
			// Return original indices (sorted)
			result := []int{indexed[left].index, indexed[right].index}
			if result[0] > result[1] {
				result[0], result[1] = result[1], result[0]
			}
			return result
		} else if currentSum < target {
			left++
		} else {
			right--
		}
	}

	return []int{}
}

// Example usage and tests
func main() {
	// Test cases
	testCases := []struct {
		nums     []int
		target   int
		expected []int
	}{
		{[]int{2, 7, 11, 15}, 9, []int{0, 1}},
		{[]int{3, 2, 4}, 6, []int{1, 2}},
		{[]int{3, 3}, 6, []int{0, 1}},
		{[]int{-1, -2, -3, -4, -5}, -8, []int{2, 4}},
		{[]int{0, 4, 3, 0}, 0, []int{0, 3}},
	}

	fmt.Println("Testing Two Sum Solutions:\n")

	for i, tc := range testCases {
		result := TwoSum(tc.nums, tc.target)
		passed := len(result) == len(tc.expected) &&
			result[0] == tc.expected[0] &&
			result[1] == tc.expected[1]

		status := "✓"
		if !passed {
			status = "✗"
		}

		fmt.Printf("Test Case %d: %s\n", i+1, status)
		fmt.Printf("  Input: nums = %v, target = %d\n", tc.nums, tc.target)
		fmt.Printf("  Output: %v\n", result)
		fmt.Printf("  Expected: %v\n\n", tc.expected)
	}

	// Performance comparison
	fmt.Println("==================================================")
	fmt.Println("Performance Comparison:")
	fmt.Println("==================================================")

	largeNums := make([]int, 10000)
	for i := range largeNums {
		largeNums[i] = i
	}
	target := 19997

	// Hash Map approach
	start := time.Now()
	TwoSum(largeNums, target)
	hashTime := time.Since(start)

	// Brute Force approach
	start = time.Now()
	TwoSumBruteForce(largeNums, target)
	bruteTime := time.Since(start)

	fmt.Printf("Hash Map Approach: %v\n", hashTime)
	fmt.Printf("Brute Force Approach: %v\n", bruteTime)
	fmt.Printf("Speedup: %.2fx faster\n", float64(bruteTime)/float64(hashTime))
}
