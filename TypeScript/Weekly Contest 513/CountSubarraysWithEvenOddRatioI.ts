// Count Subarrays With Even Odd Ratio I

// You are given an integer array nums and two integers a and b.

// For a subarray, let:

// x be the number of even elements.
// y be the number of odd elements.
// The ratio of even to odd elements in a subarray is defined as x / y, where ratios are compared by their exact rational values.

// A subarray is considered valid if:

// y > 0, and
// x / y <= a / b.
// Return the number of valid subarrays in nums.

function countRatioSubarrays(nums: number[], a: number, b: number): number {
    // Prefix count of even numbers
    const numberOfEven = new Array(nums.length + 1).fill(0);
    
    for (let i = 0; i < nums.length; i++){
        numberOfEven[i + 1] = numberOfEven[i] + (nums[i] % 2 === 0 ? 1 : 0);
    }

    let ans = 0;

    // Check every subarray
    for (let i = 0; i < nums.length; i++){
        for (let j = i; j < nums.length; j++){
            let length = j - i + 1;
            let even = numberOfEven[j+1] - numberOfEven[i];
            let odd = length - even;

            // Compare ratios using integer arithmetic
            if (odd > 0 && even * b  <= odd * a){
                ans += 1;
            }
        }
    }

    return ans;
};


console.log(countRatioSubarrays([1,2,1,2], 3, 2)); // Output: 7
console.log(countRatioSubarrays([2,2,1], 2, 1)); // Output: 3   
console.log(countRatioSubarrays([2,2,2], 1, 1)); // Output: 0