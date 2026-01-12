# Contains Duplicate

**Source**: [NeetCode - Duplicate Integer](https://neetcode.io/problems/duplicate-integer/question?list=blind75)
**Difficulty**: 🟢 Easy

---

## 📝 Problem Description

Given an integer array `nums`, return `true` if any value appears **more than once** in the array, otherwise return `false`.

---

## 💡 Examples

### Example 1

**Input**:
```
nums = [1, 2, 3, 3]
```

**Output**:
```
true
```

**Explanation**:
```
The value 3 appears twice in the array (at indices 2 and 3).
Since there is a duplicate, we return true.
```

---

### Example 2

**Input**:
```
nums = [1, 2, 3, 4]
```

**Output**:
```
false
```

**Explanation**:
```
All values in the array are unique.
Since there are no duplicates, we return false.
```

---

### Example 3 (Edge Case)

**Input**:
```
nums = [1]
```

**Output**:
```
false
```

**Explanation**:
```
A single-element array cannot have duplicates.
```

---

## 🔒 Constraints

- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

**Edge Cases to Consider**:
- Array with single element (minimum size)
- Array where all elements are the same
- Array where all elements are unique
- Negative numbers and zero
- Large numbers (within constraint limits)
- Empty array handling (if allowed)

---

## 🎯 Follow-up Questions

1. **What if you needed to find which value is duplicated?** How would you return it?
2. **What if you needed to find all duplicated values?** How would you return them?
3. **Can you solve it without using extra space?** (Trade-off with time complexity)
4. **What if the array was sorted?** Could you optimize further?

---

## 💭 Hints

<details>
<summary>Hint 1</summary>

Think about what data structure allows you to check if you've seen a value before in O(1) time.

</details>

<details>
<summary>Hint 2</summary>

Consider using a Hash Set to track values you've encountered while iterating through the array.

</details>

<details>
<summary>Hint 3</summary>

For each element, check if it already exists in your set. If yes, you found a duplicate. If no, add it to the set and continue.

</details>

---

## 🏷️ Related Topics / Tags

- Array
- Hash Table
- Set
- Sorting (alternative approach)

---

## 🔗 Similar Problems

- [Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/) - 🟢 Easy
- [Contains Duplicate III](https://leetcode.com/problems/contains-duplicate-iii/) - 🔴 Hard
- [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) - 🟡 Medium
- [Single Number](https://leetcode.com/problems/single-number/) - 🟢 Easy

---

## 📚 Solution Approaches

### Approach 1: Brute Force (Baseline)
- **Time Complexity**: O(n²)
- **Space Complexity**: O(1)
- **Pros**: Simple, no extra space
- **Cons**: Very inefficient for large arrays

Check every pair of elements to see if any two are equal.

### Approach 2: Sorting
- **Time Complexity**: O(n log n)
- **Space Complexity**: O(1) or O(n) depending on sorting algorithm
- **Pros**: No extra space needed (in-place sort)
- **Cons**: Modifies the original array, slower than hash set

Sort the array first, then check adjacent elements for duplicates.

### Approach 3: Hash Set (Optimal)
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)
- **Pros**: Very fast, single pass through array
- **Cons**: Uses extra space for hash set

Use a hash set to track seen values, allowing O(1) lookups.

---

## 💻 Implementations

Solutions available in:
- [Python](../../solutions/python/arrays/contains_duplicate.py)
- [Java](../../solutions/java/arrays/ContainsDuplicate.java)
- [JavaScript](../../solutions/javascript/arrays/containsDuplicate.js)
- [Kotlin](../../solutions/kotlin/arrays/ContainsDuplicate.kt)
- [Go](../../solutions/go/arrays/contains_duplicate.go)

---

## 📝 Notes

- Simple problem that tests understanding of hash sets
- Common interview warm-up question
- Foundation for more complex duplicate-finding problems
- Hash set approach is the standard optimal solution
- Be careful about modifying the input array when sorting

---

**Last Updated**: 2026-01-12
**Contributors**: DSA Practice Community
