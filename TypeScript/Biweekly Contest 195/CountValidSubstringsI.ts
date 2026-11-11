// Count Valid Substrings I

// You are given a string s consisting only of the characters 'a', 'b', and 'c'.

// A string is called valid if it does not contain "abc" as a substring.

// Return the number of valid substrings in s. Substrings with different starting or ending indices are counted separately.

// A substring is a contiguous non-empty sequence of characters within a string.

// Constraints:

// 1 <= s.length <= 10^5​​​​​​​
// s only consists of 'a', 'b', and 'c' characters.
 
function countValidSubstrings(s: string): number {
    const n = s.length;

    let left = 0;
    let count = 0;

    for (let right = 0; right < n; right++){
        // Handle "abc" occurrences by iterating left pointer
        if (right >= 2 && s.substring(right - 2, right + 1) == "abc"){
            left = Math.max(left, right - 1);
        }

        // Every start in [left..right] yields a valid substring ending at right
        count += right - left + 1;
    }

    return count;
    
};

console.log(countValidSubstrings("abac")); // Output: 10
console.log(countValidSubstrings("abc")); // Output: 5  
console.log(countValidSubstrings("ac")); // Output: 3
console.log(countValidSubstrings("acbacabacccababcaacbaacbbbbcaaccbcaababcabcccccaabbacbaabaacbcbcbabbcabcaaccaaaabcbacabbbbcaaccbaaaacbabbbbbacbacaaaacbaacbcccbabcbaaaabbcaccaaccbaacbaccbbaabaccbacaccbaaabccacbacaacacbcccaacbbbbbbabababbbacbaccabaacbbcacbbcbbbaacabbabbcaacabbacabbacacccbbcbabacbbbabacbacbaacbcbacababcccbaaababaaccccbccbbbcaaacacbabcbabacaabccccbaabcbaaabcccabbacacaaaabcacacacacbbbbabababbcbaccbabcbcbbcccbcacaaabacabbbbcbcaaabcbccbcbacccbaaaababcaaccbcaaacccacbabbccaacbccbbbaabbccbcabababccbbbbabaacbaaabbbbacbaccbbacaaaccabbababcbcaaccabbbbbaabccacbaacabcccbacbaaaacbccbacbbccccbbaaccbcbaaabbacbaaaacbccbabaabbaabbaabbbbabacbcbabbbcbccbacbcbbbacacabcacbcaacaacccbccccacacabbaaaccababcccbacacbaabcaccbcccbbabaccabacabcaacccbcbabbccabbcbbcccbabbcbccbccccababbbcbcbacaacaccabbbbabbccbbbaaaabacbaacbbbbccbbcacabcabbbabcbbbbbcaccbbbbcbaccaaaabaaccabbcbbcaabcbcccabbbbbabcbbabacaccaccbcabccbcbabbbbcbbaccacbaabbbaabaacababacbabbacaccabbbaabbcccbacaacabccbbcacbacaacbccbcbbbcbbcacbaabcbccaabbbbabcbaccbabcabcbacabbcbac")); // Output: 27742