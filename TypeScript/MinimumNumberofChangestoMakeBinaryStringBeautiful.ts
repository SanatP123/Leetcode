// Minimum Number of Changes to Make Binary String Beautiful

// You are given a 0-indexed binary string s having an even length.

// A string is beautiful if it's possible to partition it into one or more substrings such that:

// Each substring has an even length.
// Each substring contains only 1's or only 0's.
// You can change any character in s to 0 or 1.

// Return the minimum number of changes required to make the string s beautiful.


// Constraints:

// 2 <= s.length <= 105
// s has an even length.
// s[i] is either '0' or '1'.

function minChanges(s: string): number {
    let count = 0;

    for (let i = 1; i < s.length; i+=2){
        if (s[i] != s[i-1]){
            count += 1;
        }
    }

    return count;
    
};

console.log(minChanges("1001")); // Output: 2
console.log(minChanges("10")); // Output: 1
console.log(minChanges("1111")); // Output: 0