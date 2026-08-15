function longestSubsequence(nums: number[]): number {
    let allzero : boolean = true;
    let xor : number = 0;

    for (let i = 0; i < nums.length; i++){
        xor ^= nums[i];
        if (nums[i] > 0){
            allzero = false;
        }
    }

    if(xor > 0){
        return nums.length;
    }

    return allzero ? 0 : nums.length - 1;

    
    
};

console.log(longestSubsequence([2,3,4])); // Output: 3
console.log(longestSubsequence([1,2,3])); // Output: 2