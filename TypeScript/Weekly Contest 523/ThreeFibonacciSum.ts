// Three Fibonacci Sum

// You are given an integer n.

// The Fibonacci sequence starts with 0 and 1, and each subsequent number is the sum of the previous two numbers. Its first few terms are 0, 1, 1, 2, 3, 5, 8, 13, ....

// Return true if n can be expressed as the sum of three consecutive terms in the Fibonacci sequence, and false otherwise.

function threeFibonacciSum(n: number): boolean {
    let fibonacciSequence : number[] = [0,1];
    
    // Populate the fibonacciSequence upto n
    while (true){
        
        let length = fibonacciSequence.length;
        let fibvalue = fibonacciSequence[length - 1] + fibonacciSequence[length - 2];
        
        if (fibvalue > n){
            break;
        }
        fibonacciSequence.push(fibvalue);
    }

    // Check if three consecutive Fibonacci numbers sum up to n
    for (let i = 1; i < fibonacciSequence.length - 1; i++){
        let sum = fibonacciSequence[i-1] + fibonacciSequence[i] + fibonacciSequence[i+1];
        if (sum === n){
            return true;
        }
    }
    return false;
};



console.log(threeFibonacciSum(16)); // Output: true 
console.log(threeFibonacciSum(8)); // Output: false
console.log(threeFibonacciSum(2)); // Output: true 