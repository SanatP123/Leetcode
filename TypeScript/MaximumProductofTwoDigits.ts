// Maximum Product of Two Digits

// You are given a positive integer n.

// Return the maximum product of any two digits in n.

// Note: You may use the same digit twice if it appears more than once in n.

function maxProduct(n: number): number {
    let first = 0;
    let second = 0;

    while (n > 0){
        var digit = n % 10;

        if (digit > first){
            second = first;
            first = digit;
        }
        else if (digit > second){
            second = digit;
        }
        n = Math.floor(n/10);
    }

    return first * second;
    
};

console.log(maxProduct(31)); // Output: 3
console.log(maxProduct(22)); // Output: 4
console.log(maxProduct(124)); // Output: 8