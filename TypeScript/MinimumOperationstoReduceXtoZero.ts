// Minimum Operations to Reduce X to Zero

// You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

// Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

function minOperations(nums: number[], x: number): number {
    let total = 0;

    for (const num of nums){
        total += num;
    
    }
    let n = nums.length;

    // If the total sum is smaller than x, it is impossible.
    if (total < x) return -1;

    let target = total - x;

    // If target is 0, we need to remove every element.
    if (target === 0) return n;

    let left = 0;
    let current = 0;
    let maxLen = -1;

    for (let right = 0; right < n; right++){
        current += nums[right]

        // Shrink the window while its sum is too large.
        while (current > target && left < n){
            current -= nums[left];
            left++;
        }
        if (current === target){
            maxLen = Math.max(maxLen, right - left + 1);
        }
    }

    // Removing everything outside the longest valid subarray gives the minimum number of operations.
    return maxLen === -1 ? -1 : n - maxLen;
};


console.log(minOperations([1, 1, 4, 2, 3], 5)); // Output: 2
console.log(minOperations([5, 6, 7, 8, 9], 4)); // Output: -1
console.log(minOperations([3, 2, 20, 1, 1, 3], 10)); // Output: 5