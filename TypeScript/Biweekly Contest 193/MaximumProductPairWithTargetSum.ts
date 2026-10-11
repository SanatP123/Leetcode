// Maximum Product Pair With Target Sum

// You are given an integer array nums and an integer target.

// A pair of distinct indices (i, j) is valid if:

// nums[i] + nums[j] == target
// nums[i] > nums[j]
// Return a valid pair [i, j] whose product nums[i] * nums[j] is maximum among all valid pairs. If no valid pair exists, return [-1, -1].

// If multiple valid pairs achieve the maximum product, you may return any of them.

function maxProductPair(nums: number[], target: number): number[] {
    let maxProduct = -Infinity;
    let res = [-1,-1];

    for (let i = 0; i < nums.length; i++){
        for (let j = 0; j < nums.length; j++){
            if (nums[i] > nums[j] && nums[i] + nums[j] === target){
                let product = nums[i] * nums[j];
                if (product > maxProduct){
                    maxProduct = product;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
    }

    return res;
    
};

console.log(maxProductPair([1,2,3,4,], 5)); // Output: [2,1]
console.log(maxProductPair([-3,-1,4,2], 1)); // Output: [3,1] 
console.log(maxProductPair([3,3,5], 6)); // Output: [-1,-1]