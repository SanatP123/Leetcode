function findGCD(nums: number[]): number {
    var mn = Infinity;
    var mx = 0;

    mn = Math.min(...nums);
    mx = Math.max(...nums);

    return getGCD(mn, mx);
};

function getGCD(a: number, b: number) : number{
    if (b === 0) return a;
    return getGCD(b, a%b);
}

console.log(findGCD([2,5,6,9,10])); // Output: 2
console.log(findGCD([7,5,6,8,3])); // Output: 1
console.log(findGCD([3,3])); // Output: 3