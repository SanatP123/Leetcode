//  Minimum Moves to Equal Array Elements III

// You are given an integer array nums.

// In one move, you may increase the value of any single element nums[i] by 1.

// Return the minimum total number of moves required so that all elements in nums become equal.

function minMoves(nums: number[]): number {
    let max = Math.max(...nums);
    let moves = 0;
    
    for (const num of nums){
        moves += max - num;
    } 

    return moves;
    
};

console.log(minMoves([2,1,3])); // Output: 3    
console.log(minMoves([4,4,5])); // Output: 2