// Construct Uniform Parity Array II

// You are given an array nums1 of n distinct integers.

// You want to construct another array nums2 of length n such that the elements in nums2 are either all odd or all even.

// For each index i, you must choose exactly one of the following (in any order):

// nums2[i] = nums1[i]​​​​​​​
// nums2[i] = nums1[i] - nums1[j], for an index j != i, such that nums1[i] - nums1[j] >= 1
// Return true if it is possible to construct such an array, otherwise return false.


function uniformArray(nums1: number[]): boolean {
    let minOdd = Infinity;
    let minEven = Infinity;

    for (const num of nums1){
        if (num % 2 === 0){
            minEven = Math.min(minEven, num);
        }
        else{
            minOdd = Math.min(minOdd, num);
        }
    }

    // Already all the same parity (All even or all odd)
    if (minOdd === Infinity || minEven === Infinity){
        return true;
    }

    // Every even must be able to subtract the smallest odd
    return minEven > minOdd;
};

console.log(uniformArray([1,4,7])) // Output: true
console.log(uniformArray([2,3])); // Output: false
console.log(uniformArray([4,6])); // Output: true
