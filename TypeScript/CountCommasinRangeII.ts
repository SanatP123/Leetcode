// Count Commas in Range

// You are given an integer n.
// Return the total number of commas used when writing all integers from [1, n] (inclusive) in standard number formatting.
// In standard formatting:
// A comma is inserted after every three digits from the right.
// Numbers with fewer than 4 digits contain no commas.

// Contraints:
// 1 <= n <= 10^15


function countCommas(n: number): number {
    let count = 0;
    let p = 1000;

    while (p <= n){
        count += n - p + 1;
        p *= 1000;
    }
    return count;
};


console.log(countCommas(1002)); // Output: 3
console.log(countCommas(998)); // Output: 0
console.log(countCommas(100000)); // Output: 99001