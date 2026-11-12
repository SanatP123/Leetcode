// Longest Strictly Increasing or Strictly Decreasing Subarray

// You are given an array of integers nums. Return the length of the longest subarray of nums which is either strictly increasing or strictly decreasing.


function longestMonotonicSubarray(nums: number[]): number {
    let increasing = 1;
    let decreasing = 1;
    let ans = 1;

    if (nums.length === 1){
        return 1;
    }

    for (let i = 1; i < nums.length; i++){
        if (nums[i-1] < nums[i]){
            decreasing = 1;
            increasing += 1;
        }
        else if (nums[i-1] > nums[i]){
            increasing = 1;
            decreasing += 1;
        }
        else{
            increasing = 1;
            decreasing = 1;
        }

        ans = Math.max(ans, increasing, decreasing);

    }

    return ans;
    
};

console.log(longestMonotonicSubarray([1,4,3,3,2])); // Output: 2
console.log(longestMonotonicSubarray([3,3,3,3])); // Output: 1
console.log(longestMonotonicSubarray([3,2,1])); // Output: 3