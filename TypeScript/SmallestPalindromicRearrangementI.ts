// Smallest Palindromic Rearrangement I
// You are given a palindromic string s.
// Return the lexicographically smallest palindromic permutation of s.


function smallestPalindrome(s: string): string {
    if (s.length == 1){
        return s;
    }

    const partition = Math.floor(s.length / 2);

    // Sort the first half
    const base = s.substring(0, partition). split("").toSorted();

    // Middle character (if odd length).
    const mid = s.length % 2 === 1 ? s[partition] : "";

    // Mirror the first half.
    const reverse = base.toReversed();

    return base.concat(mid, reverse).join(""); 
};


console.log(smallestPalindrome("z")); // Output: "z"
console.log(smallestPalindrome("babab")); // Output: "abbba"
console.log(smallestPalindrome("daccad")); // Output: "acddca"