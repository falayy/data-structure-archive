
"""
Problem: Longest Common Prefix
Source: https://leetcode.com/problems/longest-common-prefix/
Difficulty: Easy
Category: Arrays

Given an array of strings strs, find the longest common prefix string amongst them.
If there is no common prefix, return an empty string "".

Time Complexity: O(n) - Single pass through the list of strings
Space Complexity: O(1) - No extra space used
"""


def longest_common_prefix(strs: list[str]) -> str:

    """
    Use a pointer to track the character position in the strings.

    Approach:
    - set the first string as longest common prefix
    - iterate through each string in the list
    - compare each character of the current string with the longest common prefix
    - if characters match, continue to next character
    - if characters do not match, update the longest common prefix to the matched portion
    - return the longest common prefix after checking all strings

    Args:
        strs: List of strings
    Returns:
        Longest common prefix string

    Examples:
    >>> longestCommonPrefix(["flower", "flow", "flight"])
    "fl"
    >>> longestCommonPrefix(["dog", "racecar", "car"])
    ""
    """

    i = 0
    pointer = 0
    result = ""

    result = strs[0]
    while i < len(strs):
        for index, char in enumerate(strs[i]):
            if (index >= len(result)) or (char != result[index]):
                break
            if char == result[index]:
                pointer = pointer + 1
        result = strs[i][0:pointer]

        pointer = 0
        i = i + 1

    return result


"""
Time Complexity: O(m*n) - where m is the length of the first string in the list and n is the number of strings
Space Complexity: O(1) - No extra space used
"""

def longest_common_prefix_brute_force(strs: list[str]) -> str:

    """
    Brute Force

    Approach:
    - set the first string as longest common prefix
    - iterate through each string in the list
    - compare each character of the current string with the longest common prefix
    - if characters match, continue to next character
    - if characters do not match, return the matched portion
    - return the longest common prefix after checking all strings

    Args:
    strs: List of strings
    Returns:
    Longest common prefix string

    """    

    index = 0
    result = ""
    counter = 0

    for i, char in enumerate(strs[index]):
        for value in strs:
            if i < len(value):
                if char == value[i]:
                    counter = counter + 1

        if counter == len(strs):
            result += char
            counter = 0
        else:
            return result

    return result


if __name__ == "__main__":
    # Test cases
    test_cases = [
        (["flower","flow","flight"], "fl"),
        (["dog","racecar","car"], ""),
    ]

print("Testing Longest Common Prefix Solutions:\n")

for i, (strs, expected) in enumerate(test_cases, 1):
    result = longest_common_prefix(strs)
    status = "✓" if result == expected else "✗"

    print(f"Test Case {i}: {status}")
    print(f"  Input: strs = {strs}")
    print(f"  Output: {result}")
    print(f"  Expected: {expected}")
    print()
    # Performance comparison
    print("\n" + "=" * 50)
    print("Performance Comparison:")
    print("=" * 50) 
    large_strs = ["flower"] * 1000 + ["flow"] * 1000 + ["flight"] * 1000   
    
    
    import time
    # Optimal approach
    start = time.perf_counter()
    longest_common_prefix(large_strs)
    optimal_time = time.perf_counter() - start

    # Brute Force approach
    start = time.perf_counter()
    longest_common_prefix_brute_force(large_strs)
    brute_time = time.perf_counter() - start

    print(f"Optimal Approach: {optimal_time:.6f} seconds")
    print(f"Brute Force Approach: {brute_time:.6f} seconds")
    print(f"Speedup: {brute_time / optimal_time:.2f}x faster")