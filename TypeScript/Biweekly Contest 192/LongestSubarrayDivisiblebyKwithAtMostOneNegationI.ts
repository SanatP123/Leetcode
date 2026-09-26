// Longest Subarray Divisible by K with At Most One Negation I

// You are given an integer array nums and an integer k.
// A subarray is valid if its sum is divisible by k, or can become divisible by k by negating one element within that subarray.
// Negating an element means replacing its value x with -x.
// Return the length of the longest valid subarray. If no valid subarray exists, return 0.

// A subarray is a contiguous, non-empty sequence of elements within an array.

// Constraints:

// 1 <= nums.length <= 1000
// -10^5 <= nums[i] <= 10^5
// 1 <= k <= 10^5

function longestSubarray(nums: number[], k: number): number {
    let n = nums.length;

    // Prefix sum array to calculate subarray sums efficiently
    let prefix = new Array(n+1).fill(0);

    for (let i = 1; i <= n; i++){
        prefix[i] = prefix[i-1] + nums[i-1];
    }

    let length = 0;

    for (let l = 0; l < n; l++){
        let numberSet = new Set<number>();
        let sum = 0;

        for (let r = l; r < n; r++){
            sum = prefix[r+1] - prefix[l];
            // No negation
            if ((((sum % k) + k) % k) === 0){
                length = Math.max(length, r - l + 1);
            }

            //  nums[r] can be the element we negate
            numberSet.add((((2 * nums[r]) % k) + k) % k);

            // One negation
            if (numberSet.has(((sum % k) + k) % k)){
                length = Math.max(length, r - l + 1);
            }
        }
    }

        return length;    
}



console.log(longestSubarray([4,1,2], 3)); // Output: 3
console.log(longestSubarray([5,3,4], 7)); // Output: 2
console.log(longestSubarray([2,2,5], 6)); // Output: 2