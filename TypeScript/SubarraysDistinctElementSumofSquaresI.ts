// Subarrays Distinct Element Sum of Squares I

// You are given a 0-indexed integer array nums.

// The distinct count of a subarray of nums is defined as:

// Let nums[i..j] be a subarray of nums consisting of all the indices from i to j such that 0 <= i <= j < nums.length. Then the number of distinct values in nums[i..j] is called the distinct count of nums[i..j].
// Return the sum of the squares of distinct counts of all subarrays of nums.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Constraints:

// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100

function sumCounts(nums: number[]): number {
    let sumofSquares = 0;

    for (let i = 0; i < nums.length; i++){
        let current = new Set<number>();

        for (let j = i; j < nums.length; j++){
            current.add(nums[j]);
            sumofSquares += (current.size * current.size);      
        }
        
    }

    return sumofSquares;
    
};


console.log(sumCounts([1, 2, 1])); // Output: 15
console.log(sumCounts([1,1])); // Output: 3

