function findDisappearedNumbers(nums: number[], lower: number, upper: number): number[][] {
    nums.sort((a,b) => a - b);
    let prev = lower - 1;

    let ans = [];

    // Add a missing range if valid
    function addRange(start, end){
        if (start <= end){
            ans.push([start,end]);
        }
    }


    for (let num of nums){
        // Gap between the previous and current number
        if (num < lower || num > upper || num == prev) continue;

        if (num > prev + 1){
            addRange(prev+1, num - 1);
        }

        prev = num;
    }

    // Add any remaining range
    if (prev < upper){
        addRange(prev + 1, upper);
    }

    return ans;
    

};


console.log(findDisappearedNumbers([3,9,7], 1, 12)); // Output: [[1,2],[4,6],[8,8],[10,12]]
console.log(findDisappearedNumbers([1,1], 5, 7)); // Output: [[5,7]]
console.log(findDisappearedNumbers([2,3,5], 2, 3)); // Output: []