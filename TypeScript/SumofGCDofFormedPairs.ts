function gcdSum(nums: number[]): number {
    let prefixGCD : number[] = [];
    var currentMax = nums[0];

    // Build the prefixGCD array.
    for (let i = 0; i < nums.length; i++){
        currentMax = Math.max(currentMax,nums[i]);
        prefixGCD.push(getGCD(nums[i], currentMax));
    }

    // Sort to pair the smallest and largest values.
    prefixGCD.sort((a, b) => a - b);

    var left = 0;
    var right = prefixGCD.length - 1;

    var sum = 0;

    // Sum the GCD of each smallest-largest pair.
    while (left < right){
        sum += getGCD(prefixGCD[left],prefixGCD[right]);
        left++;
        right--;
    }

    return sum;

};

function getGCD(a: number, b:number) : number{
    // Euclidean algorithm.
    if (b === 0) return a;
    return getGCD(b, a%b);
}


// Test Cases
console.log(gcdSum([2,6,4])); // Output: 2
console.log(gcdSum([3,6,2,8])); // Output: 5
console.log(gcdSum([5,6,14])); // Output: 1