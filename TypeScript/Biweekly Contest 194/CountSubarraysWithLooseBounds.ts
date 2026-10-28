// Count Subarrays With Loose Bounds

// You are given an integer array nums and two integers minK and maxK.

// A loose-bound subarray is a subarray in which every element is greater than or equal to minK and less than or equal to maxK.

// Return the number of loose-bound subarrays in nums.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Constraints:

// 2 <= nums.length <= 10**5
// 1 <= nums[i], minK, maxK <= 10**6

function countSubarrays(nums: number[], minK: number, maxK: number): number {
    let numberOfLooseBound = 0;
    let left = 0;
    const n = nums.length;


    for (let right = 0; right < n; right++){
        if (nums[right] < minK || nums[right] > maxK){
            left = right + 1;
        }
        numberOfLooseBound += (right - left + 1)
    }

    return numberOfLooseBound;
};

console.log(countSubarrays([1,4,7,3], 1, 5)); // Output: 4
console.log(countSubarrays([1,1], 1, 1)); // Output: 3