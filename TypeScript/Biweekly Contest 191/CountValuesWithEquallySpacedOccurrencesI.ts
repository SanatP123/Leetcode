// 4048. Count Values With Equally Spaced Occurrences I

// You are given an integer array nums.

// An integer x is called special if:

// x appears exactly three times in nums.
// All three occurrences of x are equally spaced in nums. In other words, if all occurrences of x are at indices i1 < i2 < i3, then i2 - i1 = i3 - i2.
// Return the number of distinct special integers in nums.

function countSpecialIntegers(nums: number[]): number {
    const map = new Map<number, number[]>();

    for (let i = 0; i < nums.length; i++){
        if (!map.has(nums[i])){
            map.set(nums[i], []);
        }
        map.get(nums[i])!.push(i);
    }

    let special = 0;

    for (const values of map.values()){
        if (values.length == 3){
            if (values[1] - values[0] === values[2] - values[1]){
                special++;
            }
        }
    }

    return special;


    
};


console.log(countSpecialIntegers([1,8,1,5,1,5,8,5])); // Output: 2
console.log(countSpecialIntegers([8,8,8,8])); // Output: 0
console.log(countSpecialIntegers([8,6,6,8,8])); // Output: 0