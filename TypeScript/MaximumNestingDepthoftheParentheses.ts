// Maximum Nesting Depth of the Parentheses

// Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

// Constraints:
// 1 <= s.length <= 100
// s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
// It is guaranteed that parentheses expression s is a VPS.

function maxDepth(s: string): number {
    let maximumNested = 0;
    let openBraces = 0;
    let closedBraces = 0;

    for (let i = 0; i < s.length; i++){
        if (s[i] === '('){
            openBraces += 1;
        }
        else if (s[i] === ')'){
            closedBraces += 1;
        }
        maximumNested = Math.max(maximumNested, openBraces - closedBraces);
    }

    return maximumNested;
};


console.log(maxDepth("(1+(2*3)+((8)/4))+1")); // Output: 3
console.log(maxDepth("(1)+((2))+(((3)))")); // Output: 3
console.log(maxDepth("()(())((()()))")); // Output: 3
console.log(maxDepth("1")); // Output: 0