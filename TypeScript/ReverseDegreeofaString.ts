// Reverse Degree of a String

// Given a string s, calculate its reverse degree.

// The reverse degree is calculated as follows:

// For each character, multiply its position in the reversed alphabet ('a' = 26, 'b' = 25, ..., 'z' = 1) with its position in the string (1-indexed).
// Sum these products for all characters in the string.
// Return the reverse degree of s.

function reverseDegree(s: string): number {
    let reverseDegree = 0;

    for (let i = 0; i < s.length; i++){
        // Reverse letter value × 1-based position
        reverseDegree += (26 - (s.charCodeAt(i) - 97)) * (i + 1);
    }

    return reverseDegree;
    
};

console.log(reverseDegree("abc")); // Output: 148
console.log(reverseDegree("zaza")); // Output: 160
