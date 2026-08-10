function findLHS(nums: number[]): number {
    const freq = new Map<number,number>();


    for (const num of nums){
        freq.set(num, (freq.get(num) ?? 0) + 1);
    }

    let length = 0;
    for (const [num,count] of freq){
        if (freq.has(num+1)){
            length = Math.max(length,count+ freq.get(num+1)); 
        }
    }
    return length;
};


console.log(findLHS([1,3,2,2,5,2,3,7])); // Output: 5
console.log(findLHS([1,2,3,4])); // Output: 2
console.log(findLHS([1,1,1,1])); // Output: 0