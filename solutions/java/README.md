# Java Solutions

DSA practice solutions implemented in Java.

## ☕ Requirements

- **Java Version**: Java 17 or higher (LTS recommended)
- **Build Tool**: Maven or Gradle (optional)

### Check Your Java Version

```bash
java -version
javac -version
```

## 📦 Setup

### 1. Install Java JDK

**macOS** (using Homebrew):
```bash
brew install openjdk@17
```

**Linux** (Ubuntu/Debian):
```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

**Windows**:
- Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or
- Use [OpenJDK](https://adoptium.net/)

### 2. Set JAVA_HOME

**macOS/Linux** (add to `~/.bashrc` or `~/.zshrc`):
```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 17)
export PATH=$JAVA_HOME/bin:$PATH
```

**Windows**:
1. System Properties > Environment Variables
2. Add `JAVA_HOME` pointing to JDK installation
3. Add `%JAVA_HOME%\bin` to PATH

### 3. Verify Installation

```bash
java -version    # Should show 17.x.x
javac -version   # Should show 17.x.x
```

## 🚀 Running Solutions

### Compile and Run

```bash
# Navigate to solution directory
cd solutions/java/arrays

# Compile
javac TwoSum.java

# Run (with package)
cd ..
java arrays.TwoSum

# Or run directly if no package
java TwoSum
```

### Run Without Compilation (Java 11+)

```bash
java TwoSum.java
```

## 🧪 Testing Solutions

### Using Built-in Main Method

Most solutions include a `main` method with test cases:

```bash
javac TwoSum.java
java TwoSum
```

### Using JUnit (Recommended)

**Add JUnit 5** (Maven):
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.0</version>
    <scope>test</scope>
</dependency>
```

**Create Test File** (`TwoSumTest.java`):
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    @Test
    void testBasicCase() {
        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    void testDuplicates() {
        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(new int[]{3, 3}, 6);
        assertArrayEquals(new int[]{0, 1}, result);
    }
}
```

**Run Tests**:
```bash
# With Maven
mvn test

# With Gradle
gradle test
```

## 💡 Code Style

### Google Java Style Guide

All Java solutions follow [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).

**Key Conventions**:
- Class names: `PascalCase`
- Method names: `camelCase`
- Constants: `UPPER_SNAKE_CASE`
- Indentation: 2 or 4 spaces (consistent)
- Braces: K&R style

### Check Style

**Using Checkstyle**:

Download checkstyle:
```bash
wget https://github.com/checkstyle/checkstyle/releases/download/checkstyle-10.9.3/checkstyle-10.9.3-all.jar
```

Run checkstyle:
```bash
java -jar checkstyle-10.9.3-all.jar -c google_checks.xml TwoSum.java
```

## 🛠 Recommended Tools

### IDEs

1. **IntelliJ IDEA** (Recommended)
   - Download: [JetBrains](https://www.jetbrains.com/idea/download/)
   - Community Edition is free
   - Excellent autocomplete, refactoring, debugging

2. **Eclipse**
   - Download: [eclipse.org](https://www.eclipse.org/downloads/)
   - Free and open-source

3. **VS Code** with Java Extension Pack
   - Install: "Extension Pack for Java"
   - Lightweight alternative

### Build Tools

**Maven**:
```xml
<!-- pom.xml -->
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.dsa</groupId>
    <artifactId>practice</artifactId>
    <version>1.0</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>
</project>
```

**Gradle**:
```groovy
// build.gradle
plugins {
    id 'java'
}

sourceCompatibility = 17
targetCompatibility = 17
```

## 📖 Learning Resources

### Java Basics
- [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- [Java Documentation](https://docs.oracle.com/en/java/javase/17/)
- [Baeldung](https://www.baeldung.com/)

### Data Structures in Java
- [Collections Framework](https://docs.oracle.com/javase/tutorial/collections/)
- [Java Collections Guide](https://www.baeldung.com/java-collections)

### Best Practices
- [Effective Java (Book)](https://www.oreilly.com/library/view/effective-java/9780134686097/)
- [Java Best Practices](https://www.baeldung.com/java-best-practices)

## 🎯 Common Patterns

### Collections Framework

```java
// ArrayList
List<Integer> list = new ArrayList<>();
list.add(1);
list.get(0);

