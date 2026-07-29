function sequentialDigits(low: number, high: number): number[] {
    const digits = "123456789";
    const res = [];

    // Compute the digit lengths of low and high
    const n = String(low).length;
    const m = String(high).length;

    for (let length = n; length <= m; length++){
        for (let i = 0; i < 10 - length; i++){
            // Convert the substring to an integer
            const num = Number(digits.slice(i, i + length));

            // If it lies between low and high, add it to the answer
            if (low <= num && num <= high){
                res.push(num);
            }
        }
    }

    return res;
    
};

console.log(sequentialDigits(100, 300)); // Output: [123, 234]
console.log(sequentialDigits(1000, 13000)); // Output: [1234, 2345, 3456, 4567, 5678, 6789, 12345]