// Find Missing Elements
// You are given an integer array nums consisting of unique integers.
// Originally, nums contained every integer within a certain range. However, some integers might have gone missing from the array.
// The smallest and largest integers of the original range are still present in nums.
// Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.

function findMissingElements(nums: number[]): number[] {
    const ans : number[] = [];

    const st = new Set(nums);
    const minimum = Math.min(...nums);
    const maximum = Math.max(...nums);

    for (let i = minimum; i < maximum; i++){
        if (!st.has(i)){
            ans.push(i);
        }
    }

    return ans;    
};

console.log(findMissingElements([1,4,2,5])); // Output: [3]
console.log(findMissingElements([7,8,9,6])); // Output: []
console.log(findMissingElements([5,1])); // Output: [2,3,4]