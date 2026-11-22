// Count Dominant Elements

// You are given an integer array nums.

// An element in nums is called dominant if it is greater than or equal to the average of its immediate neighbors.

// The immediate neighbors of nums[i] are nums[i - 1] and nums[i + 1], when those indices exist.

// A single element with no neighbors is considered dominant.

// Return the number of dominant elements in nums.

function countDominantElements(nums: number[]): number {
    let dominant = 0;
    const n = nums.length;

    if (n == 1){
        return 1;
    }

    for (let i = 0; i < n; i++){
        if (i === 0 && nums[i] >= nums[i+1]){
            dominant += 1;
        }
        if (i === n-1 && nums[i] >= nums[i-1]){
            dominant += 1;
        }
        if (nums[i] >= (nums[i+1] + nums[i-1]) / 2){
            dominant += 1;
        }
    }

    return dominant;
    
};

console.log(countDominantElements([1, 10, 2])); // Output: 1
console.log(countDominantElements([6,4,2])); // Output: 2
console.log(countDominantElements([7])); // Output: 1