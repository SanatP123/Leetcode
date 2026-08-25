function missingMultiple(nums: number[], k: number): number {
    const set = new Set<number>(nums);
    let multiple = k;

    while (set.has(multiple)){
        multiple += k;
    }

    return multiple;
    
};

console.log(missingMultiple([8,2,3,4,6], 2)); // Output: 10
console.log(missingMultiple([1,4,7,10,15], 5)); // Output: 5
console.log(missingMultiple([42,13,99,13,71,32,64,32,63,44,6,22,8,2,55,88,43,40,71,80,95,32,46,19], 44)); // Output: 132