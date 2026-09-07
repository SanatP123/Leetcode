// Count Good Cyclic Rotations

// You are given an integer array nums of even length n.
// A cyclic rotation of nums is obtained by choosing a prefix of nums whose length is between 0 and n - 1 (inclusive), and moving it to the end of the array while preserving the order of all elements.
// A cyclic rotation is good if the sum of its first n / 2 elements is strictly greater than the sum of its last n / 2 elements.
// Return the number of cyclic rotations of nums that are good.

// Constraints:
// 2 <= n == nums.length <= 105
// 1 <= nums[i] <= 109
// n is even.

function countGoodRotations(nums: number[]): number {
    const n = nums.length;
    const half = n/2;

    let total = 0;
    // The sum of first n/2 elements
    let windowSum = 0;

    // Calculate total sum and the first half's sum.
    for (let i = 0; i < n; i++){
        total += nums[i];
        if (i < half){
            windowSum += nums[i];
        }
    }

    let count = 0;

    for (let start = 0; start < n; start++){
        // Good rotation if the first half has a larger sum.
        if (windowSum > total - windowSum) count++;

        // Slide the first-half window to the next rotation.
        windowSum += nums[(start + half) % n] - nums[start];
    }

    return count;
    
};

console.log(countGoodRotations([1,2,3,4,5,6])); // Output: 3
console.log(countGoodRotations([1,2,1,2])); // Output: 0