// Difference Between Peaks and Valleys

// You are given an integer array nums of length n.

// An index i is called a peak if all of the following conditions hold:

// 0 < i < n - 1
// nums[i] > nums[i - 1]
// nums[i] > nums[i + 1]
// An index i is called a valley if all of the following conditions hold:

// 0 < i < n - 1
// nums[i] < nums[i - 1]
// nums[i] < nums[i + 1]
// Return an integer denoting the difference between the sum of all peak values and the sum of all valley values.

// Constraints:

// 3 <= n == nums.length <= 100
// -100 <= nums[i] <= 100


function peakValleyDifference(nums: number[]): number {
    let sumPeak = 0;
    let sumValley = 0;
    const n = nums.length;

    for (let i = 1; i < n-1; i++){
        if (nums[i] > nums[i-1] && nums[i] > nums[i+1]){
            sumPeak += nums[i];
        }

        if (nums[i] < nums[i-1] && nums[i] < nums[i+1]){
            sumValley += nums[i];
        }
    }

    return sumPeak - sumValley;
    
};

console.log(peakValleyDifference([1,5,2,4,1,3,0])); // Output: 9
console.log(peakValleyDifference([-5,-6,-1,-2,5,3,2])); // Output : 12
console.log(peakValleyDifference([6,5,2,5,5,3,6])); // Output: -5