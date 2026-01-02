# Contributing to DSA Practice Repository

Thank you for your interest in contributing! This guide will help you add problems and solutions that maintain our repository's quality and consistency.

## 📋 Table of Contents

- [How to Contribute](#how-to-contribute)
- [Adding New Problems](#adding-new-problems)
- [Submitting Solutions](#submitting-solutions)
- [Code Style Guidelines](#code-style-guidelines)
- [Git Workflow](#git-workflow)
- [Review Checklist](#review-checklist)
- [Getting Help](#getting-help)

---

## 🤝 How to Contribute

You can contribute in several ways:

1. **Add new problems** with complete descriptions
2. **Submit solutions** in any supported language
3. **Improve existing solutions** with optimizations or alternative approaches
4. **Fix bugs** or improve documentation
5. **Add tests** for existing solutions

---

## ➕ Adding New Problems

### Step 1: Choose the Right Category

Place your problem in the appropriate category:
- `arrays/` - Array manipulation, searching, sorting
- `linked_lists/` - Linked list operations
- `stacks_queues/` - Stack and queue problems
- `trees/` - Binary trees, BST, tree traversals
- `graphs/` - Graph algorithms (BFS, DFS, shortest paths)
- `dynamic_programming/` - DP problems
- `strings/` - String manipulation

### Step 2: Create Problem Description

1. Copy the template:
   ```bash
   cp problems/TEMPLATE.md problems/<category>/<problem_name>.md
   ```

2. Fill in all sections:
   - **Title**: Clear, concise problem name
   - **Source**: Link to original problem (LeetCode, HackerRank, etc.)
   - **Difficulty**: Easy/Medium/Hard
   - **Description**: Clear explanation of what needs to be solved
   - **Examples**: At least 2-3 examples with explanations
   - **Constraints**: Input constraints and edge cases
   - **Tags**: Related topics (e.g., array, two-pointers, hash-map)

### Step 3: Problem Naming Convention

Use `snake_case` for problem file names:
- ✅ `two_sum.md`
- ✅ `maximum_subarray.md`
- ✅ `reverse_linked_list.md`
- ❌ `TwoSum.md`
- ❌ `two-sum.md`

### Example Problem Structure

```markdown
# Problem Title

**Source**: [LeetCode #1](https://leetcode.com/problems/two-sum/)
**Difficulty**: 🟢 Easy

## Problem Description
[Clear description here]

## Examples
[At least 2 examples with explanations]

## Constraints
[Input constraints]

## Related Topics
- Arrays
- Hash Table
- Two Pointers
```

---

## 📝 Submitting Solutions

### Prerequisites

**Important**: All solutions should be **tested locally** before submission. We assume your code works correctly.

### Solution Format Requirements

Every solution **must** include:

1. **File Header**:
   ```python
   """
   Problem: Two Sum
   Source: https://leetcode.com/problems/two-sum/
   Difficulty: Easy
   Author: Your Name (optional)
   Date: 2024-01-15
   """
   ```

2. **Time Complexity Analysis**:
   ```python
   # Time Complexity: O(n)
   # Space Complexity: O(n)
   ```

3. **Clean Implementation**:
   - Well-named variables
   - Inline comments for complex logic
   - Proper error handling

4. **Example Usage**:
   ```python
   if __name__ == "__main__":
       # Example usage
       nums = [2, 7, 11, 15]
       target = 9
       result = two_sum(nums, target)
       print(f"Result: {result}")  # Output: [0, 1]
   ```

### Language-Specific Guidelines

#### Python (`solutions/python/`)
- **File name**: `snake_case` (e.g., `two_sum.py`)
- **Function name**: `snake_case`
- **Version**: Python 3.8+
- **Style**: Follow PEP 8
- **Type hints**: Use type annotations
- **Docstrings**: Include function docstrings

```python
def two_sum(nums: list[int], target: int) -> list[int]:
    """
    Find two numbers that add up to target.

    Args:
        nums: List of integers
        target: Target sum

    Returns:
        List containing indices of the two numbers
    """
    # Implementation here
```

#### Java (`solutions/java/`)
- **File name**: `PascalCase` (e.g., `TwoSum.java`)
- **Class name**: Must match file name
- **Version**: Java 17+
- **Style**: Follow Google Java Style Guide
- **Javadoc**: Include method documentation

```java
public class TwoSum {
    /**
     * Find two numbers that add up to target.
     *
     * @param nums Array of integers
     * @param target Target sum
     * @return Array containing indices of the two numbers
     */
    public int[] twoSum(int[] nums, int target) {
        // Implementation here
    }
}
```

#### JavaScript (`solutions/javascript/`)
- **File name**: `camelCase` (e.g., `twoSum.js`)
- **Function name**: `camelCase`
- **Version**: ES6+ (Node 16+)
- **Style**: Use ESLint with Standard/Airbnb config
- **JSDoc**: Include function documentation

```javascript
/**
 * Find two numbers that add up to target
 * @param {number[]} nums - Array of integers
 * @param {number} target - Target sum
 * @return {number[]} - Indices of the two numbers
 */
function twoSum(nums, target) {
    // Implementation here
}
```

#### Kotlin (`solutions/kotlin/`)
- **File name**: `PascalCase` (e.g., `TwoSum.kt`)
- **Function name**: `camelCase`
- **Version**: Kotlin 1.8+
- **Style**: Follow Kotlin Coding Conventions
- **KDoc**: Include function documentation

```kotlin
/**
 * Find two numbers that add up to target.
 *
 * @param nums Array of integers
 * @param target Target sum
 * @return Array containing indices of the two numbers
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    // Implementation here
}
```

#### Go (`solutions/go/`)
- **File name**: `snake_case` (e.g., `two_sum.go`)
- **Function name**: `PascalCase` for exported, `camelCase` for internal
- **Version**: Go 1.19+
- **Style**: Use `gofmt` and `golint`
- **Comments**: Include function comments

```go
// TwoSum finds two numbers that add up to target.
// Time: O(n), Space: O(n)
func TwoSum(nums []int, target int) []int {
    // Implementation here
}
```

---

## 🎨 Code Style Guidelines

### General Principles

1. **Clarity over Cleverness**: Write readable code
2. **Meaningful Names**: Use descriptive variable/function names
3. **Comments**: Explain the "why", not the "what"
4. **Consistency**: Follow language-specific conventions
5. **Error Handling**: Handle edge cases gracefully

### Complexity Analysis Format

Always include complexity analysis at the top of your solution:

```
Time Complexity: O(n log n)
  - Explanation: Sorting takes O(n log n), iteration takes O(n)

Space Complexity: O(1)
  - Explanation: Only constant extra space used
```

### Alternative Approaches

If you have multiple solutions, document them:

```python
# Approach 1: Hash Map (Optimal)
# Time: O(n), Space: O(n)
def two_sum_hash(nums, target):
    # Implementation

# Approach 2: Brute Force (Baseline)
# Time: O(n²), Space: O(1)
def two_sum_brute(nums, target):
    # Implementation
```

---

## 🔄 Git Workflow

### Branching Strategy

1. **Fork** the repository
2. **Clone** your fork locally
3. **Create** a feature branch from `main`:
   ```bash
   git checkout -b feature/add-two-sum-python
   ```

### Branch Naming Convention

Use descriptive branch names:
- `feature/add-<problem>-<language>` - New solution
- `feature/add-problem-<name>` - New problem
- `fix/<problem>-<language>` - Bug fix
- `docs/update-readme` - Documentation update

**Examples**:
- `feature/add-two-sum-python`
- `feature/add-problem-binary-search`
- `fix/max-subarray-java`

### Commit Message Format

Follow the **Conventional Commits** format:

```
<type>(<scope>): <description>

[optional body]

[optional footer]
```

**Types**:
- `feat`: New feature (problem or solution)
- `fix`: Bug fix
- `docs`: Documentation update
- `style`: Code style/formatting
- `refactor`: Code refactoring
- `test`: Adding tests
- `chore`: Maintenance tasks

**Examples**:
```bash
feat(python): Add Two Sum solution with hash map approach

- Implemented O(n) time complexity solution
- Added comprehensive comments and complexity analysis
- Included example usage in main block

feat(problems): Add Binary Search problem description

- Added problem statement with 3 examples
- Included constraints and edge cases
- Tagged with array, binary-search, divide-and-conquer
```

### Pull Request Process

1. **Ensure your code follows all guidelines** in this document
2. **Run through the review checklist** (see below)
3. **Push to your fork**:
   ```bash
   git push origin feature/add-two-sum-python
   ```
4. **Open a Pull Request** with:
   - **Title**: Clear, descriptive (e.g., "Add: Two Sum solution in Python")
   - **Description**: What you added/changed and why
   - **Checklist**: Confirm you've completed all requirements

### PR Template

```markdown
## Description
[Describe what you added/changed]

## Type of Change
- [ ] New problem
- [ ] New solution
- [ ] Bug fix
- [ ] Documentation update

## Checklist
- [ ] Code follows style guidelines
- [ ] Includes complexity analysis
- [ ] Includes comments for complex logic
- [ ] Tested locally
- [ ] Added example usage
- [ ] Updated relevant README if needed
```

---

## ✅ Review Checklist

Before submitting your contribution, verify:

### For Problem Submissions

- [ ] Problem file uses `snake_case` naming
- [ ] Placed in correct category folder
- [ ] Includes difficulty level (Easy/Medium/Hard)
- [ ] Has clear problem description
- [ ] Contains at least 2 examples with explanations
- [ ] Lists all constraints
- [ ] Includes source/reference link
- [ ] Tagged with relevant topics

### For Solution Submissions

- [ ] File name follows language convention
- [ ] Includes file header with problem reference
- [ ] Has time complexity analysis with explanation
- [ ] Has space complexity analysis with explanation
- [ ] Code is well-commented
- [ ] Uses meaningful variable names
- [ ] Includes example usage
- [ ] **Tested locally and works correctly**
- [ ] Handles edge cases
- [ ] Follows language-specific style guide

### Code Quality Checks

**Python**:
```bash
# Format check
black --check <file>.py

# Linting
flake8 <file>.py
pylint <file>.py
```

**Java**:
```bash
# Compile check
javac <File>.java

# Style check (with checkstyle)
checkstyle -c google_checks.xml <File>.java
```

**JavaScript**:
```bash
# Linting
eslint <file>.js

# Format check
prettier --check <file>.js
```

**Kotlin**:
```bash
# Compile check
kotlinc <File>.kt

# Format check
ktlint <File>.kt
```

**Go**:
```bash
# Format
gofmt -w <file>.go

# Linting
golint <file>.go

# Vet
go vet <file>.go
```

---

## 🆘 Getting Help

### Questions About Contributing?

- **Check existing issues**: Someone may have asked the same question
- **Open a discussion**: Use GitHub Discussions for general questions
- **Ask in PR comments**: If you're stuck on a specific contribution

### Found a Bug?

1. **Search existing issues** to avoid duplicates
2. **Open a new issue** with:
   - Clear title
   - Steps to reproduce
   - Expected vs actual behavior
   - Solution file/language affected

### Want to Suggest an Improvement?

1. **Open an issue** with the `enhancement` label
2. Describe the improvement
3. Explain why it would be beneficial
4. Discuss before implementing

---

## 🎯 Best Practices

### Do's ✅

- ✅ Test your code thoroughly before submitting
- ✅ Write clear, self-explanatory code
- ✅ Include complexity analysis
- ✅ Add comments for non-obvious logic
- ✅ Follow language conventions
- ✅ Keep solutions focused and clean
- ✅ Provide alternative approaches when helpful

### Don'ts ❌

- ❌ Don't submit untested code
- ❌ Don't copy-paste without understanding
- ❌ Don't use obscure variable names (e.g., `a`, `b`, `temp1`)
- ❌ Don't skip complexity analysis
- ❌ Don't mix multiple problems in one PR
- ❌ Don't ignore code style guidelines
- ❌ Don't add unnecessary dependencies

---

## 📚 Additional Resources

### Style Guides

- **Python**: [PEP 8](https://pep8.org/)
- **Java**: [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- **JavaScript**: [Airbnb JavaScript Style Guide](https://github.com/airbnb/javascript)
- **Kotlin**: [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- **Go**: [Effective Go](https://golang.org/doc/effective_go.html)

### Git Resources

- [Conventional Commits](https://www.conventionalcommits.org/)
- [Git Best Practices](https://git-scm.com/book/en/v2)
- [GitHub Flow](https://guides.github.com/introduction/flow/)

---

## 🙏 Thank You!

Your contributions help make this repository a valuable learning resource for developers preparing for technical interviews and improving their algorithmic thinking. Every solution, fix, and improvement matters!

**Happy Contributing! 🚀**
