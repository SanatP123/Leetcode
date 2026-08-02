// Maximize Pair Strength Using GCD

// You are given an integer array nums.

// Choose exactly one pair of distinct indices i and j. The strength of the pair is defined as (nums[i] * nums[j]) / gcd(nums[i], nums[j])2.

// Return the maximum strength over all possible pairs.

function maxPairStrength(nums: number[]): number {
    function getGCD(a : number, b: number){
        if (b == 0){
            return a;
        }
        return getGCD(b, a % b);
    }
    
    let strength = 0;

    for (let i = 0; i < nums.length; i++){
        for (let j = i + 1; j < nums.length; j++){
            let gcd = getGCD(nums[i],nums[j]);
            let value = (nums[i] * nums[j]) / (gcd * gcd);
            strength = Math.max(strength, value);
        }
    }

    return strength;
};


console.log(maxPairStrength([2,3,5])); // Output: 15
console.log(maxPairStrength([4,6,8])); // Output: 12
console.log(maxPairStrength([3,3])); // Output: 1