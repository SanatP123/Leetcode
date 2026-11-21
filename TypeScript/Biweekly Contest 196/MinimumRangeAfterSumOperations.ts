// Minimum Range After Sum Operations

// You are given three integers a, b, and c.

// You may perform the following operation any number of times (including zero):

// Choose one of the three integers and replace it with the sum of the other two integers. The other two integers remain unchanged.
// The range of three integers is defined as the difference between the maximum value and the minimum value.

// Return the minimum range that can be obtained after performing the operation any number of times.

function minRange(a: number, b: number, c: number): number {
    let res1 = Math.max(a,b,c) - Math.min(a,b,c);
    let res2 = Math.max(b+c,b,c) - Math.min(b+c,b,c);
    let res3 = Math.max(a,a+c,c) - Math.min(a,a+c,c);
    let res4 = Math.max(a,b,a+b) - Math.min(a,b,a+b);

    return Math.min(res1,res2,res3,res4);
    
};

console.log(minRange(9,2,5)); // Output: 5
console.log(minRange(5,7,6)); // Output: 2
console.log(minRange(3,3,3)); // Output: 0