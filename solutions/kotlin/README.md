# Kotlin Solutions

DSA practice solutions implemented in Kotlin.

## 🎯 Requirements

- **Kotlin Version**: 1.8 or higher
- **JDK**: Java 11 or higher (Kotlin runs on JVM)

### Check Your Kotlin Version

```bash
kotlin -version
kotlinc -version
```

## 📦 Setup

### 1. Install Kotlin

**macOS** (using Homebrew):
```bash
brew install kotlin
```

**Linux** (using SDKMAN):
```bash
curl -s "https://get.sdkman.io" | bash
sdk install kotlin
```

**Windows**:
- Download from [kotlinlang.org](https://kotlinlang.org/docs/command-line.html)
- Or use IntelliJ IDEA which includes Kotlin

### 2. Install JDK (if not already installed)

```bash
# macOS
brew install openjdk@17

# Ubuntu/Debian
sudo apt install openjdk-17-jdk
```

### 3. Verify Installation

```bash
kotlin -version  # Kotlin version
java -version    # Java version (should be 11+)
```

## 🚀 Running Solutions

### Compile and Run

```bash
# Navigate to solution directory
cd solutions/kotlin/arrays

# Compile Kotlin file
kotlinc TwoSum.kt -include-runtime -d TwoSum.jar

# Run compiled JAR
java -jar TwoSum.jar
```

### Run as Script (Kotlin 1.6+)

```bash
kotlin TwoSum.kt
```

### Using Kotlin REPL

```bash
# Start REPL
kotlinc-jvm

# In REPL
>>> fun add(a: Int, b: Int) = a + b
>>> add(2, 3)
5
>>> :quit
```

## 🧪 Testing Solutions

### Using Built-in Main Function

Most solutions include a `main()` function with test cases:

```bash
kotlinc TwoSum.kt -include-runtime -d TwoSum.jar
java -jar TwoSum.jar
```

### Using Kotlin Test (JUnit)

**Add to build.gradle.kts**:
```kotlin
dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
}

tasks.test {
    useJUnitPlatform()
}
```

**Create Test File** (`TwoSumTest.kt`):
```kotlin
import kotlin.test.Test
import kotlin.test.assertEquals

class TwoSumTest {
    @Test
    fun `test basic case`() {
        val result = twoSum(intArrayOf(2, 7, 11, 15), 9)
        assertEquals(intArrayOf(0, 1).toList(), result.toList())
    }

    @Test
    fun `test with duplicates`() {
        val result = twoSum(intArrayOf(3, 3), 6)
        assertEquals(intArrayOf(0, 1).toList(), result.toList())
    }
}
```

**Run Tests**:
```bash
./gradlew test
```

## 💡 Code Style

### Kotlin Coding Conventions

All solutions follow [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html).

**Key Conventions**:
- Class names: `PascalCase`
- Function names: `camelCase`
- Constants: `UPPER_SNAKE_CASE`
- Properties: `camelCase`
- Indentation: 4 spaces

### Check Style

**Using ktlint**:

Install:
```bash
brew install ktlint  # macOS
# Or download from GitHub releases
```

Check style:
```bash
ktlint TwoSum.kt
```

Auto-format:
```bash
ktlint -F TwoSum.kt
```

**Using detekt** (static analysis):
```bash
# Add to build.gradle.kts
plugins {
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
}

# Run analysis
./gradlew detekt
```

## 🛠 Recommended Tools

### IDEs

1. **IntelliJ IDEA** (Best for Kotlin)
   - Download: [JetBrains](https://www.jetbrains.com/idea/)
   - Community Edition includes full Kotlin support
   - Created by the makers of Kotlin

2. **Android Studio**
   - Built on IntelliJ IDEA
   - Great for Kotlin development

3. **VS Code** with Kotlin extension
   - Lightweight alternative
   - Install "Kotlin Language" extension

### Build Tools

**Gradle (Kotlin DSL)**:

```kotlin
// build.gradle.kts
plugins {
    kotlin("jvm") version "1.8.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("arrays.TwoSumKt")
}
```

**Maven**:
```xml
<dependencies>
    <dependency>
        <groupId>org.jetbrains.kotlin</groupId>
        <artifactId>kotlin-stdlib</artifactId>
        <version>1.8.0</version>
    </dependency>
</dependencies>
```

## 📖 Learning Resources

### Kotlin Basics
- [Kotlin Official Docs](https://kotlinlang.org/docs/home.html)
- [Kotlin Koans](https://play.kotlinlang.org/koans/overview)
- [Kotlin by Example](https://play.kotlinlang.org/byExample/overview)

### Data Structures in Kotlin
- [Kotlin Collections](https://kotlinlang.org/docs/collections-overview.html)
- [Kotlin Standard Library](https://kotlinlang.org/api/latest/jvm/stdlib/)

### Best Practices
- [Kotlin Style Guide](https://developer.android.com/kotlin/style-guide)
- [Idiomatic Kotlin](https://kotlinlang.org/docs/idioms.html)

## 🎯 Common Patterns

### Collections

```kotlin
// Lists
val list = listOf(1, 2, 3)  // Immutable
val mutableList = mutableListOf(1, 2, 3)  // Mutable
mutableList.add(4)

// Maps
val map = mapOf("a" to 1, "b" to 2)  // Immutable
val mutableMap = mutableMapOf<Int, Int>()  // Mutable
mutableMap[key] = value
mutableMap.getOrDefault(key, defaultValue)

// Sets
val set = setOf(1, 2, 3)  // Immutable
val mutableSet = mutableSetOf<Int>()  // Mutable
mutableSet.add(1)
```

### Iteration

```kotlin
// For loop
for (i in 0 until nums.size) {
    println(nums[i])
}

// For each with index
nums.forEachIndexed { index, value ->
    println("$index: $value")
}

// Range
for (i in 0..10) println(i)          // Inclusive
for (i in 0 until 10) println(i)     // Exclusive
for (i in 10 downTo 0) println(i)    // Descending

// While
var i = 0
while (i < nums.size) {
    println(nums[i++])
}
```

### Functional Programming

```kotlin
// Map
val squared = nums.map { it * it }

// Filter
val evens = nums.filter { it % 2 == 0 }

// Reduce
val sum = nums.reduce { acc, num -> acc + num }

// Fold (with initial value)
val sum = nums.fold(0) { acc, num -> acc + num }

// Find
val found = nums.find { it > 5 }

// Any/All
val hasNegative = nums.any { it < 0 }
val allPositive = nums.all { it > 0 }

// GroupBy
val grouped = nums.groupBy { it % 2 == 0 }
```

### Kotlin-Specific Features

```kotlin
// Null safety
var nullable: String? = null
val length = nullable?.length ?: 0  // Elvis operator

// Safe cast
val num = value as? Int

// When expression (like switch)
when (x) {
    0 -> println("zero")
    1, 2 -> println("one or two")
    in 3..10 -> println("3 to 10")
    else -> println("other")
}

// Data classes
data class Point(val x: Int, val y: Int)
val p1 = Point(1, 2)
val p2 = p1.copy(x = 3)  // Copy with modification

// Extension functions
fun Int.isEven() = this % 2 == 0
println(4.isEven())  // true

// Scope functions
val result = nums.let { arr ->
    arr.filter { it > 0 }
       .map { it * 2 }
}
```

## ⚡ Performance Tips

1. **Use Sequence** for large collections with multiple operations
   ```kotlin
   nums.asSequence()
       .filter { it > 0 }
       .map { it * 2 }
       .toList()
   ```

2. **Inline functions** for higher-order functions
3. **Use primitive arrays** (IntArray, LongArray) instead of Array<Int>
4. **MutableList vs ArrayList**: ArrayList is faster for indexed access
5. **Use `when` instead of multiple `if-else`**

## 🐛 Debugging

### Print Debugging

```kotlin
fun twoSum(nums: IntArray, target: Int): IntArray {
    val seen = mutableMapOf<Int, Int>()
    nums.forEachIndexed { i, num ->
        val complement = target - num
        println("i=$i, num=$num, complement=$complement, seen=$seen")
        seen[complement]?.let { return intArrayOf(it, i) }
        seen[num] = i
    }
    return intArrayOf()
}
```

### IntelliJ Debugger

1. Set breakpoint (click line number gutter)
2. Run > Debug (Shift+F10)
3. Step over (F8), Step into (F7)
4. Evaluate expression (Alt+F8)
5. View variables in debugger window

### Logging

```kotlin
// Use built-in println for simple cases
println("Debug: value = $value")

// For production, use a logging library
import mu.KotlinLogging
private val logger = KotlinLogging.logger {}

logger.info { "Processing: $item" }
logger.debug { "Details: ${item.details}" }
```

## 📝 Solution Template

```kotlin
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

package category

/**
 * Function description.
 *
 * @param param Description
 * @return Description
 */
fun functionName(param: Type): ReturnType {
    // Implementation
}

/**
 * Alternative approach.
 *
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 */
fun functionNameAlt(param: Type): ReturnType {
    // Alternative implementation
}

/**
 * Main function with test cases.
 */
fun main() {
    val testCases = listOf(
        Triple(input1, target1, expected1),
        Triple(input2, target2, expected2)
    )

    println("Testing [Problem Name]:\n")

    testCases.forEachIndexed { index, (input, target, expected) ->
        val result = functionName(input, target)
        val passed = result.contentEquals(expected)
        val status = if (passed) "✓" else "✗"

        println("Test Case ${index + 1}: $status")
        println("  Input: ${input.contentToString()}, target = $target")
        println("  Output: ${result.contentToString()}")
        println("  Expected: ${expected.contentToString()}")
        println()
    }
}
```

## 🔗 Useful Links

- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Kotlin Playground](https://play.kotlinlang.org/)
- [Kotlin Standard Library](https://kotlinlang.org/api/latest/jvm/stdlib/)
- [Kotlin Koans (Interactive Tutorial)](https://play.kotlinlang.org/koans/overview)
- [Awesome Kotlin](https://kotlin.link/)

---

**Happy Coding with Kotlin! 🎯**
