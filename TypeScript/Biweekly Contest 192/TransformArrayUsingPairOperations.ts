// Transform Array Using Pair Operations

// You are given two integer arrays source and target.

// In one operation, you may choose two distinct indices i and j in source, along with any integer delta. Then update source as follows:

// source[i] = source[i] + source[j] - delta
// source[j] = delta
// Return true if it is possible to make source equal to target after performing the operation any (including zero) number of times. Otherwise, return false.

// Constraints:

// 2 <= source.length == target.length <= 10^5
// -10^9 <= source[i], target[i] <= 10^9

function canTransform(source: number[], target: number[]): boolean {

    if (source.length != target.length){
        return false;
    }

    if (source.length === 1){
        return source[0] === target[0];
    }

    let sourceSum = 0;
    let targetSum = 0;
    
    for (const s of source){
        sourceSum += s;
    }

    for (const t of target){
        targetSum += t;
    }

    // Compare total sums as sum stays the same regardless of delta
    return sourceSum === targetSum;
};

console.log(canTransform([1,2,3], [0,2,4])); // Output: true
console.log(canTransform([-5,-5], [-15,5])); // Output: true
console.log(canTransform([1,2,1], [0,2,5])); // Output: false