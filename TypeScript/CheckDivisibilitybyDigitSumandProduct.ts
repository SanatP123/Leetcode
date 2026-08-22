function checkDivisibility(n: number): boolean {
    const res : number[] = getDigitSumProduct(n);
    let sum : number = res[0] + res[1];
    return n % sum === 0; 
    
};

function getDigitSumProduct(n: number) : number[]{

    let sum = 0;
    let pro = 1;
    while (n > 0){
        let digit = n % 10;
        sum += digit;
        pro *= digit;
        n = Math.floor(n / 10);
    }

    return [sum, pro];
}

console.log(checkDivisibility(99)); // Output: true
console.log(checkDivisibility(23)); // Output: false