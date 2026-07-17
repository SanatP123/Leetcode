function gcdValues(nums: number[], queries: number[]): number[] {
    var gcdPairs: number[] = [];
    const n = nums.length;
    for (let i = 0; i < n; i++){
        for (let j = i+1; j < n; j++){
            gcdPairs.push(getGCD(nums[i],nums[j]));
        }
    }
    gcdPairs.sort((a,b) => a - b);

    var answer : number[] = [];

    for (let i = 0; i < queries.length; i++){
        answer[i] = gcdPairs[queries[i]];
    }

    return answer;
};

function getGCD(a: number, b: number) : number{
    // Euclidian algorithm
    if (b == 0) return a;
    return getGCD(b, a % b);
}

// Test Cases
console.log(gcdValues([2,3,4],[0,2,2])); // Output: [1,2,2]
console.log(gcdValues([4,4,2,1],[5,3,1,0])); // Output: [4,2,1,1]
console.log(gcdValues([2,2],[0,0])); // Output: [2, 2]