function gcdOfOddEvenSums(n: number): number {
    let sumEven = n * (n + 1);
    let sumOdd = n*n;
    return getGCD(sumEven,sumOdd);


};

function getGCD(a: number, b:number) : number{
    if (b === 0) return a;

    return getGCD(b, a%b);
}


// Test Cases 
console.log(gcdOfOddEvenSums(5)); // Output: 5
console.log(gcdOfOddEvenSums(4)); // Output: 4