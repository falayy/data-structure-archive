"""
Problem: Two Sum
Source: https://leetcode.com/problems/two-sum/
Difficulty: Easy
Category: Arrays, Hash Table

Given an array of integers nums and an integer target, return indices of the
two numbers such that they add up to target.

Time Complexity: O(n) - Single pass through the array
Space Complexity: O(n) - Hash map stores up to n elements
"""


def two_sum(nums: list[int], target: int) -> list[int]:
    """
    Find two numbers in array that add up to target using hash map.

    Approach:
    - Use hash map to store seen numbers and their indices
    - For each number, calculate complement = target - current number
    - Check if complement exists in hash map
    - If yes, return current index and complement's index
    - If no, add current number and index to hash map

    Args:
        nums: List of integers
        target: Target sum to find

    Returns:
        List containing two indices [i, j] where nums[i] + nums[j] == target

    Examples:
        >>> two_sum([2, 7, 11, 15], 9)
        [0, 1]
        >>> two_sum([3, 2, 4], 6)
        [1, 2]
        >>> two_sum([3, 3], 6)
        [0, 1]
    """
    # Hash map to store {value: index}
    seen = {}

    # Iterate through array with index
    for i, num in enumerate(nums):
        # Calculate what number we need to reach target
        complement = target - num

        # Check if we've seen the complement before
        if complement in seen:
            # Found the pair! Return indices
            return [seen[complement], i]

        # Haven't found pair yet, store current number and index
        seen[num] = i

    # According to problem constraints, solution always exists
    # This line should never be reached
    return []


# Alternative Approach: Brute Force
def two_sum_brute_force(nums: list[int], target: int) -> list[int]:
    """
    Brute force approach using nested loops.

    Time Complexity: O(n²)
    Space Complexity: O(1)

    Less efficient but simpler to understand.
    """
    n = len(nums)

    # Check every possible pair
    for i in range(n):
        for j in range(i + 1, n):  # Start from i+1 to avoid using same element
            if nums[i] + nums[j] == target:
                return [i, j]

    return []


# Alternative Approach: Two Pointers (requires sorted array)
def two_sum_sorted(nums: list[int], target: int) -> list[int]:
    """
    Two pointers approach for sorted array.

    Time Complexity: O(n log n) for sorting + O(n) for two pointers = O(n log n)
    Space Complexity: O(n) to store indices

    Note: This modifies the original approach since we need to track original indices
    after sorting.
    """
    # Create list of (value, original_index) pairs
    indexed_nums = [(num, i) for i, num in enumerate(nums)]

    # Sort by value
    indexed_nums.sort()

    # Two pointers
    left, right = 0, len(indexed_nums) - 1

    while left < right:
        current_sum = indexed_nums[left][0] + indexed_nums[right][0]

        if current_sum == target:
            # Return original indices
            return sorted([indexed_nums[left][1], indexed_nums[right][1]])
        elif current_sum < target:
            left += 1
        else:
            right -= 1

    return []


if __name__ == "__main__":
    # Test cases
    test_cases = [
        ([2, 7, 11, 15], 9, [0, 1]),
        ([3, 2, 4], 6, [1, 2]),
        ([3, 3], 6, [0, 1]),
        ([-1, -2, -3, -4, -5], -8, [2, 4]),
        ([0, 4, 3, 0], 0, [0, 3]),
    ]

    print("Testing Two Sum Solutions:\n")

    for i, (nums, target, expected) in enumerate(test_cases, 1):
        result = two_sum(nums, target)
        status = "✓" if result == expected else "✗"

        print(f"Test Case {i}: {status}")
        print(f"  Input: nums = {nums}, target = {target}")
        print(f"  Output: {result}")
        print(f"  Expected: {expected}")
        print()

    # Performance comparison
    print("\n" + "=" * 50)
    print("Performance Comparison:")
    print("=" * 50)

    large_nums = list(range(10000))
    target = 19997

    import time

    # Hash Map approach
    start = time.perf_counter()
    two_sum(large_nums, target)
    hash_time = time.perf_counter() - start

    # Brute Force approach
    start = time.perf_counter()
    two_sum_brute_force(large_nums, target)
    brute_time = time.perf_counter() - start

    print(f"Hash Map Approach: {hash_time:.6f} seconds")
    print(f"Brute Force Approach: {brute_time:.6f} seconds")
    print(f"Speedup: {brute_time / hash_time:.2f}x faster")
