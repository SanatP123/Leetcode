// Rearrange Array by Removing Distinct Values

// You are given an integer array nums.

// You start with an empty array ans. Repeat the following operation until nums is empty:

// Identify all distinct values currently present in nums.
// Remove one occurrence of every distinct value currently in nums, and append those values to ans in ascending order.

// Return the array ans.

// Constraints:

// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100

function rearrangeArray(nums: number[]): number[] {
    let map = new Map<number,number>();
    let ans = [];

    // Count frequencies
    for (let i = 0; i < nums.length; i++){    
        map.set(nums[i], (map.get(nums[i]) ?? 0) + 1);
    }

    // Distinct values in ascending order
    const sortedNums = [...map.keys()].sort((a,b) => (a-b));

    const maxFreq = Math.max(...map.values());

    // Remove one of each value per round
    for (let i = 0; i < maxFreq; i++){
        for (const num of sortedNums){
            if (map.get(num)! > 0){
                ans.push(num);
                map.set(num, map.get(num)! - 1);
            }
        }
    }
    return ans;
};

console.log(rearrangeArray([3,1,3,2,1,3])); // Output: [1,2,3,1,3,3]
console.log(rearrangeArray([7,7,4,4,4])); // Output: [4,7,4,7,4]