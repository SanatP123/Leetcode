function largestInteger(nums: number[], k: number): number {
    const map = new Map<number,number>();
    const n = nums.length;

    // Count frequency of each number
    for (let i = 0; i < n; i++){
        map.set(nums[i], (map.get(nums[i]) ?? 0) + 1);
    }

    // Entire array is the only subarray
    if (k == n){
        return Math.max(...nums);
    }

    // Find largest number occurring once
    if (k == 1){
        for (let i = 50; i >= 0; --i){
            if (map.get(i)! === 1){
                return i;
            }
        }
        return -1;
    }

    // Check the two endpoints
    let res = -1;
    if (map.get(nums[0])! === 1){
        res = Math.max(res, nums[0]);
    }
    if (map.get(nums[n-1])! === 1){
        res = Math.max(res, nums[n-1]);
    }

    return res;

    
};

console.log(largestInteger([3,9,2,1,7], 3)); // Output: 7
console.log(largestInteger([3,9,7,2,1,7], 4)); // Output: 3
console.log(largestInteger([0,0], 1)); // Output: -1