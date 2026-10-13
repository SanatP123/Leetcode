// Maximum Alternating Sum of Squares

// You are given an integer array nums. You may rearrange the elements in any order.

// The alternating score of an array arr is defined as:

// score = arr[0]2 - arr[1]2 + arr[2]2 - arr[3]2 + ...
// Return an integer denoting the maximum possible alternating score of nums after rearranging its elements.

// Constraints:

// 1 <= nums.length <= 10^5
// -4 * 10^4 <= nums[i] <= 4 * 10^4

function maxAlternatingSum(nums: number[]): number {
    let squared = [];
    let n = nums.length;

    // Calculate squares of all numbers
    for (let i = 0; i < n; i++){
        squared.push(nums[i] * nums[i]);
    }

    // Sort in descending order to pair largest elements with smallest elements
    squared.sort((a,b) => (b-a));


    let start = 0;
    let end = squared.length - 1;

    let alternatingSquares = 0;

    // Alternately add largest values and subtract smallest values
    while (start < end){
        alternatingSquares += squared[start];
        start++;
        alternatingSquares -= squared[end];
        end--;
    }

    // Process the middle element if the array length is odd
    if (start === end){
        alternatingSquares += squared[start];
    }
    

    return alternatingSquares;
    
};

console.log(maxAlternatingSum([1,-1,2,-2,3,-3])); // Output: 16
console.log(maxAlternatingSum([1,2,3])); // Output: 12    


