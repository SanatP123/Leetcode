// Maximum Product of Two Elements in an Array

// Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
function maxProduct(nums: number[]): number {
    let firstMax = 0, secondMax = 0;
    let n = nums.length;

    for (let i = 0; i < n; i++){
        if (nums[i] > firstMax){
            secondMax = firstMax;
            firstMax = nums[i];
        }
        else if (nums[i] > secondMax){
            secondMax = nums[i];
        }
    }

    return (firstMax - 1) * (secondMax - 1);
    
};

console.log(maxProduct([3,4,5,2])); // Output: 12
console.log(maxProduct([1,5,4,5])); // Output: 16
console.log(maxProduct([3,7])); // Output: 36