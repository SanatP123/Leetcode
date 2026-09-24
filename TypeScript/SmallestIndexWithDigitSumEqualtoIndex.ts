// Smallest Index With Digit Sum Equal to Index

// You are given an integer array nums.

// Return the smallest index i such that the sum of the digits of nums[i] is equal to i.

// If no such index exists, return -1.


function smallestIndex(nums: number[]): number {

    for (let i = 0; i < nums.length; i++){
        if (sumOfDigits(nums[i]) === i){
            return i;
        }
    }

    return -1;
    
};

function sumOfDigits(num : number) : number {
    let digitSum = 0;

    while (num > 0){
        digitSum += num % 10;
        num = Math.floor(num / 10);
    }

    return digitSum;
}


console.log(smallestIndex([1,3,2])); // Output: 2
console.log(smallestIndex([1,2,3])); // Output: -1
console.log(smallestIndex([1,10,11])); // Output: 1