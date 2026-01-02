# Two Sum

**Source**: [LeetCode #1](https://leetcode.com/problems/two-sum/)
**Difficulty**: 🟢 Easy

---

## 📝 Problem Description

Given an array of integers `nums` and an integer `target`, return **indices of the two numbers** such that they add up to `target`.

You may assume that each input would have **exactly one solution**, and you may **not use the same element twice**.

You can return the answer in any order.

---

## 💡 Examples

### Example 1

**Input**:
```
nums = [2, 7, 11, 15]
target = 9
```

**Output**:
```
[0, 1]
```

**Explanation**:
```
Because nums[0] + nums[1] == 9, we return [0, 1].
2 + 7 = 9, so the indices are 0 and 1.
```

---

### Example 2

**Input**:
```
nums = [3, 2, 4]
target = 6
```

**Output**:
```
[1, 2]
```

**Explanation**:
```
Because nums[1] + nums[2] == 6, we return [1, 2].
2 + 4 = 6, so the indices are 1 and 2.
```

---

### Example 3 (Edge Case)

**Input**:
```
nums = [3, 3]
target = 6
```

**Output**:
```
[0, 1]
```

**Explanation**:
```
Both elements are the same value (3), and 3 + 3 = 6.
We use different indices: 0 and 1.
```

---

## 🔒 Constraints

- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- **Only one valid answer exists**

**Edge Cases to Consider**:
- Array with exactly 2 elements (minimum size)
- Negative numbers
- Zero as target or in array
- Duplicate values in array
- Large numbers (within constraint limits)

---

## 🎯 Follow-up Questions

1. **What if the array was sorted?** Could you optimize further?
2. **What if there could be multiple pairs?** How would you return all of them?
3. **What if you needed to return the values instead of indices?**
4. **Can you solve it without using extra space?** (Trade-off with time complexity)

---

## 💭 Hints

<details>
<summary>Hint 1</summary>

Think about what you need to find for each number. If you're looking at `nums[i]`, what value would complete the pair?

</details>

<details>
<summary>Hint 2</summary>

Consider using a Hash Map (dictionary/object) to store values you've seen and their indices. This allows O(1) lookup time.

</details>

<details>
<summary>Hint 3</summary>

For each number, calculate `complement = target - nums[i]`. Then check if you've seen this complement before in your hash map.

</details>

---

## 🏷️ Related Topics / Tags

- Array
- Hash Table
- Two Pointers (alternative approach)
- Lookup Optimization

---

## 🔗 Similar Problems

- [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) - 🟡 Medium
- [3Sum](https://leetcode.com/problems/3sum/) - 🟡 Medium
- [4Sum](https://leetcode.com/problems/4sum/) - 🟡 Medium
- [Two Sum IV - BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/) - 🟢 Easy

---

## 📚 Solution Approaches

### Approach 1: Brute Force (Baseline)
- **Time Complexity**: O(n²)
- **Space Complexity**: O(1)
- **Pros**: Simple, no extra space
- **Cons**: Inefficient for large arrays

Check every pair of numbers using nested loops.

### Approach 2: Hash Map (Optimal)
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)
- **Pros**: Very fast, single pass through array
- **Cons**: Uses extra space for hash map

Use a hash map to store seen numbers and their indices, allowing O(1) lookups.

### Approach 3: Two Pointers (If array was sorted)
- **Time Complexity**: O(n log n) for sorting + O(n) for two pointers
- **Space Complexity**: O(1) or O(n) depending on sorting algorithm
- **Pros**: No hash map needed
- **Cons**: Requires sorting first, changes array order, slower than hash map

---

## 💻 Implementations

Solutions available in:
- [Python](../../solutions/python/arrays/two_sum.py)
- [Java](../../solutions/java/arrays/TwoSum.java)
- [JavaScript](../../solutions/javascript/arrays/twoSum.js)
- [Kotlin](../../solutions/kotlin/arrays/TwoSum.kt)
- [Go](../../solutions/go/arrays/two_sum.go)

---

## 📝 Notes

- This is one of the most frequently asked interview questions
- Great problem for learning hash map usage
- Foundation for understanding "complement" pattern
- Test edge cases: duplicates, negative numbers, zero

---

**Last Updated**: 2024-01-15
**Contributors**: DSA Practice Community
