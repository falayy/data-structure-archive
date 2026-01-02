# DSA Practice - Multi-Language Solutions Repository

A collaborative repository for Data Structures and Algorithms practice with tested solutions across multiple programming languages.

[![Languages](https://img.shields.io/badge/Languages-Python%20%7C%20Java%20%7C%20JavaScript%20%7C%20Kotlin%20%7C%20Go-blue)]()
[![Contributions Welcome](https://img.shields.io/badge/Contributions-Welcome-brightgreen.svg)]()
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)]()

## 📚 Purpose

This repository serves as a **collaborative learning platform** for practicing Data Structures and Algorithms across multiple programming languages. Each problem includes:

- Clear problem statements with examples
- Solutions in **Python, Java, JavaScript, Kotlin, and Go**
- Detailed complexity analysis (time and space)
- Well-commented, production-quality code
- Multiple approaches where applicable

Perfect for:
- 🎯 Interview preparation
- 💡 Learning new programming languages through familiar problems
- 🔄 Comparing different language implementations
- 📖 Building a personal DSA reference library

---

## 📁 Repository Structure

```
dsa-practice/
│
├── README.md              # This file - project overview
├── CONTRIBUTING.md        # How to contribute to this repository
├── .gitignore            # Git ignore rules
│
├── problems/             # Problem statements organized by topic
│   ├── arrays/
│   │   ├── README.md     # Arrays topic overview
│   │   ├── two_sum.md    # Individual problem description
│   │   └── ...
│   ├── linked_lists/
│   ├── stacks_queues/
│   ├── trees/
│   ├── graphs/
│   ├── dynamic_programming/
│   └── strings/
│
└── solutions/            # Solutions organized by language, then topic
    ├── python/
    │   ├── README.md     # Python setup & running instructions
    │   ├── arrays/
    │   │   ├── two_sum.py
    │   │   └── ...
    │   └── ...
    │
    ├── java/
    │   ├── README.md
    │   └── arrays/
    │       ├── TwoSum.java
    │       └── ...
    │
    ├── javascript/
    │   ├── README.md
    │   └── arrays/
    │       ├── twoSum.js
    │       └── ...
    │
    ├── kotlin/
    │   ├── README.md
    │   └── ...
    │
    └── go/
        ├── README.md
        └── ...
```

---

## 🎯 Problem Categories

| Category | Description | Example Problems |
|----------|-------------|------------------|
| **Arrays** | Array manipulation, searching, sorting | Two Sum, Maximum Subarray, Rotate Array |
| **Linked Lists** | Singly/doubly linked lists, fast & slow pointers | Reverse Linked List, Detect Cycle |
| **Stacks & Queues** | LIFO/FIFO operations, monotonic stacks | Valid Parentheses, Min Stack |
| **Trees** | Binary trees, BST, tree traversals | Inorder Traversal, Validate BST |
| **Graphs** | BFS, DFS, shortest paths, topological sort | Number of Islands, Course Schedule |
| **Dynamic Programming** | Memoization, tabulation, optimization | Climbing Stairs, Coin Change |
| **Strings** | String manipulation, pattern matching | Longest Substring, Valid Palindrome |

---

## 🚀 How to Use This Repository

### For Learning

1. **Browse by Topic**: Navigate to `problems/<category>/` to find problems by topic
2. **Read the Problem**: Each `.md` file contains the problem statement, examples, and constraints
3. **Attempt the Solution**: Try solving it yourself first
4. **Review Solutions**: Check `solutions/<language>/<category>/` for reference implementations
5. **Compare Approaches**: Look at solutions in different languages to understand various paradigms

### For Interview Prep

1. **Random Practice**: Pick problems from different categories
2. **Timed Practice**: Set a timer and attempt problems under time pressure
3. **Review Complexity**: Study time/space complexity analysis in solutions
4. **Learn Patterns**: Identify common patterns (two pointers, sliding window, etc.)

### For Language Learning

1. **Pick a Familiar Problem**: Choose a problem you've solved before
2. **Implement in New Language**: Try solving it in a language you're learning
3. **Compare Implementations**: See how the same algorithm looks in different languages
4. **Study Idioms**: Learn language-specific patterns and best practices

---

## 📝 Naming Conventions

We follow language-specific naming conventions for consistency:

### File Names

| Language   | Convention | Example |
|------------|------------|---------|
| Python     | `snake_case` | `two_sum.py` |
| Java       | `PascalCase` | `TwoSum.java` |
| JavaScript | `camelCase` | `twoSum.js` |
| Kotlin     | `PascalCase` | `TwoSum.kt` |
| Go         | `snake_case` | `two_sum.go` |

### Function Names

| Language   | Convention | Example |
|------------|------------|---------|
| Python     | `snake_case` | `def two_sum(nums, target):` |
| Java       | `camelCase` | `public int[] twoSum(int[] nums, int target)` |
| JavaScript | `camelCase` | `function twoSum(nums, target)` |
| Kotlin     | `camelCase` | `fun twoSum(nums: IntArray, target: Int)` |
| Go         | `PascalCase` (exported) / `camelCase` (private) | `func TwoSum(nums []int, target int)` |

### Class Names (where applicable)

| Language   | Convention | Example |
|------------|------------|---------|
| Java       | `PascalCase` | `class TwoSum` |
| Kotlin     | `PascalCase` | `class TwoSum` |
| JavaScript | `PascalCase` | `class TwoSum` |

---

## 🔍 Finding Solutions

### By Problem Name
```bash
# Example: Finding "Two Sum" solutions
problems/arrays/two_sum.md           # Problem statement
solutions/python/arrays/two_sum.py   # Python solution
solutions/java/arrays/TwoSum.java    # Java solution
solutions/javascript/arrays/twoSum.js # JavaScript solution
solutions/kotlin/arrays/TwoSum.kt    # Kotlin solution
solutions/go/arrays/two_sum.go       # Go solution
```

### By Language
Each language folder has a README.md with:
- Setup instructions
- How to run solutions
- Language version requirements
- Recommended tools

### By Category
Each problem category folder (`problems/<category>/`) has a README.md listing all problems in that category with difficulty levels.

---

## 🤝 Contributing

We welcome contributions! Here's how you can help:

1. **Add New Problems**: Submit well-documented problem statements
2. **Add Solutions**: Implement solutions in any supported language
3. **Improve Existing Solutions**: Optimize code, add alternative approaches
4. **Fix Bugs**: Report and fix issues in existing solutions
5. **Improve Documentation**: Enhance explanations, add examples

**Before contributing, please read [CONTRIBUTING.md](CONTRIBUTING.md) for detailed guidelines.**

### Quick Contribution Steps

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/add-problem-name`)
3. Add your problem/solution following templates
4. Ensure code is tested and includes complexity analysis
5. Commit with clear message (`git commit -m 'Add: Two Sum solution in Python'`)
6. Push to your fork (`git push origin feature/add-problem-name`)
7. Open a Pull Request

---

## 📋 Solution Requirements

All solutions must include:

- ✅ **Clear problem reference** (LeetCode #, source link)
- ✅ **Time complexity analysis** in comments
- ✅ **Space complexity analysis** in comments
- ✅ **Inline comments** for complex logic
- ✅ **Example usage** (in comments or main function)
- ✅ **Self-contained code** that can run independently
- ✅ **Proper error handling** where applicable

---

## 🛠 Language-Specific Setup

| Language | Version | Setup Guide |
|----------|---------|-------------|
| Python | 3.8+ | [solutions/python/README.md](solutions/python/README.md) |
| Java | 17+ | [solutions/java/README.md](solutions/java/README.md) |
| JavaScript | ES6+ (Node 16+) | [solutions/javascript/README.md](solutions/javascript/README.md) |
| Kotlin | 1.8+ | [solutions/kotlin/README.md](solutions/kotlin/README.md) |
| Go | 1.19+ | [solutions/go/README.md](solutions/go/README.md) |

---

## 📊 Problem Difficulty Distribution

Problems are categorized by difficulty:

- 🟢 **Easy**: Fundamental concepts, straightforward implementation
- 🟡 **Medium**: Requires algorithmic thinking, multiple concepts
- 🔴 **Hard**: Complex algorithms, advanced optimization

---

## 🔗 Useful Resources

### Problem Sources
- [LeetCode](https://leetcode.com/) - Large collection of coding problems
- [HackerRank](https://www.hackerrank.com/) - Practice and competitions
- [CodeForces](https://codeforces.com/) - Competitive programming
- [GeeksforGeeks](https://www.geeksforgeeks.org/) - Tutorials and practice

### Learning Resources
- [NeetCode](https://neetcode.io/) - Curated problem lists
- [Blind 75](https://www.teamblind.com/post/New-Year-Gift---Curated-List-of-Top-75-LeetCode-Questions-to-Save-Your-Time-OaM1orEU) - Essential interview problems
- [Grind 75](https://www.techinterviewhandbook.org/grind75) - Structured study plan

### Algorithm Visualization
- [VisuAlgo](https://visualgo.net/) - Algorithm visualizations
- [Algorithm Visualizer](https://algorithm-visualizer.org/) - Interactive visualizations

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🌟 Acknowledgments

- Thanks to all contributors who help make this repository a valuable learning resource
- Problem statements are adapted from various online coding platforms (with proper attribution)
- Inspired by the coding interview preparation community

---

## 📞 Contact & Support

- **Issues**: Report bugs or request features via [GitHub Issues](../../issues)
- **Discussions**: Join conversations in [GitHub Discussions](../../discussions)
- **PRs**: Submit solutions via Pull Requests

---

**Happy Coding! 🚀**

*Remember: The goal is not just to solve problems, but to understand the underlying patterns and concepts.*
