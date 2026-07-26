// Largest Integer With Given Digit Sum
// You are given two non-negative integers n and s.
// Return the largest integer that has at most n digits and whose sum of digits is s. If no such integer exists, return -1.

function largestInteger(n: number, s: number): number {
    let ans = 0;

    // Base Case
    if (9 * n < s) return -1;
    
    for (let i = 0; i < n; i++){
        const dig = Math.min(9,s);
        ans = ans*10 + dig;
        s -= dig;
    }

    return ans;
    
    
};

console.log(largestInteger(2, 19)); // Output: -1
console.log(largestInteger(2, 9)); // Output: 90
console.log(largestInteger(5, 0)); // Output: 0