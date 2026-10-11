// Longest Resilient Subarray I

// You are given an integer array nums and an integer k.

// A subarray is resilient if, for every position in it, deleting the element at that position leaves the remaining elements with a sum divisible by k.

// For a subarray of length 1, the remaining sum is 0, which is divisible by k.

// Return the length of the longest resilient subarray.

function resilientSubarray(nums: number[], k: number): number {
    let length = 1;

    for (let i = 0; i < nums.length; i++){
        let sum = 0;

        let remainder = ((nums[i] % k) + k) % k;

        for (let j = i; j < nums.length; j++){
            let current = ((nums[j] % k) + k) % k;

            if (current !== remainder){
                break;
            }

            sum += nums[j];

            if (((sum % k) + k) % k == remainder){
                length = Math.max(length, j - i + 1);
            }
        }
        
    }

    return length;
    
};

console.log(resilientSubarray([2,4,6,3], 2)); // Output: 3
console.log(resilientSubarray([1,4,7,1], 3)); // Output: 4
console.log(resilientSubarray([5,5,4,8], 4)); // Output: 2