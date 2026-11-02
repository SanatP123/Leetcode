function minMoves2(nums: number[]): number {
    let n = nums.length;

    nums.sort((a,b) => a - b);

    const median = nums[Math.floor(n/2)];

    let moves = 0;

    for (const num of nums){
        moves += Math.abs(num - median);
    }

    return moves;

    
};

console.log(minMoves2([1,2,3])); // Output: 2
console.log(minMoves2([1,10,2,9])); // Output: 16
