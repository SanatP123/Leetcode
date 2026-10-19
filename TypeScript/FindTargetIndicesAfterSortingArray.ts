// Find Target Indices After Sorting Array

// You are given a 0-indexed integer array nums and a target element target.

// A target index is an index i such that nums[i] == target.

// Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.

// Constraints:

// 1 <= nums.length <= 100
// 1 <= nums[i], target <= 100


function targetIndices(nums: number[], target: number): number[] {
    nums.sort((a,b) => a - b);
    let res : number[] = [];

    for (let i = 0; i < nums.length; i++){
        if (nums[i] === target){
            res.push(i);
        }
    }

    return res;
    
};

console.log(targetIndices([1,2,5,2,3], 2)); // Output: [1,2]
console.log(targetIndices([1,2,5,2,3], 3)); // Output: [3]
console.log(targetIndices([1,2,5,2,3], 5)); // Output: [4]