// Maximize Sum of Squares of Digits

// You are given two positive integers num and sum.

// A positive integer n is good if it satisfies both of the following:

// The number of digits in n is exactly num.
// The sum of digits in n is exactly sum.
// The score of a good integer n is the sum of the squares of digits in n.

// Return a string denoting the good integer n that achieves the maximum score. If there are multiple possible integers, return the maximum ​​​​​​​one. If no such integer exists, return an empty string.

// Constraints:

// 1 <= num <= 2 * 10^5
// 1 <= sum <= 2 * 10^6

function maxSumOfSquares(num: number, sum: number): string {

    // If the sum exceeds the maximum possible digit sum, no valid number exists.
    if (sum > num * 9){
        return "";
    }

    // If sum is less than 1, no valid positive integer can be constructed.
    if (sum < 1){
        return "";
    }

    let result : string = "";
    let remaining : number = sum;

    for (let i = 0; i < num; i++){
        // Choose the largest possible digit without exceeding 9 or the sum that remains.
        let digit : number = Math.min(9, remaining);
        result += digit.toString();
        remaining -= digit;
    }

    return result;
    
};


console.log(maxSumOfSquares(2, 3)); // Output: "30"
console.log(maxSumOfSquares(2, 17)); // Output: "99"
console.log(maxSumOfSquares(1, 10)); // Output: ""

