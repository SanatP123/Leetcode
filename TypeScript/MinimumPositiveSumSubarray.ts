// Minimum Positive Sum Subarray 

// You are given an integer array nums and two integers l and r. Your task is to find the minimum sum of a subarray whose size is between l and r (inclusive) and whose sum is greater than 0.

// Return the minimum sum of such a subarray. If no such subarray exists, return -1.

// A subarray is a contiguous non-empty sequence of elements within an array.


function minimumSumSubarray(nums: number[], l: number, r: number): number {

    let ans = Infinity;
    for (let i = 0; i < nums.length; i++){
        for (let j = i; j < nums.length; j++){
            let sub = nums.slice(i, j+1);

            if (sub.length >= l && sub.length <= r){
                let sum = 0;
                sub.forEach((el) => sum += el);
                if (sum > 0){
                    ans = Math.min(ans, sum);
                }
            }
        }
    }

    return ans !== Infinity ? ans : -1;
    
};


console.log(minimumSumSubarray([3, -2, 1, 4], 2, 3)); // Output: 1
console.log(minimumSumSubarray([-2, 2, -3, 1], 2, 3)); // Output: -1    
console.log(minimumSumSubarray([1, 2, 3, 4], 2, 4)); // Output: 3