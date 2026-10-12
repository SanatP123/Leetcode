// Sum of Squares of Special Elements 

// You are given a 1-indexed integer array nums of length n.

// An element nums[i] of nums is called special if i divides n, i.e. n % i == 0.

// Return the sum of the squares of all special elements of nums.


function sumOfSquares(nums: number[]): number {
    let totalSum = 0;
    let n = nums.length;

    for (let i = 0; i < n; i++){
        if (n % (i+1) === 0){
            totalSum += (nums[i] * nums[i]);
        }
    }

    return totalSum;
    
};

console.log(sumOfSquares([1,2,3,4])); // Output: 21
console.log(sumOfSquares([2,7,1,19,18,3])); // Output: 63