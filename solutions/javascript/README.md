# JavaScript Solutions

DSA practice solutions implemented in JavaScript (Node.js).

## 📦 Requirements

- **Node.js Version**: 16.x or higher (LTS recommended)
- **JavaScript**: ES6+ (ES2015 and later)

### Check Your Node.js Version

```bash
node --version
npm --version
```

## 🚀 Setup

### 1. Install Node.js

**macOS** (using Homebrew):
```bash
brew install node
```

**Linux** (Ubuntu/Debian):
```bash
curl -fsSL https://deb.nodesource.com/setup_18.x | sudo -E bash -
sudo apt-get install -y nodejs
```

**Windows**:
Download from [nodejs.org](https://nodejs.org/)

Or use **nvm** (Node Version Manager):
```bash
# Install nvm
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash

# Install Node
nvm install 18
nvm use 18
```

### 2. Verify Installation

```bash
node --version   # Should show v16.x.x or higher
npm --version    # Should show 8.x.x or higher
```

## 🏃 Running Solutions

### Run with Node.js

```bash
# Navigate to solution directory
cd solutions/javascript/arrays

# Run a solution
node twoSum.js
```

### Run in Browser Console

```javascript
// Copy solution function to browser console
function twoSum(nums, target) {
    // ... implementation
}

const result = twoSum([2, 7, 11, 15], 9);
console.log(result); // [0, 1]
```

### Using ES Modules

**Enable ES Modules** (`package.json`):
```json
{
  "type": "module"
}
```

**Import/Export**:
```javascript
// twoSum.js
export function twoSum(nums, target) {
    // ...
}

// test.js
import { twoSum } from './twoSum.js';
```

## 🧪 Testing Solutions

### Using Built-in Tests

Most solutions include tests in the main execution block:

```bash
node twoSum.js
```

### Using Jest (Recommended)

**Install Jest**:
```bash
npm install --save-dev jest
```

**Create Test File** (`twoSum.test.js`):
```javascript
const { twoSum } = require('./twoSum');

describe('Two Sum', () => {
    test('basic case', () => {
        expect(twoSum([2, 7, 11, 15], 9)).toEqual([0, 1]);
    });

    test('duplicates', () => {
        expect(twoSum([3, 3], 6)).toEqual([0, 1]);
    });

    test('negative numbers', () => {
        expect(twoSum([-1, -2, -3, -4, -5], -8)).toEqual([2, 4]);
    });
});
```

**Update `package.json`**:
```json
{
  "scripts": {
    "test": "jest"
  }
}
```

**Run Tests**:
```bash
npm test
```

### Using Mocha/Chai

```bash
npm install --save-dev mocha chai
```

## 💡 Code Style

### ESLint Configuration

**Install ESLint**:
```bash
npm install --save-dev eslint
npx eslint --init
```

**Recommended Config** (`.eslintrc.json`):
```json
{
  "extends": "airbnb-base",
  "env": {
    "node": true,
    "es2021": true
  },
  "rules": {
    "no-console": "off"
  }
}
```

**Run Linter**:
```bash
npx eslint twoSum.js
```

### Prettier (Auto-formatting)

**Install Prettier**:
```bash
npm install --save-dev prettier
```

**Config** (`.prettierrc`):
```json
{
  "semi": true,
  "trailingComma": "es5",
  "singleQuote": true,
  "printWidth": 80,
  "tabWidth": 2
}
```

**Format Code**:
```bash
npx prettier --write twoSum.js
```

## 🛠 Recommended Tools

### IDEs

1. **VS Code** (Highly Recommended)
   - Install: ESLint, Prettier extensions
   - Integrated debugging
   - IntelliSense for JavaScript

2. **WebStorm**
   - JetBrains IDE
   - Excellent for full-stack JS

3. **Sublime Text** with JSHint

### Package Managers

- **npm** (default with Node.js)
- **yarn** (faster alternative)
  ```bash
  npm install -g yarn
  ```
- **pnpm** (disk space efficient)
  ```bash
  npm install -g pnpm
  ```

## 📖 Learning Resources

### JavaScript Fundamentals
- [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
- [JavaScript.info](https://javascript.info/)
- [Eloquent JavaScript](https://eloquentjavascript.net/)

### Modern JavaScript
- [ES6 Features](http://es6-features.org/)
- [You Don't Know JS](https://github.com/getify/You-Dont-Know-JS)

### Data Structures in JavaScript
- [Data Structures in JavaScript](https://www.freecodecamp.org/news/data-structures-in-javascript/)
- [Algorithms in JavaScript](https://github.com/trekhleb/javascript-algorithms)

## 🎯 Common Patterns

### Array Methods

```javascript
// Iteration
nums.forEach((num, index) => console.log(num));

// Map (transform)
const squared = nums.map(x => x * x);

// Filter
const evens = nums.filter(x => x % 2 === 0);

// Reduce
const sum = nums.reduce((acc, x) => acc + x, 0);

// Find
const found = nums.find(x => x > 5);

// Some/Every
const hasNegative = nums.some(x => x < 0);
const allPositive = nums.every(x => x > 0);
```

### Useful Data Structures

```javascript
// Map (Hash Map)
const map = new Map();
map.set(key, value);
map.get(key);
map.has(key);
map.delete(key);

// Set
const set = new Set();
set.add(value);
set.has(value);
set.delete(value);

// Object as HashMap
const obj = {};
obj[key] = value;
key in obj;

// Array as Stack
const stack = [];
stack.push(1);
stack.pop();

// Array as Queue (inefficient)
const queue = [];
queue.push(1);
queue.shift(); // O(n) - use deque library for O(1)
```

### Modern Syntax

```javascript
// Destructuring
const [first, second] = nums;
const { name, age } = person;

// Spread operator
const combined = [...arr1, ...arr2];
const copy = [...original];

// Rest parameters
function sum(...numbers) {
    return numbers.reduce((a, b) => a + b, 0);
}

// Arrow functions
const double = x => x * 2;
const add = (a, b) => a + b;

// Template literals
const message = `Result: ${result}`;

// Optional chaining
const value = obj?.property?.nested;

// Nullish coalescing
const value = input ?? defaultValue;
```

## ⚡ Performance Tips

1. **Use Map/Set** instead of objects for frequent lookups
2. **Avoid `delete` operator** on objects (slow)
3. **Use `for...of`** instead of `forEach` for better performance
4. **Avoid array methods in hot loops** (use traditional for loops)
5. **Use TypedArrays** for numerical computations
6. **Memoization** for expensive recursive calls

## 🐛 Debugging

### Console Methods

```javascript
console.log('Basic logging');
console.table([{a: 1}, {a: 2}]);  // Table format
console.time('label');            // Start timer
console.timeEnd('label');         // End timer
console.trace();                  // Stack trace
```

### VS Code Debugging

**Create `launch.json`**:
```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "node",
      "request": "launch",
      "name": "Debug Current File",
      "skipFiles": ["<node_internals>/**"],
      "program": "${file}"
    }
  ]
}
```

**Debug**:
1. Set breakpoints (click line number)
2. Press F5
3. Step through with F10/F11

### Node.js Debugger

```bash
# Run with inspect flag
node inspect twoSum.js

# Or use Chrome DevTools
node --inspect-brk twoSum.js
# Open chrome://inspect in Chrome
```

## 📝 Solution Template

```javascript
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

/**
 * Function description.
 *
 * @param {Type} param - Description
 * @return {Type} - Description
 *
 * @example
 * functionName(input) // returns output
 */
function functionName(param) {
    // Implementation
}

// Alternative approach
function functionNameAlt(param) {
    // Alternative implementation
}

// Test cases
if (require.main === module) {
    const testCases = [
        [input1, expected1],
        [input2, expected2]
    ];

    console.log('Testing [Problem Name]:\n');

    testCases.forEach(([input, expected], index) => {
        const result = functionName(input);
        const passed = JSON.stringify(result) === JSON.stringify(expected);
        const status = passed ? '✓' : '✗';

        console.log(`Test Case ${index + 1}: ${status}`);
        console.log(`  Input: ${JSON.stringify(input)}`);
        console.log(`  Output: ${JSON.stringify(result)}`);
        console.log(`  Expected: ${JSON.stringify(expected)}\n`);
    });
}

// Export for use in other modules
module.exports = { functionName, functionNameAlt };
```

## 🔗 Useful Links

- [Node.js Documentation](https://nodejs.org/docs/)
- [MDN JavaScript Reference](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference)
- [npm Registry](https://www.npmjs.com/)
- [JavaScript Algorithms](https://github.com/trekhleb/javascript-algorithms)
- [Node.js Best Practices](https://github.com/goldbergyoni/nodebestpractices)

---

**Happy Coding with JavaScript! 🚀**
