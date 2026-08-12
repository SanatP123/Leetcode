function maxSubarrayLength(nums: number[], k: number): number {
    const map = new Map<number,number>();

    const n = nums.length;
    let left = 0, ans = 0;

    for (let right = 0; right < n; right++){
        map.set(nums[right], (map.get(nums[right]) ?? 0) + 1);

        // Shrink until nums[right] appears at most k times
        while (map.get(nums[right])! > k){
            map.set(nums[left], map.get(nums[left])! - 1);
            left++;
        }

        ans = Math.max(ans, right - left + 1);
    }

    return ans;
    
};

console.log(maxSubarrayLength([1,2,3,1,2,3,1,2], 2)); // Output: 6
console.log(maxSubarrayLength([1,2,1,2,1,2,1,2], 1)); // Output: 2
console.log(maxSubarrayLength([5,5,5,5,5,5,5], 4)); // Output: 4