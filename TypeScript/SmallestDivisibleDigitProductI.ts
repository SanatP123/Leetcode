// You are given two integers n and t. Return the smallest number greater than or equal to n such that the product of its digits is divisible by t.

function smallestNumber(n: number, t: number): number {
    
    for (let i = n; ; i++){
        if (digitproduct(i) % t === 0){
            return i;
        }
    }

    function digitproduct(num : number) : number{
        let digit_pro = 1;
        while (num > 0){
            digit_pro *= num % 10;
            num = Math.floor(num / 10);
        }
        return digit_pro;
    }

    
};

console.log(smallestNumber(10, 2)); // Output: 10
console.log(smallestNumber(15, 3)); // Output: 16