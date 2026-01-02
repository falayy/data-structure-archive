# Go Solutions

DSA practice solutions implemented in Go (Golang).

## 🔵 Requirements

- **Go Version**: 1.19 or higher
- **Module Support**: Go modules enabled

### Check Your Go Version

```bash
go version
```

## 📦 Setup

### 1. Install Go

**macOS** (using Homebrew):
```bash
brew install go
```

**Linux**:
```bash
# Download and install
wget https://go.dev/dl/go1.21.0.linux-amd64.tar.gz
sudo tar -C /usr/local -xzf go1.21.0.linux-amd64.tar.gz

# Add to PATH (add to ~/.bashrc or ~/.zshrc)
export PATH=$PATH:/usr/local/go/bin
```

**Windows**:
Download installer from [go.dev](https://go.dev/dl/)

### 2. Setup Go Workspace

```bash
# Set GOPATH (usually ~/go)
export GOPATH=$HOME/go
export PATH=$PATH:$GOPATH/bin

# Verify
go env GOPATH
```

### 3. Verify Installation

```bash
go version  # Should show 1.19 or higher
```

## 🚀 Running Solutions

### Run Directly

```bash
# Navigate to solution directory
cd solutions/go/arrays

# Run without compilation
go run two_sum.go
```

### Build and Run

```bash
# Build executable
go build two_sum.go

# Run executable
./two_sum

# Or in one command
go build -o two_sum two_sum.go && ./two_sum
```

### Using Go Modules

```bash
# Initialize module (if not already)
go mod init dsa-practice

# Run with module
go run .
```

## 🧪 Testing Solutions

### Using Built-in Main Function

Most solutions include a `main()` function:

```bash
go run two_sum.go
```

### Using Go Testing Framework

**Create Test File** (`two_sum_test.go`):

```go
package arrays

import (
    "reflect"
    "testing"
)

func TestTwoSum(t *testing.T) {
    tests := []struct {
        name     string
        nums     []int
        target   int
        expected []int
    }{
        {"basic case", []int{2, 7, 11, 15}, 9, []int{0, 1}},
        {"duplicates", []int{3, 3}, 6, []int{0, 1}},
        {"negatives", []int{-1, -2, -3, -4, -5}, -8, []int{2, 4}},
    }

    for _, tt := range tests {
        t.Run(tt.name, func(t *testing.T) {
            result := TwoSum(tt.nums, tt.target)
            if !reflect.DeepEqual(result, tt.expected) {
                t.Errorf("TwoSum(%v, %d) = %v; want %v",
                    tt.nums, tt.target, result, tt.expected)
            }
        })
    }
}

func BenchmarkTwoSum(b *testing.B) {
    nums := make([]int, 10000)
    for i := range nums {
        nums[i] = i
    }
    target := 19997

    b.ResetTimer()
    for i := 0; i < b.N; i++ {
        TwoSum(nums, target)
    }
}
```

**Run Tests**:
```bash
go test                      # Run all tests
go test -v                   # Verbose output
go test -run TestTwoSum      # Run specific test
go test -bench=.             # Run benchmarks
go test -cover               # Show coverage
```

## 💡 Code Style

### Go Conventions

All solutions follow [Effective Go](https://golang.org/doc/effective_go.html) guidelines.

**Key Conventions**:
- File names: `snake_case`
- Function names:
  - Exported (public): `PascalCase`
  - Unexported (private): `camelCase`
- Constants: `PascalCase` or `camelCase`
- Package names: lowercase, single word

### Format Code

Go has built-in formatting:

```bash
# Format single file
gofmt -w two_sum.go

# Format all files in directory
gofmt -w .

# Or use go fmt
go fmt ./...
```

### Linting

**Install golint**:
```bash
go install golang.org/x/lint/golint@latest
```

**Run linter**:
```bash
golint two_sum.go

# Or use go vet (included with Go)
go vet two_sum.go

# Use staticcheck (comprehensive)
go install honnef.co/go/tools/cmd/staticcheck@latest
staticcheck ./...
```

## 🛠 Recommended Tools

### IDEs

1. **GoLand** (JetBrains)
   - Best IDE for Go
   - 30-day free trial, then paid

2. **VS Code** with Go extension
   - Install "Go" extension by Go Team at Google
   - Free and excellent Go support
   - Integrated debugging

3. **Vim/Neovim** with vim-go
   - For terminal enthusiasts

### Useful Tools

```bash
# Code generation
go install github.com/fatih/gomodifytags@latest

# Automatic import management
go install golang.org/x/tools/cmd/goimports@latest

# Debugger
go install github.com/go-delve/delve/cmd/dlv@latest
```

## 📖 Learning Resources

### Go Basics
- [Go Tour](https://go.dev/tour/) - Interactive tutorial
- [Go by Example](https://gobyexample.com/) - Hands-on examples
- [Effective Go](https://golang.org/doc/effective_go.html) - Best practices

### Data Structures in Go
- [Go Standard Library](https://pkg.go.dev/std)
- [Go Data Structures](https://yourbasic.org/golang/)

### Advanced Topics
- [Go Concurrency Patterns](https://go.dev/blog/pipelines)
- [Go Memory Model](https://go.dev/ref/mem)

## 🎯 Common Patterns

### Slices (Dynamic Arrays)

```go
// Create slice
nums := []int{1, 2, 3}
nums := make([]int, length)
nums := make([]int, length, capacity)

// Append
nums = append(nums, 4)

// Slice operations
sub := nums[1:3]        // [start:end] exclusive end
sub := nums[:3]         // First 3 elements
sub := nums[2:]         // From index 2 to end
sub := nums[:]          // Copy entire slice

// Length and capacity
len(nums)
cap(nums)

// Iterate
for i, num := range nums {
    fmt.Println(i, num)
}

// Iterate without index
for _, num := range nums {
    fmt.Println(num)
}
```

### Maps (Hash Tables)

```go
// Create map
m := make(map[int]int)
m := map[string]int{"a": 1, "b": 2}

// Set value
m[key] = value

// Get value
value := m[key]              // Returns zero value if not found
value, ok := m[key]          // Check existence

// Delete
delete(m, key)

// Iterate
for key, value := range m {
    fmt.Println(key, value)
}
```

### Common Data Structures

```go
// Stack (using slice)
stack := []int{}
stack = append(stack, 1)     // Push
top := stack[len(stack)-1]   // Peek
stack = stack[:len(stack)-1] // Pop

// Queue (using slice - not efficient)
queue := []int{}
queue = append(queue, 1)     // Enqueue
front := queue[0]            // Peek
queue = queue[1:]            // Dequeue (O(n)!)

// Set (using map)
set := make(map[int]bool)
set[1] = true                // Add
delete(set, 1)               // Remove
_, exists := set[1]          // Check existence

// Priority Queue (use container/heap)
import "container/heap"
// Implement heap.Interface
```

### Error Handling

```go
// Return error
func divide(a, b int) (int, error) {
    if b == 0 {
        return 0, fmt.Errorf("division by zero")
    }
    return a / b, nil
}

// Check error
result, err := divide(10, 0)
if err != nil {
    log.Fatal(err)
}

// Custom error
type MyError struct {
    msg string
}

func (e *MyError) Error() string {
    return e.msg
}
```

## ⚡ Performance Tips

1. **Preallocate slices** when size is known
   ```go
   nums := make([]int, 0, capacity)  // Avoid reallocation
   ```

2. **Use pointers for large structs** to avoid copying
3. **Use `sync.Map`** for concurrent map access
4. **Buffer channels** to avoid blocking
5. **Use `strings.Builder`** for string concatenation
6. **Profile with pprof** to find bottlenecks

### Profiling

```go
import _ "net/http/pprof"

// Run and visit http://localhost:6060/debug/pprof/
go func() {
    log.Println(http.ListenAndServe("localhost:6060", nil))
}()
```

## 🐛 Debugging

### Print Debugging

```go
func TwoSum(nums []int, target int) []int {
    seen := make(map[int]int)
    for i, num := range nums {
        complement := target - num
        fmt.Printf("i=%d, num=%d, complement=%d, seen=%v\n",
            i, num, complement, seen)
        if j, found := seen[complement]; found {
            return []int{j, i}
        }
        seen[num] = i
    }
    return []int{}
}
```

### Using Delve Debugger

```bash
# Install delve
go install github.com/go-delve/delve/cmd/dlv@latest

# Debug
dlv debug two_sum.go

# In dlv
(dlv) break main.main
(dlv) continue
(dlv) print nums
(dlv) next
(dlv) step
```

### VS Code Debugging

Create `.vscode/launch.json`:
```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "name": "Launch Package",
            "type": "go",
            "request": "launch",
            "mode": "debug",
            "program": "${fileDirname}"
        }
    ]
}
```

## 📝 Solution Template

```go
/*
Problem: [Problem Name]
Source: [URL]
Difficulty: Easy/Medium/Hard
Category: [Category]

Brief description.

Time Complexity: O(?)
Space Complexity: O(?)
*/

package category

import (
    "fmt"
)

// FunctionName solves the problem.
//
// Approach description.
//
// Time: O(?), Space: O(?)
func FunctionName(param Type) ReturnType {
    // Implementation
    return result
}

// FunctionNameAlt is an alternative approach.
//
// Time: O(?), Space: O(?)
func FunctionNameAlt(param Type) ReturnType {
    // Alternative implementation
    return result
}

// Example usage and tests
func main() {
    testCases := []struct {
        input    Type
        target   int
        expected ReturnType
    }{
        {input1, target1, expected1},
        {input2, target2, expected2},
    }

    fmt.Println("Testing [Problem Name]:\n")

    for i, tc := range testCases {
        result := FunctionName(tc.input, tc.target)
        passed := reflect.DeepEqual(result, tc.expected)

        status := "✓"
        if !passed {
            status = "✗"
        }

        fmt.Printf("Test Case %d: %s\n", i+1, status)
        fmt.Printf("  Input: %v, target = %d\n", tc.input, tc.target)
        fmt.Printf("  Output: %v\n", result)
        fmt.Printf("  Expected: %v\n\n", tc.expected)
    }
}
```

## 🔗 Useful Links

- [Go Official Website](https://go.dev/)
- [Go Documentation](https://go.dev/doc/)
- [Go Playground](https://go.dev/play/)
- [Go Standard Library](https://pkg.go.dev/std)
- [Awesome Go](https://awesome-go.com/)
- [Go by Example](https://gobyexample.com/)

---

**Happy Coding with Go! 🔵**
