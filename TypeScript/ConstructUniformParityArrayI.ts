// Construct Uniform Parity Array I
// You are given an array nums1 of n distinct integers.

// You want to construct another array nums2 of length n such that the elements in nums2 are either all odd or all even.

// For each index i, you must choose exactly one of the following (in any order):

// nums2[i] = nums1[i]
// nums2[i] = nums1[i] - nums1[j], for an index j != i
// Return true if it is possible to construct such an array, otherwise, return false.

// Constraints:

// 1 <= n == nums1.length <= 100
// 1 <= nums1[i] <= 100
// nums1 consists of distinct integers.

function uniformArray(nums1: number[]): boolean {
    // the number of odd elements in nums1
    let oddCount = 0;

    for (const num of nums1){
        if (num % 2 !== 0){
            oddCount++;
        }
    }

    // Already all even or odds can subtract each other (odd - odd = even) — true. 
    const canBeAllEven = oddCount === 0 || oddCount >= 2;
    
    // Always achievable as long as there's at least one odd (oddCount >= 1). Evens can subtract that odd to become odd; odds keep their value.
    const canBeAllOdd = oddCount >= 1;


    return canBeAllEven || canBeAllOdd;
    
};


console.log(uniformArray([2,3])); // Output: true
console.log(uniformArray([4,6])); // Output: true