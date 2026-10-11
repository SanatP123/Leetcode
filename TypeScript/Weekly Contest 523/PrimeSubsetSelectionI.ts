// Prime Subset Selection I

// You are given two integers n and s.

// Consider all prime numbers less than or equal to n. Select some of these primes such that:

// The sum of the selected primes is less than or equal to s.
// The number of selected primes is maximized.
// Each prime can be selected at most once.
// Return an integer array containing the selected primes in increasing order. If multiple optimal selections exist, return any of them.

// If no prime can be selected, return an empty array.


function maxPrimes(n: number, s: number): number[] {
    let primes : number[] = [];

    // Create sieve array up to n initialized to true
    const isPrimeArray = new Array(n + 1).fill(true);

    // Mark non-prime numbers as false
    for (let i = 2; i * i <= n; i++) {
        if (isPrimeArray[i]) {
            for (let j = i * i; j <= n; j += i) {
                isPrimeArray[j] = false;
            }
        }
    }

    // Collect all generated primes up to n
    for(let i=2; i<=n; i++)
    {
  
      // check if current number is prime
      if(isPrimeArray[i]) {
          primes.push(i);
          }
    }

    if (primes.length === 0 || primes[0] > s){
        return [];
    }


    // Sliding Window to find longest sequence <= s
    let start = 0;
    let current = 0;

    let maxStart = 0;
    let maxLen = 0;

    for (let end = 0; end < primes.length; end++){
        current += primes[end];

        // Shrink window if limit s is exceeded
        while (current > s && start <= end){
            current -= primes[start];
            start++;
        }

        const currentLen = end - start + 1;

        if (currentLen > maxLen){
            maxLen = currentLen;
            maxStart = start;
        }
        
    }

    if (maxLen === 0){
        return [];
    }

    return primes.slice(maxStart, maxStart + maxLen);
    
};

console.log(maxPrimes(7, 20)); // Output: [2,3,5,7]  
console.log(maxPrimes(15, 15)); // Output: [3,5,7]
console.log(maxPrimes(5, 1)); // Output: []