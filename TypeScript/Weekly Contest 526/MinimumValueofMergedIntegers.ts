// Minimum Value of Merged Integers

// You are given an integer array nums of even length n.

// You have to merge the elements of nums in pairs by merging nums[0] with nums[1], nums[2] with nums[3], and so on, until nums[n - 2] with nums[n - 1].

// Return the minimum value among all the resulting merged integers.

// To merge two integers, concatenate all the decimal digits of the first integer followed by all the decimal digits of the second integer.

function minMergedInteger(nums: number[]): number {
    const n = nums.length;
    let min = Infinity;
    let i = 1;

    while (i < n){
        let merged = concat(nums[i-1], nums[i]);
        if (merged < min){
            min = merged;
        }
        i += 2;
    }

    return min;
    
};

function concat(num1 : number, num2 : number) : number{
    let n1 : string = num1.toString();
    let n2 : string = num2.toString();

    let res : string = "";

    res += n1;
    res += n2;

    return Number(res);

}

console.log(minMergedInteger([23,55,42,21])); // Output: 2355    
console.log(minMergedInteger([34,7,11,11])); // Output: 347
console.log(minMergedInteger([9,20])); // Output: 920
console.log(minMergedInteger([46,45,78,34])); // Output: 4645