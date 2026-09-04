// Smallest Stable Index I

// You are given an integer array nums of length n and an integer k.

// For each index i, define its instability score as max(nums[0..i]) - min(nums[i..n - 1]).

// In other words:

// max(nums[0..i]) is the largest value among the elements from index 0 to index i.
// min(nums[i..n - 1]) is the smallest value among the elements from index i to index n - 1.
// An index i is called stable if its instability score is less than or equal to k.

// Return the smallest stable index. If no such index exists, return -1.

function firstStableIndex(nums: number[], k: number): number {
    const n = nums.length;

    // Minimum value from i to the end
    let suffixMin : number[] = new Array(n).fill(0);
    suffixMin[n - 1] = nums[n-1];

    for (let i = n-2; i >= 0; i--){
        suffixMin[i] = Math.min(suffixMin[i+1], nums[i]);
    }

    let currentMax = nums[0];
    
    for (let i = 0; i < n; i++){
        currentMax = Math.max(currentMax, nums[i]);

        if (currentMax - suffixMin[i] <= k){
            return i;
        }
    } 

    return -1;
    
};


console.log(firstStableIndex([5,0,1,4], 3)); // Output: 3
console.log(firstStableIndex([3,2,1], 1)); // Output: -1
console.log(firstStableIndex([0], 0)); // Output: 0