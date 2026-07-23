function uniqueXorTriplets(nums: number[]): number {
    const n = nums.length;

    // If there are fewer than 3 numbers, return the length directly,
    // as we can only form at most 'length' unique XOR values.
    if (n < 3) return n;

    // Find the smallest power of 2 greater than 'length'.
    // This represents the total number of unique XOR values possible
    // based on the number of bits required to represent the largest number.
    let powerOfTwo = 1;
    while (powerOfTwo <= n){
        powerOfTwo <<= 1;  // Left shift to multiply by 2
    }

    return powerOfTwo;
    
};

console.log(uniqueXorTriplets([1, 2])); // Output: 2
console.log(uniqueXorTriplets([3, 1, 2])); // Output: 4
