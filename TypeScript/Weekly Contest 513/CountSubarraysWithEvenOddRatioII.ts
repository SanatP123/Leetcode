// Count Subarrays With Even Odd Ratio II

// You are given an integer array nums and two integers a and b.

// For a subarray, let:

// x be the number of even elements.
// y be the number of odd elements.
// The ratio of even to odd elements in a subarray is defined as x / y, where ratios are compared by their exact rational values.

// A subarray is considered valid if:

// y > 0, and
// x / y <= a / b.
// Return the number of valid subarrays in nums.

// Constraints:

// 1 <= nums.length <= 10**5
// 1 <= nums[i] <= 10**9
// 1 <= a, b <= 10**9​​​​​​​


function countRatioSubarrays(nums: number[], a: number, b: number): number {

      // Transform: even -> +b, odd -> -a
    for(let i = 0; i < nums.length; i++){
        if (nums[i] % 2 === 0){
            nums[i] = b;
        }
        else{
            nums[i] = -a;
        }
    }
    
    // Prefix sums of transformed array
    const pref = new Array(nums.length + 1).fill(0);

    for (let i = 0; i < nums.length; i++){
        pref[i+1] += pref[i] + nums[i];
    }

    const sorted: number[] = [];
    let answer = 0;

    for (const current of pref) {
        const index = lowerBound(sorted, current);

        // All values from index onward are >= current.
        answer += sorted.length - index;

        // Insert current while preserving sorted order.
        sorted.splice(index, 0, current);
    }

    return answer;
};

function lowerBound(nums : number[], target : number) : number{
    let left = 0;
    let right = nums.length;

    while (left < right){
        let mid = Math.floor((left + right)/2);

        if (nums[mid] < target){
            left = mid + 1;
        }
        else{
            right = mid;
        }
    }
    return left;
}

console.log(countRatioSubarrays([1,2,1,2], 3, 2)); // Output: 7
console.log(countRatioSubarrays([2,2,1], 2, 1)); // Output: 3   
console.log(countRatioSubarrays([2,2,2], 1, 1)); // Output: 0