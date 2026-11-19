function minimizeSum(nums: number[]): number {
    const n = nums.length; 
     // Sort so the extremes are at known positions:
    // the two smallest are at indices 0, 1 and the two largest at n-1, n-2.
    nums.sort((a,b) => a - b);

    // The low score is always driven to 0: the same two changes we use to
    // shrink the range can be set to a duplicate value (difference 0)
    // High score = max - min. With two free changes we neutralize two extremes.

    return Math.min(nums[n-3] - nums[0], // change the two largest
    nums[n-2] - nums[1], // change one on each end
    nums[n-1] - nums[2]); // change the two smallest
};

console.log(minimizeSum([1,4,7,8,5])); // Output: 3
console.log(minimizeSum([1,4,3])); // Output: 0
