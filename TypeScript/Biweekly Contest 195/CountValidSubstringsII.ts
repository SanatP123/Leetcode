// Count Valid Substrings II

// You are given a string s consisting only of the characters 'a', 'b', and 'c'.

// A string is called valid if it does not contain "abc" as a subsequence.

// Return the number of valid substrings in s. Substrings with different starting or ending indices are counted separately.

// Constraints:

// 1 <= s.length <= 105​​​​​​​
// s only consists of 'a', 'b', and 'c' characters.

function countValidSubstrings(s: string): number {
    // Rightmost 'a' index, and the 'a'-index of the best "ab"/"abc" subsequence so far
    let lastA = -1;
    let lastAB = -1;
    let lastABC = -1;

    let ans = 0;

    for (let i = 0; i < s.length; i++){
        if (s[i] === 'a'){
            
            lastA = i;
        }
        else if (s[i] === 'b'){
             // Pair this 'b' with the latest 'a' before it
            lastAB = lastA;
        }
        else{
            // Pair this 'c' with the latest "ab" before it
            lastABC = lastAB;
        }

        // Valid starts for substrings ending at i are l > lastABC
        ans += i - lastABC;
    }

    return ans;
    
};

console.log(countValidSubstrings("abac")); // Output: 9
console.log(countValidSubstrings("abc")); // Output: 5  
console.log(countValidSubstrings("ac")); // Output: 3