// HashMap
Map<Integer, Integer> map = new HashMap<>();
map.put(key, value);
map.get(key);
map.getOrDefault(key, defaultValue);
map.containsKey(key);

// HashSet
Set<Integer> set = new HashSet<>();
set.add(1);
set.contains(1);

// LinkedList (as Queue)
Queue<Integer> queue = new LinkedList<>();
queue.offer(1);
queue.poll();

// PriorityQueue (Min Heap)
PriorityQueue<Integer> heap = new PriorityQueue<>();
heap.offer(1);
heap.poll();
```

### Iteration

```java
// Traditional for loop
for (int i = 0; i < nums.length; i++) {
    System.out.println(nums[i]);
}

// Enhanced for loop
for (int num : nums) {
    System.out.println(num);
}

// Streams (Java 8+)
Arrays.stream(nums)
      .filter(n -> n > 0)
      .forEach(System.out::println);
```

### Useful Utilities

```java
// Arrays
Arrays.sort(nums);
Arrays.fill(nums, 0);
Arrays.equals(arr1, arr2);
Arrays.toString(nums);

// Collections
Collections.sort(list);
Collections.reverse(list);
Collections.max(list);

// Math
Math.max(a, b);
Math.min(a, b);
Math.abs(num);
```

## ⚡ Performance Tips

1. **Use StringBuilder** for string concatenation in loops
2. **HashMap/HashSet** for O(1) lookups
3. **ArrayList** for dynamic arrays (not arrays)
4. **LinkedList** when frequent insertions/deletions
5. **PriorityQueue** for heap operations

## 🐛 Debugging

### Print Debugging

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> seen = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        System.out.printf("i=%d, num=%d, complement=%d, seen=%s%n",
                         i, nums[i], complement, seen);
        // ...
    }
}
```

### IntelliJ Debugger

1. Set breakpoint (click line number gutter)
2. Run > Debug (Shift+F9)
3. Step over (F8), Step into (F7)
4. Evaluate expression (Alt+F8)

### Assertions

```java
assert nums != null : "nums cannot be null";
assert nums.length >= 2 : "nums must have at least 2 elements";
```

Run with assertions enabled:
```bash
java -ea TwoSum
```

## 📝 Solution Template

```java
/**
 * Problem: [Problem Name]
 * Source: [URL]
 * Difficulty: Easy/Medium/Hard
 * Category: [Category]
 *
 * Brief description.
 *
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 */

package category;

import java.util.*;

public class SolutionClass {

    /**
     * Brief description of method.
     *
     * @param param Description
     * @return Description
     */
    public ReturnType methodName(ParamType param) {
        // Implementation
        return result;
    }

    /**
     * Main method with test cases.
     */
    public static void main(String[] args) {
        SolutionClass solution = new SolutionClass();

        // Test cases
        Object[][] testCases = {
            {input1, expected1},
            {input2, expected2}
        };

        for (int i = 0; i < testCases.length; i++) {
            Input input = (Input) testCases[i][0];
            Expected expected = (Expected) testCases[i][1];

            Result result = solution.methodName(input);
            boolean passed = result.equals(expected);
            String status = passed ? "✓" : "✗";

            System.out.println("Test Case " + (i + 1) + ": " + status);
            System.out.println("  Input: " + input);
            System.out.println("  Output: " + result);
            System.out.println("  Expected: " + expected);
            System.out.println();
        }
    }
}
```

## 🔗 Useful Links

- [Java SE Documentation](https://docs.oracle.com/en/java/javase/17/)
- [Java API Specification](https://docs.oracle.com/en/java/javase/17/docs/api/)
- [Maven Repository](https://mvnrepository.com/)
- [Baeldung](https://www.baeldung.com/)
- [DZone Java Zone](https://dzone.com/java-jdk-development-tutorials-tools-news)

---

**Happy Coding with Java! ☕**
