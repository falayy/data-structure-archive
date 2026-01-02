# Python Solutions

DSA practice solutions implemented in Python.

## 🐍 Requirements

- **Python Version**: 3.8 or higher
- **Type Hints**: Solutions use Python 3.10+ type hint syntax

### Check Your Python Version

```bash
python --version
# or
python3 --version
```

## 📦 Setup

### 1. Install Python

**macOS** (using Homebrew):
```bash
brew install python
```

**Linux** (Ubuntu/Debian):
```bash
sudo apt update
sudo apt install python3 python3-pip
```

**Windows**:
Download from [python.org](https://www.python.org/downloads/)

### 2. Verify Installation

```bash
python3 --version
pip3 --version
```

## 🚀 Running Solutions

### Run Individual Solution

```bash
# Navigate to solution directory
cd solutions/python/arrays

# Run a specific solution
python3 two_sum.py
```

### Run with Python Interpreter

```python
# Interactive Python
python3

>>> from arrays.two_sum import two_sum
>>> result = two_sum([2, 7, 11, 15], 9)
>>> print(result)
[0, 1]
```

## 🧪 Testing Solutions

### Using Built-in Tests

Most solutions include test cases in the `if __name__ == "__main__":` block:

```bash
python3 two_sum.py
```

### Using pytest (Recommended)

Install pytest:
```bash
pip3 install pytest
```

Create test file (e.g., `test_two_sum.py`):
```python
from two_sum import two_sum

def test_basic_case():
    assert two_sum([2, 7, 11, 15], 9) == [0, 1]

def test_duplicates():
    assert two_sum([3, 3], 6) == [0, 1]
```

Run tests:
```bash
pytest test_two_sum.py -v
```

## 💡 Code Style

### PEP 8 Compliance

All Python solutions follow [PEP 8](https://pep8.org/) style guidelines.

### Check Style

Install linting tools:
```bash
pip3 install flake8 pylint black
```

**Flake8** (quick linter):
```bash
flake8 two_sum.py
```

**Pylint** (comprehensive):
```bash
pylint two_sum.py
```

**Black** (auto-formatter):
```bash
# Check formatting
black --check two_sum.py

# Auto-format
black two_sum.py
```

## 📚 Type Hints

Solutions use type hints for better code clarity:

```python
def two_sum(nums: list[int], target: int) -> list[int]:
    """Find two numbers that add up to target."""
    ...
```

### Type Checking

Install mypy:
```bash
pip3 install mypy
```

Check types:
```bash
mypy two_sum.py
```

## 🛠 Recommended Tools

### IDEs

- **VS Code** with Python extension
  - Install: Python, Pylance extensions
  - Auto-formatting, linting, debugging
- **PyCharm** (Community or Professional)
  - Built-in Python support
  - Excellent debugger
- **Jupyter Notebook** (for interactive exploration)
  ```bash
  pip3 install jupyter
  jupyter notebook
  ```

### Virtual Environments

Recommended for isolating dependencies:

```bash
# Create virtual environment
python3 -m venv venv

# Activate (macOS/Linux)
source venv/bin/activate

# Activate (Windows)
venv\Scripts\activate

# Install packages
pip install -r requirements.txt

# Deactivate
deactivate
```

## 📖 Learning Resources

### Python Basics
- [Official Python Tutorial](https://docs.python.org/3/tutorial/)
- [Real Python](https://realpython.com/)
- [Python for Everybody](https://www.py4e.com/)

### Data Structures in Python
- [Python Data Structures](https://docs.python.org/3/tutorial/datastructures.html)
- [collections module](https://docs.python.org/3/library/collections.html)
- [heapq module](https://docs.python.org/3/library/heapq.html)

### Algorithm Complexity
- [Time Complexity in Python](https://wiki.python.org/moin/TimeComplexity)
- [Big O Cheat Sheet](https://www.bigocheatsheet.com/)

## 🎯 Common Patterns

### Iteration

```python
# Index and value
for i, num in enumerate(nums):
    print(f"Index {i}: {num}")

# Range
for i in range(len(nums)):
    print(nums[i])

# Reverse iteration
for i in range(len(nums) - 1, -1, -1):
    print(nums[i])
```

### List Comprehensions

```python
# Create new list
squares = [x**2 for x in nums]

# With condition
evens = [x for x in nums if x % 2 == 0]

# Nested
pairs = [(x, y) for x in nums for y in nums if x != y]
```

### Useful Data Structures

```python
# Dictionary (Hash Map)
freq = {}
freq[num] = freq.get(num, 0) + 1

# Set
unique = set(nums)

# Counter (from collections)
from collections import Counter
count = Counter(nums)

# Heap
import heapq
heap = []
heapq.heappush(heap, num)
smallest = heapq.heappop(heap)
```

## ⚡ Performance Tips

1. **Use built-in functions**: `sum()`, `max()`, `min()` are optimized
2. **List comprehensions** are faster than loops
3. **Use `set` for O(1) lookups** instead of `list`
4. **`collections.deque`** for O(1) append/pop at both ends
5. **`bisect`** module for binary search on sorted lists

## 🐛 Debugging

### Print Debugging

```python
def two_sum(nums, target):
    seen = {}
    for i, num in enumerate(nums):
        complement = target - num
        print(f"i={i}, num={num}, complement={complement}, seen={seen}")
        if complement in seen:
            return [seen[complement], i]
        seen[num] = i
```

### Using pdb

```python
import pdb

def two_sum(nums, target):
    pdb.set_trace()  # Debugger will stop here
    seen = {}
    # ...
```

### VS Code Debugging

1. Set breakpoint (click left of line number)
2. Press F5 or Run > Start Debugging
3. Step through code with F10/F11

## 📝 Solution Template

```python
"""
Problem: [Problem Name]
Source: [URL]
Difficulty: Easy/Medium/Hard
Category: [Category]

Brief description.

Time Complexity: O(?)
Space Complexity: O(?)
"""


def solution_function(param: type) -> return_type:
    """
    Brief description of approach.

    Args:
        param: Description

    Returns:
        Description

    Examples:
        >>> solution_function(input)
        output
    """
    # Implementation
    pass


if __name__ == "__main__":
    # Test cases
    test_cases = [
        (input1, expected1),
        (input2, expected2),
    ]

    for i, (input_val, expected) in enumerate(test_cases, 1):
        result = solution_function(input_val)
        status = "✓" if result == expected else "✗"
        print(f"Test {i}: {status}")
        print(f"  Input: {input_val}")
        print(f"  Output: {result}")
        print(f"  Expected: {expected}\n")
```

## 🔗 Useful Links

- [Python Documentation](https://docs.python.org/3/)
- [Python Package Index (PyPI)](https://pypi.org/)
- [Real Python Tutorials](https://realpython.com/)
- [Python Tutor (Visualize Code)](https://pythontutor.com/)

---

**Happy Coding with Python! 🐍**
