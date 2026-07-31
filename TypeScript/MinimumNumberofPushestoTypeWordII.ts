function minimumPushes(word: string): number {
    const n = word.length;
    const frequency = new Array(26).fill(0);

    // Count each letter
    for (const ch of word){
        frequency[ch.charCodeAt(0) - 97] += 1;
    }

    // Place most frequent letters first
    frequency.sort((a,b) => b - a);

    let ans = 0;
    // Distribute characters evenly across 8 available keys
    for (let i = 0; i < 26; i++){
        ans += frequency[i] * (Math.floor(i/8) + 1);
    }

    return ans;
    
};

console.log(minimumPushes("abcde")); // Output: 5
console.log(minimumPushes("xyzxyzxyzxyz")); // Output: 12
console.log(minimumPushes("aabbccddeeffgghhiiiiii")); // Output: 24