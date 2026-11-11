// Count Valid Suffix Sorts I

// You are given two integer arrays nums and target, both of length n.

// For each index i, consider sorting the suffix nums[i..n - 1] of the original array in non-increasing order.

// Return the number of indices i for which the resulting array is equal to target.

// A suffix of an array is a subarray that begins at any index and extends to the end of the array.

// Constraints:

// 1 <= n == nums.length == target.length <= 10^5
// 1 <= nums[i], target[i] <= 10​​​​​​​^5​​​​​​​​​​​​​​

function countSuffix(nums: number[], target: number[]): number {
    const n = nums.length;

    const map1 : Map<number, number> = new Map();
    const map2 : Map<number, number> = new Map();

    for (let i = 0; i < nums.length; i++){
        map1.set(nums[i], (map1.get(nums[i]) ?? 0) + 1);
        map2.set(target[i], (map2.get(target[i]) ?? 0) + 1);
    }

    if (map1.size !== map2.size){
        return 0;
    }

    for (const [key, value] of map1){
        if (map2.get(key) !== value){
            return 0;
        }
    }

    let p = 0;
    let q = n-1;

    for (let i = 0; i < n; i++){
        if (nums[i] !== target[i]){
            break;
        }
        p += 1;
    }

    for (let i = n-1; i > 0; i--){
        if (target[i-1] >= target[i]){
            q -= 1;
        }
        else{
            break;
        }
    }

    return Math.max(0, Math.min(p, n - 1) - q + 1)

    
};

console.log(countSuffix([1,2,3], [3,2,1])); // Output: 1
console.log(countSuffix([1,5,6,4,6], [1,5,6,6,4])); // Output: 2
console.log(countSuffix([7,6,8], [8,6,7])); // Output: 0