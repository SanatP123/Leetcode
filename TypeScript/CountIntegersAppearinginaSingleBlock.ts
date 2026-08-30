function countSpecialIntegers(nums: number[]): number {
    const map = new Map<number, number>();

    // Count total occurrences of each number
    for (const num of nums){
        map.set(num, (map.get(num) ?? 0) + 1);   
    }

    let start = 0;
    let special = 0;

    // Check each contiguous block
    for (let i = 0; i <= nums.length; i++){
        if (i === nums.length || nums[i] !== nums[start]){
            const num = nums[start];
            const blockLength = i - start;

            if (blockLength === map.get(num)){
                special++;
            }

            start = i;
        }
       
        
    }

    return special;
    
};


console.log(countSpecialIntegers([1,2,2,1])); // Output: 1
console.log(countSpecialIntegers([3,3,1,2,2,1])); // Output: 2
console.log(countSpecialIntegers([22])); // Output: 1
console.log(countSpecialIntegers([37,71])); // Output: 2