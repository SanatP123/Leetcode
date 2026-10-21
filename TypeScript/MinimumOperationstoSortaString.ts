// Minimum Operations to Sort a String

// You are given a string s consisting of lowercase English letters.

// In one operation, you can select any substring of s that is not the entire string and sort it in non-descending alphabetical order.

// Return the minimum number of operations required to make s sorted in non-descending order. If it is not possible, return -1.

// Constraints:

// 1 <= s.length <= 105
// s consists of only lowercase English letters.


function minOperations(s: string): number {
    const n = s.length; 
    let mn = "z";
    let mx = "a";

    let sorted = true;

    for (let i = 0; i < n; i++){
        if (s[i] < mn){
            mn = s[i];
        }
        if (s[i] > mx){
            mx = s[i];
        }

        if (i > 0 && s[i-1] > s[i]){
            sorted = false;
        }
    }

    if (sorted) {
        return 0;
    }

    if (n === 2){
        return -1; 
    }

    if (s[0] === mn || s[n-1] === mx){
        return 1;
    }

    for(let i = 1; i < n-1; i++){
        if (s[i] === mn || s[i] === mx){
            return 2;
        }
    }

    return 3;
    
};


console.log(minOperations("dog")); // Output: 1
console.log(minOperations("card")); // Output: 2
console.log(minOperations("gf")); // Output: -1 
