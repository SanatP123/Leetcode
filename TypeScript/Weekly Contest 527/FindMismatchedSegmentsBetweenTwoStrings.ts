// Find Mismatched Segments Between Two Strings

// You are given two strings s1 and s2 of the same length.

// A mismatched segment is a maximal contiguous range of indices where the characters of s1 and s2 differ at every index.

// Return a 2D array containing [sub1, sub2] for each mismatched segment, where sub1 and sub2 are the corresponding substrings from s1 and s2, respectively. Return the segments in increasing order of their starting indices. If there are no mismatched segments, return an empty array.

// Constraints:

// 1 <= s1.length == s2.length <= 100
// s1 and s2 consist of lowercase English letters.

function findMismatchedSegments(s1: string, s2: string): string[][] {
    const n = s1.length;
    let ans = [];
    let sub1 = "";
    let sub2 = "";

    for (let i = 0; i < n; i++){
        if (s1[i] === s2[i]){
            if (sub1 !== "" && sub2 !== ""){
                ans.push([sub1,sub2]);
                sub1 = "";
                sub2 = "";
            }
        }
        else{
            sub1 += s1[i];
            sub2 += s2[i];
        }
    }

    if (sub1 !== "" && sub2 !== ""){
            ans.push([sub1,sub2]);
    }

    return ans;
    
};

console.log(findMismatchedSegments("earth", "empty")); // Output: [["ar","mp"],["h","y"]]
console.log(findMismatchedSegments("action", "nation")); // Output: [["ac","na"]]
console.log(findMismatchedSegments("abc", "abc")); // Output: []