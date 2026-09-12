// 4048. Count Values With Equally Spaced Occurrences I

// You are given an integer array nums.

// An integer x is called special if:

// x appears at least three times in nums.
// All occurrences of x are equally spaced in nums. In other words, if all occurrences of x are at indices i1 < i2 < ... < im, then i2 - i1 = i3 - i2 = ... = im - im-1.
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
        if (values.length >= 3){
            if (checkEqualSpaces(values)){
                special++;
            }
        }
    }

    return special;
    
};

function checkEqualSpaces(vals : number[]) : boolean{
    let space = vals[1] - vals[0];
    for (let i = 1; i < vals.length; i++){
        if (vals[i] - vals[i-1] !== space){
            return false;
        }
    }

    return true;
}


console.log(countSpecialIntegers([1,8,1,5,1,5,8,5])); // Output: 2
console.log(countSpecialIntegers([8,8,8,8])); // Output: 1
console.log(countSpecialIntegers([8,6,6,8,8])); // Output: 0