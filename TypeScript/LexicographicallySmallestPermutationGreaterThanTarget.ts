
// 3720. Lexicographically Smallest Permutation Greater Than Target

// You are given two strings s and target, both having length n, consisting of lowercase English letters.

// Return the lexicographically smallest permutation of s that is strictly greater than target. If no permutation of s is lexicographically strictly greater than target, return an empty string.

// A string a is lexicographically strictly greater than a string b (of the same length) if in the first position where a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b.

let ans = '';

function dfs(path : string[], cnt : number[], target : string, big : boolean) : boolean {
    const n = target.length;
    if (ans !== '') return true;

    // Complete permutation
    if (path.length === n){
        if (big){
            ans = path.join('');
            return true;
        }
        return false;
    }


    const i = path.length;  

    // Try characters from smallest to largest 
    for (let c = 0; c < 26; c++){
        if (cnt[c] === 0) continue;

        // Can't become smaller than target
        if (!big && String.fromCharCode(c + 97) < target[i]) continue;

        path.push(String.fromCharCode(c+97));
        cnt[c]--;

        // Update with the newer lexicographical bigger
        const newBig = big || String.fromCharCode(c + 97) > target[i];

        if (dfs(path,cnt,target,newBig))return true;

        // Backtrack
        path.pop();
        cnt[c]++;
    } 

    return false;
}


function lexGreaterPermutation(s: string, target: string): string {
    let cnt = Array(26).fill(0);

    for (const c of s){
        cnt[c.charCodeAt(0) - 97]++;
    }

    // Reset global answer
    ans = '';
    dfs([], cnt, target, false);
    return ans;
};


console.log(lexGreaterPermutation("abc", "bba")); // Output: "bca"
console.log(lexGreaterPermutation("leet", "code")); // Output: "eelt"
console.log(lexGreaterPermutation("baba", "bbaa")); // Output: ""